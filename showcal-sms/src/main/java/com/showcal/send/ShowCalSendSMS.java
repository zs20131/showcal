package com.showcal.send;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.send
 *  Description:
 * ***************************************************************
 *  10/23 0023  V1.0  xiniu    New Files for com.showcal.send
 * </pre>
 */
public class ShowCalSendSMS {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID_SHOWCAL_SMS");
        properties.put(PropertyKeyConst.AccessKey, "tNCKjDgxH84GDbRl");
        properties.put(PropertyKeyConst.SecretKey, "Mg1QihOlUEsuQtVtFZyAZtGXZEXjk8");
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("SHOWCAL_SMS", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                String messagestr = null;
                try {
                    messagestr = new String(message.getBody(),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println("消息 --->"+messagestr);
                SMSMessage smsMessage = JSON.parseObject(messagestr,SMSMessage.class);
                SMSTool.getInstance().SendMsg(smsMessage.getMessage(),smsMessage.getMobilePhone());
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("SHOWCAL SMS Start");
    }

}
