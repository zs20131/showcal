package com.showcal.send;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.tool
 *  Description:
 * ***************************************************************
 *  8/12 0012  V1.0  xiniu    New Files for com.xiniunet.single.tool
 * </pre>
 */
public class SMSTool {
    private static String server;
    private static String SpCode;
    private static String LoginName;
    private static String Password;
    private static SMSTool smsTool;

    //    private static final Log logger = LogFactory.getLog(SMSTool.class);
    private static final DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
    private static Map<String, String> errorMsg = new ConcurrentHashMap<>();

    static {
        errorMsg.put("100", "发送成功");
        errorMsg.put("101", "验证失败");
        errorMsg.put("102", "短信不足");
        errorMsg.put("103", "操作失败,");
        errorMsg.put("104", "非法字符");
        errorMsg.put("105", "内容过多");
        errorMsg.put("106", "号码过多");
        errorMsg.put("107", "频率过快");
        errorMsg.put("108", "号码内容空");
        errorMsg.put("110", "禁止频繁单条发送");
        errorMsg.put("112", "号码错误");
        errorMsg.put("113", "定时时间格式不对");
        errorMsg.put("114", "账号被锁");
        errorMsg.put("116", "禁止接口发送");
        errorMsg.put("117", "绑定IP不正确");
        errorMsg.put("120", "系统设置");
    }

    public static SMSTool getInstance() {
        if (smsTool == null) {
            try {
                Properties prop = new Properties();
                InputStream in = SMSTool.class.getResourceAsStream("/config.properties");
                prop.load(in);
                server = prop.getProperty("sms.server").trim();
                LoginName = prop.getProperty("sms.username").trim();
                Password = prop.getProperty("sms.password").trim();
                smsTool = new SMSTool();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return smsTool;
    }

    /**
     * 发送短信
     *
     * @param Message   消息内容
     * @param mobileNos 发送消息的手机号码
     * @return
     */
    public boolean SendMsg(String Message, String... mobileNos) {
        boolean isSuccess = false;
        try {
            if (StringUtils.isEmpty(Message) || mobileNos == null || mobileNos.length == 0) {
                isSuccess = false;
                return isSuccess;
            }
            StringBuffer mobiles = new StringBuffer();
            for (String mobileNo : mobileNos) {
                mobiles.append(mobileNo).append(",");
            }
            mobiles.deleteCharAt(mobiles.length() - 1);
//            String serialNumber = "showca" + df.format(new Date());
            String encode = "GBK";
            String straddr = server +
                    "?uid=" + URLEncoder.encode(LoginName, encode) +
                    "&pwd=" + EncryptUtil.MD5(Password + LoginName) +
                    "&mobile=" + URLEncoder.encode(mobiles.toString(), encode) +
                    "&content=" + URLEncoder.encode(Message, encode);

//            String url = server + "?SpCode=" + SpCode + "LoginName=" + URLEncoder.encode(LoginName, "gbk") +
//                         "&Password=" + URLEncoder.encode(Password, "gbk") + "&UserNumber=" +
//                            URLEncoder.encode(mobiles.toString(), "gbk") +
//                            "&MessageContent=" + URLEncoder.encode(Message, "gbk") + "&f=1"+
//                        "&SerialNumber="+serialNumber+"&ScheduleTime=";
            System.out.println(straddr);
            HttpClient client = new HttpClient();
            HttpMethod method = new GetMethod(straddr);
            client.executeMethod(method);
            //通过GET 方式请求
            method.getStatusLine();
            String response = method.getResponseBodyAsString();
            String status = "";
            if (response.contains(",")) {
                status = response.split(",")[0];
            }
            if ("0".equals(status)) {
                isSuccess = true;
            } else {
                System.out.println("send msg error : " + getErrorMsg(status));
            }
            System.out.println(URLDecoder.decode(response, "gbk"));
            //释放连接
            method.releaseConnection();
            return isSuccess;
        } catch (IOException e) {
            isSuccess = false;
            return isSuccess;
        }
    }

    public String getErrorMsg(String code) {
        if (errorMsg.containsKey(code)) {
            return errorMsg.get(code);
        } else {
            return "未知错误";
        }
    }

    public static void main(String[] args) {
        SMSTool smsTooll = SMSTool.getInstance();
        smsTooll.SendMsg("瘦咖提醒您：您的注册短信验证码为[OTS0]", "18662214246");
    }
}
