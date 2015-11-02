package net.showcal.api.domain.mobile;
import java.util.Date;

/**
* <p/>
* <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
    *  Title: net.showcal.mobile.domain.Period
    *  Description: mobile Domain
    *  @since
    *  @author 顾志雄
    * ***************************************************************
 * </pre>
*/
public class Period {
    /**
     * 生理期开始时间
     */
    private  Date startPeriodDate;
    /**
     * 生理期结束时间
     */
    private  Date endPeriodDate;
    /**
     * 预测生理期开始时间
     */
    private  Date startForecast;
    /**
     * 预测生理期结束时间
     */
    private  Date endForecast;
    /**
     * 行版本号
     */
    private  long rowVersion;

    public  Date getStartPeriodDate(){
        return startPeriodDate;
    }

    public void setStartPeriodDate(Date startPeriodDate){
        this.startPeriodDate=startPeriodDate;
    }

    public  Date getEndPeriodDate(){
        return endPeriodDate;
    }

    public void setEndPeriodDate(Date endPeriodDate){
        this.endPeriodDate=endPeriodDate;
    }

    public  Date getStartForecast(){
        return startForecast;
    }

    public void setStartForecast(Date startForecast){
        this.startForecast=startForecast;
    }

    public  Date getEndForecast(){
        return endForecast;
    }

    public void setEndForecast(Date endForecast){
        this.endForecast=endForecast;
    }

    public  long getRowVersion(){
        return rowVersion;
    }

    public void setRowVersion(long rowVersion){
        this.rowVersion=rowVersion;
    }
}