package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.biz.SysUserExtentManager;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DEV003 on 2015/10/8.
 */
public class changePwd {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlatformHelper platformHelper;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private SysUserExtentManager sysUserExtentManager;
    @Autowired
    private Mapper mapper;

    public void execute(Context context) throws Exception {
        // 得到当前登陆人
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
    }
}
