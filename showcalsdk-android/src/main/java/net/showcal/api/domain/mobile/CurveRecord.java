package net.showcal.api.domain.mobile;

/**
* <p/>
* <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
    *  Title: net.showcal.mobile.domain.CurveRecord
    *  Description: mobile Domain
    *  @since
    *  @author 顾志雄
    * ***************************************************************
 * </pre>
*/
public class CurveRecord {
    /**
     * 记录类型
     */
    private  CurveTypeEnum type;
    /**
     * 
     */
    private  Double value;
    /**
     * 行版本号
     */
    private  long rowVersion;

    public  CurveTypeEnum getType(){
        return type;
    }

    public void setType(CurveTypeEnum type){
        this.type=type;
    }

    public  Double getValue(){
        return value;
    }

    public void setValue(Double value){
        this.value=value;
    }

    public  long getRowVersion(){
        return rowVersion;
    }

    public void setRowVersion(long rowVersion){
        this.rowVersion=rowVersion;
    }
}