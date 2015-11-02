package net.showcal.open.manager;

import com.showcal.platform.request.PassportGetRequest;
import com.showcal.platform.response.PassportGetResponse;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.apiframework.session.Session;
import com.xiniunet.apiframework.session.SessionManager;
import com.xiniunet.apiframework.session.SimpleSession;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiniunet
 */
public class ApiSessionManager implements SessionManager {
    private static final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);
    @Autowired
    private PlatformService platformService;

    @Override
    public void addSession(String sessionId, Session session) {
        sessionCache.put(sessionId, session);
    }

    @Override
    public Session getSession(String sessionId) {
         Session session = sessionCache.get(sessionId);
        if (session != null) {
            //验证SessionId 是否过期
            Passport passport = (Passport) session.getAttribute("passport");
            if (isExpire(passport.getExpireTime())) {
                //删除session信息
                sessionCache.remove(sessionId);
                return null;
            }
            return session;
        } else {
            PassportGetRequest request = new PassportGetRequest();
            request.setId(Long.valueOf(sessionId));
            PassportGetResponse response = platformService.getPassport(request);
            if (response == null || response.hasError()) {
                return null;
            }
            Passport passport = response.getPassport();
            if (passport == null || isExpire(passport.getExpireTime())) {
                return null;
            }
            session = new SimpleSession();
            session.setAttribute("passport", passport);
            sessionCache.put(sessionId, session);
            return session;
        }
    }

    @Override
    public void removeSession(String sessionId) {
        sessionCache.remove(sessionId);
    }

    //判断session是否过期
    private boolean isExpire(Date date) {
//        if (date == null || date.before(new Date())) {
//            return true;
//        }
        return false;
    }
}
