package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.showcal.platform.biz.SysUserExtentManager;
import com.showcal.platform.domain.SysUserExtent;
import com.showcal.platform.request.SysUserExtentGetRequest;
import com.showcal.platform.response.SysUserExtentGetResponse;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DEV003 on 2015/10/8.
 */
public class MyIntegral {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysUserExtentManager sysUserExtentManager;

    public void execute(Context context) throws Exception {
        // 得到当前登陆人
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        SysUserExtentGetRequest sysUserExtentGetRequest = new SysUserExtentGetRequest();
        sysUserExtentGetRequest.setId(passport.getUserId());
        SysUserExtentGetResponse sysUserExtentGetResponse = sysUserExtentManager.get(sysUserExtentGetRequest, passport);
        SysUserExtent sysUserExtent = sysUserExtentGetResponse.getSysUserExtent();
        if (sysUserExtent != null) {
            context.put("integralCount", sysUserExtent.getIntegral());
        }
        // 获取积分规则
        /*IntegralRuleGetAllListRequest integralRuleGetAllListRequest = new IntegralRuleGetAllListRequest();
        IntegralRuleGetAllListResponse integralRuleGetAllListResponse = integralRuleManager.getAllList(integralRuleGetAllListRequest, passport);
        List<IntegralRule> integralRuleList = integralRuleGetAllListResponse.getResult();
        context.put("integralRuleList", integralRuleList);*/
    }
}
