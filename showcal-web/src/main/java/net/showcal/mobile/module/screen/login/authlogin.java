package net.showcal.mobile.module.screen.login;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.platform.domain.OpenTypeEnum;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.request.LoginByOpenIdRequest;
import com.showcal.platform.request.LoginPasswordResetRequest;
import com.showcal.platform.request.SysUserCreateRequest;
import com.showcal.platform.request.UserExistByOpenIdRequest;
import com.showcal.platform.response.LoginByOpenIdResponse;
import com.showcal.platform.response.SysUserCreateResponse;
import com.showcal.platform.response.UserExistByOpenIdResponse;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.login.findpassword
 *  Description:
 * ***************************************************************
 *  10/13 0013  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.login.findpassword
 * </pre>
 */
public class authlogin {
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformService platformService;

    public void execute(Context context,@Param("openId")String openId,@Param("userName")String userName ,@Param("type")String type) throws Exception {
       if("QQ".equals(type)||"WECHAT".equals(type)){
           // 判断openId 是否存在
           Passport passport = new Passport();
           UserExistByOpenIdRequest existByOpenIdRequest = new UserExistByOpenIdRequest();
           existByOpenIdRequest.setType(OpenTypeEnum.valueOf(type));
           existByOpenIdRequest.setOpenId(openId);
           UserExistByOpenIdResponse existByOpenIdResponse = platformService.userExistByOpenId(existByOpenIdRequest, passport);
           if(existByOpenIdResponse!=null&&!existByOpenIdResponse.hasError()){
               if(existByOpenIdResponse.getIsExist()){
                   // 模拟登录，颁发Passport
                   LoginByOpenIdRequest loginByOpenIdRequest = new LoginByOpenIdRequest();
                   loginByOpenIdRequest.setOpenId(openId);
                   loginByOpenIdRequest.setType(OpenTypeEnum.valueOf(type));
                   LoginByOpenIdResponse openIdResponse = platformService.LoginByOpenId(loginByOpenIdRequest, passport);
                   context.put("passport",openIdResponse.getPassport());
               }else{
                   SysUserCreateRequest sysUserCreateRequest = new SysUserCreateRequest();
                   sysUserCreateRequest.setNickName(userName);
                   sysUserCreateRequest.setUserType(UserTypeEnum.USER);
                   sysUserCreateRequest.setName(userName);
                   if("QQ".equals(type)){
                       sysUserCreateRequest.setQq(openId);
                   }
                   if("WECHAT".equals(type)){
                       sysUserCreateRequest.setWechat(openId);
                   }
                   // 不存在，创建用户
                   SysUserCreateResponse createResponse =  platformService.createSysUser(sysUserCreateRequest, passport);
                   if(createResponse!=null&&!createResponse.hasError()){
                       // 模拟登录，颁发Passport
                       LoginByOpenIdRequest loginByOpenIdRequest = new LoginByOpenIdRequest();
                       loginByOpenIdRequest.setOpenId(openId);
                       loginByOpenIdRequest.setType(OpenTypeEnum.valueOf(type));
                       LoginByOpenIdResponse openIdResponse = platformService.LoginByOpenId(loginByOpenIdRequest, passport);
                       context.put("passport",openIdResponse.getPassport());
                   }
               }
           }
       }
    }
}
