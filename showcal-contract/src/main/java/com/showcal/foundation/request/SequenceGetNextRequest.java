package com.showcal.foundation.request;

import com.showcal.foundation.domain.SequenceTypeEnum;
import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class SequenceGetNextRequest extends BaseRequest {

    /**
     * 序列号代码
     */
    @NotNull
    @NotBlank
    @Length(min=1,max=50)
    private String SequenceCode;

    /**
     * 序列类型
     */
    private SequenceTypeEnum sequenceTypeEnum;

    /**
     * 补零长度
     */
    private Integer prefixLength;

    public String getSequenceCode() {
        return SequenceCode;
    }

    public void setSequenceCode(String sequenceCode) {
        SequenceCode = sequenceCode;
    }

    public SequenceTypeEnum getSequenceTypeEnum() {
        return sequenceTypeEnum;
    }

    public void setSequenceTypeEnum(SequenceTypeEnum sequenceTypeEnum) {
        this.sequenceTypeEnum = sequenceTypeEnum;
    }

    public Integer getPrefixLength() {
        return prefixLength;
    }

    public void setPrefixLength(Integer prefixLength) {
        this.prefixLength = prefixLength;
    }
}
