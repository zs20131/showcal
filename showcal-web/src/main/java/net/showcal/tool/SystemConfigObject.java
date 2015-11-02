package net.showcal.tool;

import com.xiniunet.framework.util.SettingUtil;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.tool
 *  Description: 系统配置信息
 * ***************************************************************
 *  8/4 0004  V1.0  xiniu    New Files for com.xiniunet.single.tool
 * </pre>
 */
public class SystemConfigObject {
    /**
     * 获取云文件的默认服务器地址
     * @return  地址
     */
    public String getOssUrl(String url) {
        return SettingUtil.getProperty("config.properties", "aliyun.oss.url") + url;
    }

    /**
     * 获取云图片处理的默认服务器地址
     * @return  地址
     */
    public String getImgUrl(String url) {
        return SettingUtil.getProperty("config.properties", "aliyun.img.url") + url;
    }

    /**
     * 获取config.properties文件里的配置
     * @param key       key
     * @return          key对应的值
     */
    public String getConfig(String key) {
        return SettingUtil.getProperty("config.properties", key);
    }

}
