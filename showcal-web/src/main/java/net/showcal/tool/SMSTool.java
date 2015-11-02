package net.showcal.tool;

import com.xiniunet.framework.util.EncryptUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

    private static final Log logger = LogFactory.getLog(SMSTool.class);
    private static final DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
    private static Map<String, String> errorMsg = new HashMap<>();

//    static {
//        errorMsg.put("0", "发送短信成功");
//        errorMsg.put("1", "提交参数不能为空");
//        errorMsg.put("2", "账号无效或权限不足");
//        errorMsg.put("3", "账号密码错误,");
//        errorMsg.put("4", "预约发送时间格式不正确，应为yyyyMMddHHmmss");
//        errorMsg.put("5", "IP不合法,");
//        errorMsg.put("6", "号码中含有无效号码或不在规定的号段或为免打扰号码");
//        errorMsg.put("7", "非法关键字");
//        errorMsg.put("8", "内容长度超过上限，最大402字符");
//        errorMsg.put("9", "接受号码过多，最大1000");
//        errorMsg.put("10", "黑名单用户");
//        errorMsg.put("11", "提交速度太快");
//        errorMsg.put("12", "您尚未订购[普通短信业务]，暂不能发送该类信息");
//        errorMsg.put("13", "您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息");
//        errorMsg.put("14", "流水号格式不正确");
//        errorMsg.put("15", "流水号重复");
//        errorMsg.put("16", "超出发送上限（操作员帐户当日发送上限）");
//        errorMsg.put("17", "余额不足");
//        errorMsg.put("18", "扣费不成功");
//        errorMsg.put("20", "系统错误");
//        errorMsg.put("21", "密码错误次数达到5次");
//        errorMsg.put("24", "帐户状态不正常");
//        errorMsg.put("25", "账户权限不足");
//        errorMsg.put("26", "需要人工审核");
//        errorMsg.put("28", "发送内容与模板不符");
//        errorMsg.put("29", "扩展号太长或不是数字&accnum=");
//        errorMsg.put("32", "同一号码相同内容发送次数太多");
//
//    }

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
                logger.info("send msg error : " + getErrorMsg(status));
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
