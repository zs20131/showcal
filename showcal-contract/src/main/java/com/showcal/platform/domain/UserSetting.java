package com.showcal.platform.domain;

import java.util.Date;

/**
 * Created by DEV003 on 2015/10/11.
 */
public class UserSetting {
    /**
     * 特殊情况
     */
    private Long diseaseId;

    /**
     *  月经周期
     */
    private Integer physiologyCycle;

    /**
     *  行经天数
     */
    private Integer physiologyDays;

    /**
     *  经期开始时间
     */
    private Date physiologyStart;

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getPhysiologyCycle() {
        return physiologyCycle;
    }

    public void setPhysiologyCycle(Integer physiologyCycle) {
        this.physiologyCycle = physiologyCycle;
    }

    public Integer getPhysiologyDays() {
        return physiologyDays;
    }

    public void setPhysiologyDays(Integer physiologyDays) {
        this.physiologyDays = physiologyDays;
    }

    public Date getPhysiologyStart() {
        return physiologyStart;
    }

    public void setPhysiologyStart(Date physiologyStart) {
        this.physiologyStart = physiologyStart;
    }
}
