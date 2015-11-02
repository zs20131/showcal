package net.showcal.open.manager;

import com.xiniunet.apiframework.security.AppSecretManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiAppSecretManager implements AppSecretManager {
    private static final Map<String, String> appKeySecretMap = new ConcurrentHashMap<String, String>();
    static{
        appKeySecretMap.put("0617CA8376F9901F28FF46B69BF9CF47","28570C9D069ED51226DD9F028BD5E6DC");
    }

    public String getSecret(String appKey) {
        return appKeySecretMap.get(appKey);
    }

    public boolean isValidAppKey(String appKey) {
        if (appKeySecretMap.containsKey(appKey)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNormal(String arg0) {
        return true;
    }

}
