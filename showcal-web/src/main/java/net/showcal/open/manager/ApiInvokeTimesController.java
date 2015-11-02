package net.showcal.open.manager;

import com.xiniunet.apiframework.security.InvokeTimesController;
import com.xiniunet.apiframework.session.Session;

import java.util.HashMap;
import java.util.Map;


public class ApiInvokeTimesController implements InvokeTimesController {
    private static Map<String, Integer> appCallLimits = new HashMap<String, Integer>();
    private static Map<String, Integer> appCallCounter = new HashMap<String, Integer>();

    static {
        appCallLimits.put("00002", 10);
    }

    public void caculateInvokeTimes(String appKey, Session session) {
        if (!appCallCounter.containsKey(appKey)) {
            appCallCounter.put(appKey, 0);
        }
        appCallCounter.put(appKey, appCallCounter.get(appKey) + 1);
    }

    public boolean isUserInvokeLimitExceed(String appKey, Session session) {
        return false;
    }


    public boolean isSessionInvokeLimitExceed(String appKey, String sessionId) {
        return false;
    }


    public boolean isAppInvokeLimitExceed(String appKey) {
        return appCallLimits.containsKey(appKey) &&
                appCallCounter.get(appKey) > appCallLimits.get(appKey);
    }

    public boolean isAppInvokeFrequencyExceed(String appKey) {
        return false;
    }

}
