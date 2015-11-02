package net.showcal.tool;

import org.apache.velocity.app.Velocity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by edward on 9/17/14.
 */
public class BaseUtil {

    public static final String ERROR_MESSAGE_500 = "服务器走了下神，稍后再试一次";
    public static final String NOT_EXIST_METHOD = "调用的方法不存在";

    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        return properties;
    }

    /**
     * 格式化时间
     *
     * @param date   要格式化的时间
     * @param format 格式
     * @return 格式化后的时间
     */
    public String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String reduceTimes(String startDate) {
        if (startDate == null) {
            return null;
        }
        StringBuffer sb=new StringBuffer();
        sb.append(startDate).append(" ");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sDate=null;
        Date eDate=null;
        try{
            sDate=sdf.parse(sb.toString());
            eDate=sdf1.parse(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Long time=(new Date()).getTime()-sDate.getTime();
        long hour=time/60/60/1000;
        if(hour>24){
            return hour/24+"天前";
        }
        else if(hour<1){
            return (new Date().getTime()-eDate.getTime())/60/1000+"分钟前";
        }
        else{
            return hour+"小时前";
        }

    }
}
