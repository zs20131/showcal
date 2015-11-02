package net.showcal.mobile.module.action;

import com.alibaba.citrus.service.form.CustomErrors;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormField;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.showcal.platform.request.SysUserCreateRequest;
import com.showcal.platform.response.SysUserCreateResponse;
import net.showcal.mobile.domain.RegisterBean;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.action
 *  Description:
 * ***************************************************************
 *  9/29 0029  V1.0  xiniu    New Files for net.showcal.mobile.module.action
 * </pre>
 */
public class Register {
//    @Autowired
//    private YunLandService yunLandService;
//    @Autowired
//    private BaseService baseService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private Mapper mapper;

    public void doRegister(@FormGroup("register")RegisterBean registerBean,@FormField(name = "registerError", group = "register") CustomErrors err,Navigator nav,Context context){
//        passport.setUserId(100000L);
        SysUserCreateRequest createRequest = this.mapper.map(registerBean,SysUserCreateRequest.class);
//        memberCreateRequest.setType(MemberTypeEnum.STANDARD);
//        memberCreateRequest.setMobilePhone(request.getParameter("mobilePhone"));
//        memberCreateRequest.setPassword(registerBean.getPassword());
        SysUserCreateResponse response = new SysUserCreateResponse();//yunLandService.createMember(memberCreateRequest,passport);
        if(response!=null&&response.hasError()){
            Map<String, Object> params = new HashMap<>();
//            params.put("errormsg",response.getErrors().get(0).getMessage());
            err.setMessage("registerError",params);
        }else{
            nav.redirectTo("mobileregistersuccess");
        }
    }
}
