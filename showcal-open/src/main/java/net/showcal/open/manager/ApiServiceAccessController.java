package net.showcal.open.manager;

import com.xiniunet.apiframework.security.ServiceAccessController;
import com.xiniunet.apiframework.session.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ApiServiceAccessController implements ServiceAccessController {
    private static final Map<String, List<String>> aclMap = new HashMap<String, List<String>>();
//    private static final Map<String,String> passmethod = new ConcurrentHashMap<>();
//    static{
//        passmethod.put("api.system.pos.login#1.0","");
//        passmethod.put("api.system.member.login#1.0","");
//        passmethod.put("api.security.passport.get#1.0","");
//        passmethod.put("api.security.passport.revoke#1.0","");
//        passmethod.put("api.security.passport.create#1.0","");
//        passmethod.put("api.security.login#1.0","");
//    }


    @Override
    public boolean isAppGranted(String appKey, String method, String version) {
        return true;
    }

    @Override
    public boolean isUserGranted(Session session, String appKey, String method, String version) {
        return true;
    }
}
