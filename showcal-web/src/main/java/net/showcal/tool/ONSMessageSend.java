package net.showcal.tool;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;

import java.util.Properties;


/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.tool
 *  Description:
 * ***************************************************************
 *  10/23 0023  V1.0  xiniu    New Files for net.showcal.tool
 * </pre>
 */
public class ONSMessageSend {
    private static Properties properties = new Properties();
    private static Producer producer;
    static {
        properties.put(PropertyKeyConst.ProducerId, "PID_SHOWCAL_SMS");
        properties.put(PropertyKeyConst.AccessKey, "tNCKjDgxH84GDbRl");
        properties.put(PropertyKeyConst.SecretKey, "Mg1QihOlUEsuQtVtFZyAZtGXZEXjk8");
        producer = ONSFactory.createProducer(properties);
        producer.start();
    }

    public static void sendSms(String mobielPhone,String message){
        SMSMessage smsMessage = new SMSMessage();
        smsMessage.setMobilePhone(mobielPhone);
        smsMessage.setMessage(message);
        String  sendmessagestr = JSON.toJSONString(smsMessage);
        System.out.println(sendmessagestr);
        Message msg = new Message(
                //Message Topic
                "SHOWCAL_SMS",
                //Message Tag,
                //可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在ONS服务器过滤
                "SMSMESSAGE",
                //Message Body
                //任何二进制形式的数据，ONS不做任何干预，需要Producer与Consumer协商好一致的序列化和反序列化方式
                sendmessagestr.getBytes()
        );
        producer.send(msg);
    }
}
