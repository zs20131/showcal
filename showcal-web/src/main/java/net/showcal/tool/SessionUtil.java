package net.showcal.tool;

import com.xiniunet.framework.security.Passport;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class SessionUtil {
    public static Map<String, Passport> passportMap = new ConcurrentHashMap<>();

    public static boolean hasCahce(String passportId) {
        return passportMap.containsKey(passportId);
    }

    public static void put(Passport passport) {
        passportMap.put(String.valueOf(passport.getId()), passport);
    }

    public static Passport get(String passportId) {
        return passportMap.get(passportId);
    }

    public static void remove(String passportId) {
        passportMap.remove(passportId);
    }
}
