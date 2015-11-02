package net.showcal.api.internal.util;

import com.alibaba.fastjson.JSON;
import net.showcal.api.ApiException;
import net.showcal.api.Constants;
import net.showcal.api.XiniuResponse;
import net.showcal.api.internal.parser.json.JSONReader;
import net.showcal.api.internal.parser.json.JSONValidatingReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.utils
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for net.showcal.api.utils
 * </pre>
 */
public class ApiUtils {
    private static String localIp;

    private ApiUtils() {
    }

    /**
     * 给TOP请求签名。
     *
     * @param requestHolder 所有字符型的API请求参数
     * @param secret        签名密钥
     * @return 签名
     * @throws java.io.IOException
     */
    public static String signTopRequest(RequestParameters requestHolder, String secret) throws IOException {
        // 第一步：检查参数是否已经排序
        Map<String, String> params = requestHolder.getAllParams();
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder(secret);
        for(String key : keys) {
            String value = params.get(key);
            if(StringUtils.areNotEmpty(key, value)) {
                query.append(key).append(value);
            }
        }

        // 第三步：使用MD5加密
        byte[] bytes = encryptMD5(query.toString());

        // 第四步：把二进制转化为大写的十六进制
        return byte2hex(bytes);
    }

    /**
     * 给TOP请求签名。
     *
     * @param requestHolder 所有字符型的API请求参数
     * @param secret        签名密钥
     * @param isSHA1        是否为HMAC方式加密
     * @return 签名
     * @throws java.io.IOException
     */
    public static String signTopRequestNew(RequestParameters requestHolder, String secret, boolean isSHA1) throws IOException {
        return signTopRequestNew(requestHolder.getAllParams(), secret, isSHA1);
    }

    public static String signTopRequestNew(Map<String, String> paramValues, String secret, boolean isSHA1) throws IOException {

        StringBuilder sb = new StringBuilder();
        List<String> paramNames = new ArrayList<String>(paramValues.size());
        paramNames.addAll(paramValues.keySet());
            /*
            if(ignoreParamNames != null && ignoreParamNames.size() > 0){
                for (String ignoreParamName : ignoreParamNames) {
                    paramNames.remove(ignoreParamName);
                }
            }*/
        Collections.sort(paramNames);
        sb.append(secret);
        for(String paramName : paramNames) {
            sb.append(paramName).append(paramValues.get(paramName));
        }
        sb.append(secret);
        byte[] digests = null;
        if(isSHA1) {
            digests = encryptHMAC(sb.toString());
        } else {
            digests = encryptMD5(sb.toString());
        }
        return byte2hex(digests);

    }

