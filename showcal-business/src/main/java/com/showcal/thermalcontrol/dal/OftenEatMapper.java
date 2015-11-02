/**
 * @(#)OftenEatMapper.java  
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.thermalcontrol.dal;

import com.showcal.thermalcontrol.po.OftenEatPO;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 顾志雄 on 2015-09-23 13:32:27.
 *
 * @author 顾志雄
 */
@MyBatisRepository("ThermalcontrolOftenEatMapper")
public interface OftenEatMapper extends OftenEatMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") OftenEatPO request, @Param("passport") Passport passport);


}
