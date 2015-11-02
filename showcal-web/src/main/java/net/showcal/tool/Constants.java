package net.showcal.tool;


import com.xiniunet.framework.security.Passport;
import org.apache.velocity.app.Velocity;

import java.util.Properties;

/**
 * Created by edward on 9/17/14.
 */
public class Constants {

    public static final String ERROR_MESSAGE_500 = "服务器走了下神，稍后再试一次";
    public static final String NOT_EXIST_METHOD = "调用的方法不存在";
    public static final String NOT_EXIST_DATA = "未找到数据,请确保数据存在于第一张Sheet表中";

    public static final String SESSION_NAME = "SHOWCAL_SESSION";
    public static final String ADMIN_FORWORD = "platformLink";
    public static final String CUSTOMER_FORWORD = "showcalLink";
    public static final String LOGIN_USER_NAME = "loginUser";
    /** Login页面返回URL的key。 */
    public static final String LOGIN_RETURN_KEY = "return";

    /** 如果未指定return，登录以后就跳到该URL。 */
    public static final String LOGIN_RETURN_DEFAULT_LINK = "homeLink";

    /** 登录URL的名字。 */
    public static final String BASE_LOGIN_LINK = "LoginLink";



    public String title() {
        Passport passport = new Passport();
        passport.setUserId(1l);
//        SiteSearchRequest searchRequest = new SiteSearchRequest();
//        SiteSearchResponse searchResponse = singleHelper.searchSite(searchRequest, passport);
//
//        if (!searchResponse.getResult().isEmpty()) {
//            return searchResponse.getResult().get(0).getName();
//        }
        return null;
    }

    public String keywords() {
        Passport passport = new Passport();
        passport.setUserId(1l);
//        SiteSearchRequest searchRequest = new SiteSearchRequest();
//        SiteSearchResponse searchResponse = singleHelper.searchSite(searchRequest, passport);
//
//        if (!searchResponse.getResult().isEmpty()) {
//            return searchResponse.getResult().get(0).getKeywords();
//        }
        return null;
    }

    public String description() {
        Passport passport = new Passport();
        passport.setUserId(1l);

//        SiteSearchRequest searchRequest = new SiteSearchRequest();
//        SiteSearchResponse searchResponse = singleHelper.searchSite(searchRequest, passport);
//
//        if (!searchResponse.getResult().isEmpty()) {
//            return searchResponse.getResult().get(0).getDescription();
//        }
        return null;
    }

    public String icp() {
        Passport passport = new Passport();
        passport.setUserId(1l);
//        SiteSearchRequest searchRequest = new SiteSearchRequest();
//        SiteSearchResponse searchResponse = singleHelper.searchSite(searchRequest, passport);
//
//        if (!searchResponse.getResult().isEmpty()) {
//            return searchResponse.getResult().get(0).getIcp();
//        }
        return null;
    }

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
}