    private static byte[] encryptHMAC(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            bytes = md.digest(data.getBytes("UTF-8"));
        } catch(GeneralSecurityException gse) {
            throw new IOException(gse);
        }
        return bytes;
    }

    private static String getStringFromException(Throwable e) {
        String result = "";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        e.printStackTrace(ps);
        try {
            result = bos.toString(Constants.CHARSET_UTF8);
        } catch(IOException ioe) {
        }
        return result;
    }

    private static byte[] encryptMD5(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes(Constants.CHARSET_UTF8));
        } catch(GeneralSecurityException gse) {
            String msg = getStringFromException(gse);
            throw new IOException(msg);
        }
        return bytes;
    }

    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * 验证TOP回调地址的签名是否合法。要求所有参数均为已URL反编码的。
     *
     * @param topParams  TOP私有参数（未经BASE64解密）
     * @param topSession TOP私有会话码
     * @param topSign    TOP回调签名
     * @param appKey     应用公钥
     * @param appSecret  应用密钥
     * @return 验证成功返回true，否则返回false
     * @throws java.io.IOException
     */
    public static boolean verifyTopResponse(String topParams, String topSession, String topSign,
                                            String appKey, String appSecret) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(appKey).append(topParams).append(topSession).append(appSecret);
        byte[] bytes = encryptMD5(result.toString());
        return Base64.encodeToString(bytes, false).equals(topSign);
    }

    /**
     * 解释TOP回调参数为键值对。(用于container回调时参数的解析)
     *
     * @param topParams 经过BASE64编码的字符串
     * @return 键值对
     * @throws java.io.IOException
     */
    public static Map<String, String> decodeTopParams(String topParams) throws IOException {
        return decodeTopParams(topParams, Constants.CHARSET_GBK);
    }

    /**
     * 解释TOP回调参数为键值对。(用于container回调时参数的解析)
     *
     * @param topParams 经过BASE64编码的字符串
     * @param charset   字符集编码
     * @return
     * @throws java.io.IOException
     */
    public static Map<String, String> decodeTopParams(String topParams, String charset) throws IOException {
        if(StringUtils.isEmpty(topParams)) {
            return null;
        }

        byte[] buffer = Base64.decode(WebUtils.decode(topParams).getBytes());
        String originTopParams = new String(buffer, charset);

        return WebUtils.splitUrlQuery(originTopParams);
    }


    public static final Map<String, String> mFileTypes = new HashMap<String, String>();

    static {
        // images
        mFileTypes.put("FFD8FF", "jpg");
        mFileTypes.put("89504E47", "png");
        mFileTypes.put("47494638", "gif");
        mFileTypes.put("49492A00", "tif");
        mFileTypes.put("424D", "bmp");
        //
        mFileTypes.put("41433130", "dwg"); // CAD
        mFileTypes.put("38425053", "psd");
        mFileTypes.put("7B5C727466", "rtf"); // 日记本
        mFileTypes.put("3C3F786D6C", "xml");
        mFileTypes.put("68746D6C3E", "html");
        mFileTypes.put("44656C69766572792D646174653A", "eml"); // 邮件
        mFileTypes.put("D0CF11E0", "doc");
        mFileTypes.put("CFAD12FEC5FD746F", "dbx");
        mFileTypes.put("2142444E", "pst");
        mFileTypes.put("D0CF11E0", "xls");
        mFileTypes.put("FF575043", "wpd");
        mFileTypes.put("5374616E64617264204A", "mdb");
        mFileTypes.put("252150532D41646F6265", "ps");
        mFileTypes.put("255044462D312E", "pdf");
        mFileTypes.put("504B0304", "docx");
        mFileTypes.put("52617221", "rar");
        mFileTypes.put("57415645", "wav");
        mFileTypes.put("41564920", "avi");
        mFileTypes.put("2E524D46", "rm");
        mFileTypes.put("000001BA", "mpg");
        mFileTypes.put("000001B3", "mpg");
        mFileTypes.put("6D6F6F76", "mov");
        mFileTypes.put("3026B2758E66CF11", "asf");
        mFileTypes.put("4D546864", "mid");
        mFileTypes.put("1F8B08", "gz");
        mFileTypes.put("504B0304", "zip");
        mFileTypes.put("3C646976", "vm");
        mFileTypes.put("7061636B", "java");

    }

    /**
     * 获取文件的真实媒体类型。目前只支持JPG, GIF, PNG, BMP四种图片文件。
     *
     * @param bytes 文件字节流
     * @return 媒体类型(MEME-TYPE)
     */
    public static String getMimeType(byte[] bytes) {
        String filetypeHex = getFileHeader(bytes);
        Iterator<String> filetypes = mFileTypes.keySet().iterator();
        while(filetypes.hasNext()) {
            String tempfile = filetypes.next();
            if(filetypeHex.toUpperCase().startsWith(tempfile)) {
                return mFileTypes.get(tempfile);
            }
        }
        return null;
    }

    /**
     * 获取文件头信息
     *
     * @param bytes 文件字节流
     * @return JPG, GIF, PNG or null
     */
    public static String getFileHeader(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        if(bytes == null || bytes.length <= 0) {
            return null;
        }
        int length = 15;
        if(bytes.length < length) {
            length = bytes.length;
        }
        String hv;
        for(int i = 0; i < length; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
            if(hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }

    /**
     * 清除字典中值为空的项。
     *
     * @param <V> 泛型
     * @param map 待清除的字典
     * @return 清除后的字典
     */
    public static <V> Map<String, V> cleanupMap(Map<String, V> map) {
        if(map == null || map.isEmpty()) {
            return null;
        }

        Map<String, V> result = new HashMap<String, V>(map.size());
        Set<Map.Entry<String, V>> entries = map.entrySet();

        for(Map.Entry<String, V> entry : entries) {
            if(entry.getValue() != null) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    /**
     * 把JSON字符串转化为Map结构。
     *
     * @param body JSON字符串
     * @return Map结构
     */
    public static Map<?, ?> parseJson(String body) {
        JSONReader jr = new JSONValidatingReader();
        Object obj = jr.read(body);
        if(obj instanceof Map<?, ?>) {
            return (Map<?, ?>) obj;
        } else {
            return null;
        }
    }

    /**
     * 把JSON字符串解释为对象结构。
     *
     * @param <T>   API响应类型
     * @param json  JSON字符串
     * @param clazz API响应类
     * @return API响应对象
     */
    public static <T extends XiniuResponse> T parseResponse(String json, Class<T> clazz) throws ApiException {
        T rsp = JSON.parseObject(json, clazz);
        rsp.setBody(json);
        return rsp;
    }

    /**
     * 获取本机的网络IP
     */
    public static String getLocalNetWorkIp() {
        if(localIp != null) {
            return localIp;
        }
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while(netInterfaces.hasMoreElements()) {// 遍历所有的网卡
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                if(ni.isLoopback() || ni.isVirtual()) {// 如果是回环和虚拟网络地址的话继续
                    continue;
                }
                Enumeration<InetAddress> addresss = ni.getInetAddresses();
                while(addresss.hasMoreElements()) {
                    InetAddress address = addresss.nextElement();
                    if(address instanceof Inet4Address) {// 这里暂时只获取ipv4地址
                        ip = address;
                        break;
                    }
                }
                if(ip != null) {
                    break;
                }
            }
            if(ip != null) {
                localIp = ip.getHostAddress();
            } else {
                localIp = "127.0.0.1";
            }
        } catch(Exception e) {
            localIp = "127.0.0.1";
        }
        return localIp;
    }
}
