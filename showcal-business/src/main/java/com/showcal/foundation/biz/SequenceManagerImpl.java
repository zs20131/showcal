/**
 * @(#)Sequence.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.biz;

import com.showcal.foundation.dal.*;
import com.showcal.foundation.domain.SequenceTypeEnum;
import com.showcal.foundation.po.*;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.foundation.request.SequenceGetNextRequest;
import com.showcal.foundation.response.IdsGetResponse;
import com.showcal.foundation.response.SequenceGetNextResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class SequenceManagerImpl extends BaseManagerImpl implements SequenceManager {

    // 序列号更新时的最大重试次数
    private static final int RETRY_LIMIT = 100;

    // 错误CODE
    private static final String ERR_CUSTOM = "ERR_CUSTOM";

    //@Autowired
    private static final Long workerId = 1L;
    //@Autowired
    private static final Long datacenterId = 3L;

    private long sequence = 0L;

    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private long maxWorkerId = ~(-1L << workerIdBits);
    private long maxDatacenterId = ~(-1L << datacenterIdBits);
    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private final long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimestamp = -1L;

    @Autowired
    private SequenceMapper sequenceMapper;

    @Autowired
    private SequenceByDateMapper sequenceByDateMapper;

    @Autowired
    private SequenceByMonthMapper sequenceByMonthMapper;

    @Autowired
    private SequenceByYearMapper sequenceByYearMapper;

    @Autowired
    private SequenceStandardMapper sequenceStandardMapper;

    /**
     * 根据代码获取编号
     *
     * @param req      序列号代码
     * @param passport 用户护照
     * @return 下一个编号
     */
    public SequenceGetNextResponse getNextSequence(SequenceGetNextRequest req, Passport passport) {
        SequenceGetNextResponse response = new SequenceGetNextResponse();

        // 根据请求内容获取对应的序列号信息
        SequencePO sequencePO = sequenceMapper.getByCode(req.getSequenceCode());
        Date now = new Date();
        SimpleDateFormat sdfdate = null;

        // 如果序列号信息表中没有任何信息
        if (sequencePO == null) {
            sequencePO = new SequencePO();
            sequencePO.setId(getNewId());
            // 如果传入了枚举值，则根据枚举的内容进行处理
            if (req.getSequenceTypeEnum() != null) {
                sequencePO.setType(req.getSequenceTypeEnum().toString());
            } else {
                sequencePO.setType(SequenceTypeEnum.BY_DATE.toString());
            }
            sequencePO.setCode(req.getSequenceCode());
            sequencePO.setPrefix("");
            // 默认设5位长度
            if (req.getPrefixLength() != null) {
                sequencePO.setLength(req.getPrefixLength());
            } else {
                sequencePO.setLength(5);
            }

            long result = sequenceMapper.insert(sequencePO, passport);
            if (result != 1) {
                response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                return response;
            }

            sdfdate = new SimpleDateFormat("yyyyMMdd");
            Integer dateId = new Integer(sdfdate.format(now));

            SequenceByDatePO sequenceByDatePO = new SequenceByDatePO();
            sequenceByDatePO.setId(getNewId());
            sequenceByDatePO.setDateId(dateId);
            sequenceByDatePO.setSequenceId(sequencePO.getId());
            sequenceByDatePO.setValue(1);
            sequenceByDatePO.setRowVersion(0l);
            result = sequenceByDateMapper.insert(sequenceByDatePO, passport);
            if (result != 1) {
                response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                return response;
            }

            response.setSeqNumber(dateId.toString() + StringUtil.fixNumberLength(1, sequencePO.getLength()));

        } else {
            // 设定初始值
            long updateResult = 0L;
            int retryCount = 0;

            // 如果有信息，则判定类型并算出最终序列号
            switch (sequencePO.getType()) {
                case "BY_DATE":
                    SequenceByDatePO sequenceByDatePO = sequenceByDateMapper.getBySeqId(sequencePO.getId(), passport);

                    sdfdate = new SimpleDateFormat("yyyyMMdd");
                    Integer dateId = new Integer(sdfdate.format(now));

                    if (sequenceByDatePO == null) {                    // 如果还没有生成过序列号
                        sequenceByDatePO = new SequenceByDatePO();
                        sequenceByDatePO.setId(getNewId());
                        sequenceByDatePO.setDateId(dateId);
                        sequenceByDatePO.setSequenceId(sequencePO.getId());
                        sequenceByDatePO.setValue(1);
                        sequenceByDatePO.setRowVersion(0l);
                        long result = sequenceByDateMapper.insert(sequenceByDatePO, passport);
                        if (result != 1) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                        String seqNumber = sequencePO.getPrefix() + dateId.toString() + StringUtil.fixNumberLength(1, sequencePO.getLength());
                        response.setSeqNumber(seqNumber);
                    } else {
                        while (updateResult == 0L && retryCount < RETRY_LIMIT) {
                            // 如果已经生成过序列号，则判定当前是否为同一天
                            // 如果是同一天，直接更新
                            if (sequenceByDatePO.getDateId().equals(dateId)) {
                                // 每次更新之前，重新获取最新序列号信息
                                sequenceByDatePO = sequenceByDateMapper.getBySeqId(sequencePO.getId(), passport);
                                // 获取下一个序列号
                                sequenceByDatePO.setValue(sequenceByDatePO.getValue() + 1);
                                // 更新序列号
                                updateResult = sequenceByDateMapper.update(sequenceByDatePO, passport);
                                retryCount++;

                                Integer newSeqId = sequenceByDatePO.getValue();
                                String seqNumber = sequencePO.getPrefix() + dateId.toString() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                                response.setSeqNumber(seqNumber);
                            } else {
                                // 每次更新之前，重新获取最新序列号信息
                                sequenceByDatePO = sequenceByDateMapper.getBySeqId(sequencePO.getId(), passport);
                                // 获取下一个序列号
                                sequenceByDatePO.setDateId(dateId);
                                // 序列号归1
                                sequenceByDatePO.setValue(1);
                                // 更新序列号
                                updateResult = sequenceByDateMapper.update(sequenceByDatePO, passport);
                                retryCount++;

                                Integer newSeqId = sequenceByDatePO.getValue();
                                String seqNumber = sequencePO.getPrefix() + dateId.toString() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                                response.setSeqNumber(seqNumber);
                            }
                        }
                        if (response.getSeqNumber() == null) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                    }
                    break;
                case "BY_MONTH":
                    SequenceByMonthPO sequenceByMonthPO = sequenceByMonthMapper.getBySeqId(sequencePO.getId(), passport);

                    sdfdate = new SimpleDateFormat("yyyyMM");
                    Integer monthId = new Integer(sdfdate.format(now));

                    if (sequenceByMonthPO == null) {                    // 如果还没有生成过序列号
                        sequenceByMonthPO = new SequenceByMonthPO();
                        sequenceByMonthPO.setId(getNewId());
                        sequenceByMonthPO.setMonthId(monthId);
                        sequenceByMonthPO.setSequenceId(sequencePO.getId());
                        sequenceByMonthPO.setValue(1);
                        sequenceByMonthPO.setRowVersion(0l);
                        long result = sequenceByMonthMapper.insert(sequenceByMonthPO, passport);
                        if (result != 1) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                        String seqNumber = sequencePO.getPrefix() + monthId.toString() + StringUtil.fixNumberLength(1, sequencePO.getLength());
                        response.setSeqNumber(seqNumber);
                    } else {
                        while (updateResult == 0L && retryCount < RETRY_LIMIT) {
                            // 如果已经生成过序列号，则判定当前是否为同一天
                            // 如果是同一月，直接更新
                            if (sequenceByMonthPO.getMonthId().equals(monthId)) {
                                // 每次更新之前，重新获取最新序列号信息
                                sequenceByMonthPO = sequenceByMonthMapper.getBySeqId(sequencePO.getId(), passport);
                                // 获取下一个序列号
                                sequenceByMonthPO.setValue(sequenceByMonthPO.getValue() + 1);
                                // 更新序列号
                                updateResult = sequenceByMonthMapper.update(sequenceByMonthPO, passport);
                                retryCount++;

                                Integer newSeqId = sequenceByMonthPO.getValue();
                                String seqNumber = sequencePO.getPrefix() + monthId.toString() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                                response.setSeqNumber(seqNumber);
                            } else {
                                // 每次更新之前，重新获取最新序列号信息
                                sequenceByMonthPO = sequenceByMonthMapper.getBySeqId(sequencePO.getId(), passport);
                                // 获取下一个序列号
                                sequenceByMonthPO.setMonthId(monthId);
                                // 序列号归1
                                sequenceByMonthPO.setValue(1);
                                // 更新序列号
                                updateResult = sequenceByMonthMapper.update(sequenceByMonthPO, passport);
                                retryCount++;

                                Integer newSeqId = sequenceByMonthPO.getValue();
                                String seqNumber = sequencePO.getPrefix() + monthId.toString() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                                response.setSeqNumber(seqNumber);
                            }
                        }
                        if (response.getSeqNumber() == null) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                    }
                    break;
                case "BY_YEAR":
                    SequenceByYearPO sequenceByYearPO = sequenceByYearMapper.getBySeqId(sequencePO.getId(), passport);

                    sdfdate = new SimpleDateFormat("yyyy");
                    Integer yearId = new Integer(sdfdate.format(now));

                    if (sequenceByYearPO == null) {                    // 如果还没有生成过序列号
                        sequenceByYearPO = new SequenceByYearPO();
                        sequenceByYearPO.setId(getNewId());
                        sequenceByYearPO.setYearId(yearId);
                        sequenceByYearPO.setSequenceId(sequencePO.getId());
                        sequenceByYearPO.setValue(1);
                        sequenceByYearPO.setRowVersion(0l);
                        long result = sequenceByYearMapper.insert(sequenceByYearPO, passport);
                        if (result != 1) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                        String seqNumber = sequencePO.getPrefix() + yearId.toString() + StringUtil.fixNumberLength(1, sequencePO.getLength());
                        response.setSeqNumber(seqNumber);
                    } else {
                        while (updateResult == 0L && retryCount < RETRY_LIMIT) {
                            // 如果已经生成过序列号，则判定当前是否为同一天
                            // 如果是同一年，直接更新
                            if (sequenceByYearPO.getYearId().equals(yearId)) {
                                // 每次更新之前，重新获取最新序列号信息
                                sequenceByYearPO = sequenceByYearMapper.getBySeqId(sequencePO.getId(), passport);
                                // 获取下一个序列号
                                sequenceByYearPO.setValue(sequenceByYearPO.getValue() + 1);
                                // 更新序列号
                                updateResult = sequenceByYearMapper.update(sequenceByYearPO, passport);
                                retryCount++;

                                Integer newSeqId = sequenceByYearPO.getValue();
                                String seqNumber = sequencePO.getPrefix() + yearId.toString() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                                response.setSeqNumber(seqNumber);
                            } else {
                                // 每次更新之前，重新获取最新序列号信息
                                sequenceByYearPO = sequenceByYearMapper.getBySeqId(sequencePO.getId(), passport);
                                // 获取下一个序列号
                                sequenceByYearPO.setYearId(yearId);
                                // 序列号归1
                                sequenceByYearPO.setValue(1);
                                // 更新序列号
                                updateResult = sequenceByYearMapper.update(sequenceByYearPO, passport);
                                retryCount++;

                                Integer newSeqId = sequenceByYearPO.getValue();
                                String seqNumber = sequencePO.getPrefix() + yearId.toString() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                                response.setSeqNumber(seqNumber);
                            }
                        }
                        if (response.getSeqNumber() == null) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                    }
                    break;
                case "STANDARD":
                    SequenceStandardPO sequenceStandardPO = sequenceStandardMapper.getBySeqId(sequencePO.getId(), passport);

                    if (sequenceStandardPO == null) {                    // 如果还没有生成过序列号
                        sequenceStandardPO = new SequenceStandardPO();
                        sequenceStandardPO.setId(getNewId());
                        sequenceStandardPO.setSequenceId(sequencePO.getId());
                        sequenceStandardPO.setValue(1);
                        sequenceStandardPO.setRowVersion(0l);
                        long result = sequenceStandardMapper.insert(sequenceStandardPO, passport);
                        if (result != 1) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                        String seqNumber = sequencePO.getPrefix() + StringUtil.fixNumberLength(1, sequencePO.getLength());
                        response.setSeqNumber(seqNumber);
                    } else {
                        while (updateResult == 0L && retryCount < RETRY_LIMIT) {
                            // 每次更新之前，重新获取最新序列号信息
                            sequenceStandardPO = sequenceStandardMapper.getBySeqId(sequencePO.getId(), passport);
                            // 获取下一个序列号
                            sequenceStandardPO.setValue(sequenceStandardPO.getValue() + 1);
                            // 更新序列号
                            updateResult = sequenceStandardMapper.update(sequenceStandardPO, passport);
                            retryCount++;

                            Integer newSeqId = sequenceStandardPO.getValue();
                            String seqNumber = sequencePO.getPrefix() + StringUtil.fixNumberLength(newSeqId, sequencePO.getLength());
                            response.setSeqNumber(seqNumber);
                        }
                        if (response.getSeqNumber() == null) {
                            response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                            return response;
                        }
                    }
                    break;
                default:
                    response.addError(ErrorType.BUSINESS_ERROR, "创建序列号失败");
                    return response;
            }
        }
        return response;
    }

    /**
     * 获取下一个唯一编号
     *
     * @return 唯一编号
     */
    @Transactional(readOnly = true)
    public synchronized Long getNewId() {
//        workerId = 1L;
//        datacenterId = 3L;

        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            // 时序倒转时报错，理论上不可能发生
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 如果本毫秒内执行超过限定次数，则等待到下一毫秒继续执行，理论上不可能发生
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        long twepoch = 1288834974657L;
        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    @Override
    public IdsGetResponse getNewIds(IdsGetRequest req) {
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < req.getCount(); i++) {
            ids.add(getNewId());
        }
        IdsGetResponse response = new IdsGetResponse();
        response.setIds(ids);
        return response;
    }

    protected long tilNextMillis(long lastTimestamp) {
        // 如果本毫秒内执行超过限定次数，则等待到下一毫秒继续执行，理论上不可能执行本方法
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
