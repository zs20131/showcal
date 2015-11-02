package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.citrus.turbine.pipeline.valve.PageAuthorizationValve;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.platform.domain.CurveTypeEnum;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.domain.SysUserExtent;
import com.showcal.platform.domain.UserSetting;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.context.BaseUserAuth;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.SessionUtil;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by DEV003 on 2015/10/9.
 */
public class Api {
    @Autowired
    private BufferedRequestContext brc;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformHelper platformHelper;
    @Autowired
    private Mapper mapper;

    public void execute(Context context, @Param("method") String method) throws Exception {
        BaseResponse baseResponse = new BaseResponse();

        try {
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);
            Passport passport = (Passport) request.getAttribute("passport");
            context.put("passport",passport);
            InputStreamReader isr = new InputStreamReader(request.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String line = in.readLine();
            JSONObject jsonObject = JSON.parseObject(line);
            switch (method) {
                // 修改昵称
                case "api.about.me.info.nick.name.edit":
                    baseResponse = apiAboutMeInfoNickNameEdit(jsonObject, passport);
                    break;
                // 修改性别
                case "api.about.me.info.sex.edit":
                    baseResponse = apiAboutMeInfoSexEdit(jsonObject, passport);
                    break;
                // 修改身高
                case "api.about.me.info.height.edit":
                    baseResponse = apiAboutMeInfoHeightEdit(jsonObject, passport);
                    break;
                // 出生日期
                case "api.about.me.info.birthday.edit":
                    baseResponse = apiAboutMeInfoBirthdayEdit(jsonObject, passport);
                    break;
                // 修改体重
                case "api.about.me.info.weight.edit":
                    baseResponse = apiAboutMeInfoWeightEdit(jsonObject, passport);
                    break;
                // 查询体重列表
                case "api.about.me.info.weight.get.list":
                    baseResponse = apiAboutMeInfoWeightGetList(jsonObject, passport);
                    break;
                // 删除指定体重记录
                case "api.about.me.info.weight.delete":
                    baseResponse = apiAboutMeInfoWeightDelete(jsonObject, passport);
                    break;
                // 查询年度体重列表-月份为单位
                case "api.about.me.info.weight.get.year.list":
                    baseResponse = apiAboutMeInfoWeightGetYearList(jsonObject, passport);
                    break;
                // 查询月体重列表-大约星期为单位
                case "api.about.me.info.weight.get.month.list":
                    baseResponse = apiAboutMeInfoWeightGetMonthList(jsonObject, passport);
                    break;
                // 查询周体重列表-天为单位
                case "api.about.me.info.weight.get.week.list":
                    baseResponse = apiAboutMeInfoWeightGetWeekList(jsonObject, passport);
                    break;
                // 查询年度腰围列表-月份为单位
                case "api.about.me.info.waist.line.get.year.list":
                    baseResponse = apiAboutMeInfoWaistLineGetYearList(jsonObject, passport);
                    break;
                // 查询月腰围列表-大约星期为单位
                case "api.about.me.info.waist.line.get.month.list":
                    baseResponse = apiAboutMeInfoWaistLineGetMonthList(jsonObject, passport);
                    break;
                // 查询周腰围列表-天为单位
                case "api.about.me.info.waist.line.get.week.list":
                    baseResponse = apiAboutMeInfoWaistLineGetWeekList(jsonObject, passport);
                    break;
                // 查询年度臀围列表-月份为单位
                case "api.about.me.info.hip.line.get.year.list":
                    baseResponse = apiAboutMeInfoHipLineGetYearList(jsonObject, passport);
                    break;
                // 查询月臀围列表-大约星期为单位
                case "api.about.me.info.hip.line.get.month.list":
                    baseResponse = apiAboutMeInfoHipLineGetMonthList(jsonObject, passport);
                    break;
                // 查询周臀围列表-天为单位
                case "api.about.me.info.hip.line.get.week.list":
                    baseResponse = apiAboutMeInfoHipLineGetWeekList(jsonObject, passport);
                    break;
                // 修改特殊情况
                case "api.about.me.info.setting.disease.edit":
                    baseResponse = apiAboutMeInfoSettingDiseaseEdit(jsonObject, passport);
                    break;
                // 修改腰围
                case "api.about.me.info.waistLine.edit":
                    baseResponse = apiAboutMeInfoWaistLineEdit(jsonObject, passport);
                    break;
                // 删除指定腰围记录
                case "api.about.me.info.waistLine.delete":
                    baseResponse = apiAboutMeInfoWaistLineDelete(jsonObject, passport);
                    break;
                // 查询腰围列表
                case "api.about.me.info.waistLine.get.list":
                    baseResponse = apiAboutMeInfoWaistLineGetList(jsonObject, passport);
                    break;
                // 修改臀围
                case "api.about.me.info.hipline.edit":
                    baseResponse = apiAboutMeInfoHiplineEdit(jsonObject, passport);
                    break;
                // 删除指定臀围记录
                case "api.about.me.info.hipline.delete":
                    baseResponse = apiAboutMeInfoHiplineDelete(jsonObject, passport);
                    break;
                // 查询臀围列表
                case "api.about.me.info.hipline.get.list":
                    baseResponse = apiAboutMeInfoHiplineGetList(jsonObject, passport);
                    break;
                // 修改月经周期
                case "api.about.me.info.physiologyCycle.edit":
                    baseResponse = apiAboutMeInfoPhysiologyCycleEdit(jsonObject, passport);
                    break;
                // 行经天数
                case "api.about.me.info.physiologyDays.edit":
                    baseResponse = apiAboutMeInfoPhysiologyDaysEdit(jsonObject, passport);
                    break;
                // 行经天数
                case "api.about.me.info.physiologyStart.edit":
                    baseResponse = apiAboutMeInfoPhysiologyStartEdit(jsonObject, passport);
                    break;
                case "api.about.me.avatar.change":
                    baseResponse = apiChangeAvatar(jsonObject, passport);
                    break;
            }
        } catch (Exception ex) {
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
            LogUtil.errorLog(ex);
        } finally {
            String jsonTenant = JSON.toJSONString(baseResponse, SerializerFeature.DisableCircularReferenceDetect);//SerializerFeature.DisableCircularReferenceDetect参数禁止循环引用检测
            PrintWriter out = response.getWriter();
            out.println(jsonTenant);
        }

    }



    /**
     * 修改头像
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiChangeAvatar(JSONObject jsonObject, Passport passport) {
        UserAvatarUpdateRequest updateRequest = JSON.toJavaObject(jsonObject,UserAvatarUpdateRequest.class);
        SessionUtil.remove(String.valueOf(passport.getId()));
        return platformHelper.updateUserAvatar(updateRequest,passport);
    }

    /**
     *  修改昵称
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoNickNameEdit(JSONObject jsonObject, Passport passport){
        String nickName = jsonObject.getString("nickName");
        // 得到当前登陆人
        SysUserGetRequest getRequest = new SysUserGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserGetResponse userGetResponse = platformHelper.getSysUser(getRequest, passport);
        SysUser user = userGetResponse.getSysUser();
        if(user==null){
            return new BaseResponse();
        }
        // 更新
        SysUserUpdateRequest sysUserUpdateRequest = mapper.map(user, SysUserUpdateRequest.class);
        sysUserUpdateRequest.setNickName(nickName);
        sysUserUpdateRequest.setName(nickName);
        SysUserUpdateResponse sysUserUpdateResponse = platformHelper.updateSysUser(sysUserUpdateRequest, passport);
        SessionUtil.remove(String.valueOf(passport.getId()));
        return sysUserUpdateResponse;
    }

    /**
     *  修改性别
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoSexEdit(JSONObject jsonObject, Passport passport){
        String sex = jsonObject.getString("sex");
        // 得到当前登陆人
        SysUserGetRequest getRequest = new SysUserGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserGetResponse userGetResponse = platformHelper.getSysUser(getRequest, passport);
        SysUser user = userGetResponse.getSysUser();
        if(user!=null){
            // 更新
            SysUserUpdateRequest sysUserUpdateRequest = mapper.map(user, SysUserUpdateRequest.class);
            sysUserUpdateRequest.setSex(SexEnum.valueOf(sex));
            SysUserUpdateResponse sysUserUpdateResponse = platformHelper.updateSysUser(sysUserUpdateRequest, passport);
            SessionUtil.remove(String.valueOf(passport.getId()));
            return sysUserUpdateResponse;
        }else{
            return new BaseResponse();
        }
    }

    /**
     *  修改身高
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoHeightEdit(JSONObject jsonObject, Passport passport){
        String height = jsonObject.getString("height");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();
        if(userExtent==null){
            return new BaseResponse();
        }
        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);
        sysUserExtentUpdateRequest.setHeight(Integer.valueOf(height));// manager负责计算BMI
        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        if (sysUserExtentUpdateResponse.getResult() > 0){
            // 插入变化曲线
            SysUserCurveCreateRequest sysUserCurveCreateRequest = new SysUserCurveCreateRequest();
            sysUserCurveCreateRequest.setUserId(userExtent.getId());
            sysUserCurveCreateRequest.setType(CurveTypeEnum.HEIGHT);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            sysUserCurveCreateRequest.setRecordDate(dateFormat.format(new Date()));
            sysUserCurveCreateRequest.setValue(Double.valueOf(height));
            SysUserCurveCreateResponse sysUserCurveCreateResponse = platformHelper.createSysUserCurve(sysUserCurveCreateRequest, passport);
            if(sysUserCurveCreateResponse.hasError()){
                sysUserExtentUpdateResponse.addErrors(sysUserCurveCreateResponse.getErrors());
                return sysUserExtentUpdateResponse;
            }
        }

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改生日
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoBirthdayEdit(JSONObject jsonObject, Passport passport){
        String birthday = jsonObject.getString("birthday");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();
        if(userExtent==null){
            return new BaseResponse();
        }
        // 更新
        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = new SysUserExtentUpdateResponse();
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sysUserExtentUpdateRequest.setBirthday(dateFormat.parse(birthday));
        }catch (Exception e){
            sysUserExtentUpdateResponse.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }
        sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改体重
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWeightEdit(JSONObject jsonObject, Passport passport){
        String weight = jsonObject.getString("weight");
        String date = jsonObject.getString("date");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);
        sysUserExtentUpdateRequest.setWeight(Double.valueOf(weight));// manager负责计算BMI
        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        if (sysUserExtentUpdateResponse.getResult() > 0){
            // 插入变化曲线
            SysUserCurveCreateRequest sysUserCurveCreateRequest = new SysUserCurveCreateRequest();
            sysUserCurveCreateRequest.setUserId(userExtent.getId());
            sysUserCurveCreateRequest.setType(CurveTypeEnum.WEIGHT);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //sysUserCurveCreateRequest.setRecordDate(dateFormat.format(new Date()));//todo 前台传入日期
            if(date == null || "".equals(date)){
                date = dateFormat.format(new Date());
            }
            sysUserCurveCreateRequest.setRecordDate(date);
            sysUserCurveCreateRequest.setValue(Double.valueOf(weight));
            SysUserCurveCreateResponse sysUserCurveCreateResponse = platformHelper.createSysUserCurve(sysUserCurveCreateRequest, passport);
            if(sysUserCurveCreateResponse.hasError()){
                sysUserExtentUpdateResponse.addErrors(sysUserCurveCreateResponse.getErrors());
                return sysUserExtentUpdateResponse;
            }
        }

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改特殊情况
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoSettingDiseaseEdit(JSONObject jsonObject, Passport passport){
        String settingDiseaseId = jsonObject.getString("settingDiseaseId");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();
        if(userExtent==null){
            return new BaseResponse();
        }
        // setting
        String settingStr = userExtent.getSetting();
        JSONObject settingObj = JSON.parseObject(settingStr);//将json字符串转换为json对象
        UserSetting userSetting = JSONObject.toJavaObject(settingObj,UserSetting.class);//将建json对象转换为Person对象
        if (userSetting == null){
            userSetting = new UserSetting();
        }
        userSetting.setDiseaseId(Long.valueOf(settingDiseaseId));
        JSONObject jsonObject1 = (JSONObject)JSON.toJSON(userSetting);
        settingStr = jsonObject1.toJSONString();
        userExtent.setSetting(settingStr);

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);

        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        return sysUserExtentUpdateResponse;
    }


    /**
     *  修改腰围
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWaistLineEdit(JSONObject jsonObject, Passport passport){
        String waistLine = jsonObject.getString("waistLine");
        String date = jsonObject.getString("date");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);
        sysUserExtentUpdateRequest.setWaistLine(Double.valueOf(waistLine));
        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        if (sysUserExtentUpdateResponse.getResult() > 0){
            // 插入变化曲线
            SysUserCurveCreateRequest sysUserCurveCreateRequest = new SysUserCurveCreateRequest();
            sysUserCurveCreateRequest.setUserId(userExtent.getId());
            sysUserCurveCreateRequest.setType(CurveTypeEnum.WAISTLINE);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(date == null || "".equals(date)){
                date = dateFormat.format(new Date());
            }
            sysUserCurveCreateRequest.setRecordDate(date);
            sysUserCurveCreateRequest.setValue(Double.valueOf(waistLine));
            SysUserCurveCreateResponse sysUserCurveCreateResponse = platformHelper.createSysUserCurve(sysUserCurveCreateRequest, passport);
            if(sysUserCurveCreateResponse.hasError()){
                sysUserExtentUpdateResponse.addErrors(sysUserCurveCreateResponse.getErrors());
                return sysUserExtentUpdateResponse;
            }
        }

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改臀围
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoHiplineEdit(JSONObject jsonObject, Passport passport){
        String hipline = jsonObject.getString("hipline");
        String date = jsonObject.getString("date");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);
        sysUserExtentUpdateRequest.setWaistLine(Double.valueOf(hipline));
        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        if (sysUserExtentUpdateResponse.getResult() > 0){
            // 插入变化曲线
            SysUserCurveCreateRequest sysUserCurveCreateRequest = new SysUserCurveCreateRequest();
            sysUserCurveCreateRequest.setUserId(userExtent.getId());
            sysUserCurveCreateRequest.setType(CurveTypeEnum.HIPLINE);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(date == null || "".equals(date)){
                date = dateFormat.format(new Date());
            }
            sysUserCurveCreateRequest.setRecordDate(date);
            sysUserCurveCreateRequest.setValue(Double.valueOf(hipline));
            SysUserCurveCreateResponse sysUserCurveCreateResponse = platformHelper.createSysUserCurve(sysUserCurveCreateRequest, passport);
            if(sysUserCurveCreateResponse.hasError()){
                sysUserExtentUpdateResponse.addErrors(sysUserCurveCreateResponse.getErrors());
                return sysUserExtentUpdateResponse;
            }
        }

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改月经周期
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoPhysiologyCycleEdit(JSONObject jsonObject, Passport passport){
        String physiologyCycle = jsonObject.getString("physiologyCycle");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();

        // setting
        String settingStr = userExtent.getSetting();
        JSONObject settingObj = JSON.parseObject(settingStr);//将json字符串转换为json对象
        UserSetting userSetting = JSONObject.toJavaObject(settingObj,UserSetting.class);//将建json对象转换为Person对象
        if (userSetting == null){
            userSetting = new UserSetting();
        }
        userSetting.setPhysiologyCycle(Integer.valueOf(physiologyCycle));
        JSONObject jsonObject1 = (JSONObject)JSON.toJSON(userSetting);
        settingStr = jsonObject1.toJSONString();
        userExtent.setSetting(settingStr);

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);

        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改行经天数
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoPhysiologyDaysEdit(JSONObject jsonObject, Passport passport){
        String physiologyDays = jsonObject.getString("physiologyDays");
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();

        // setting
        String settingStr = userExtent.getSetting();
        JSONObject settingObj = JSON.parseObject(settingStr);//将json字符串转换为json对象
        UserSetting userSetting = JSONObject.toJavaObject(settingObj,UserSetting.class);//将建json对象转换为Person对象
        if (userSetting == null){
            userSetting = new UserSetting();
        }
        userSetting.setPhysiologyDays(Integer.valueOf(physiologyDays));
        JSONObject jsonObject1 = (JSONObject)JSON.toJSON(userSetting);
        settingStr = jsonObject1.toJSONString();
        userExtent.setSetting(settingStr);

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);

        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        return sysUserExtentUpdateResponse;
    }

    /**
     *  修改行经开始时间
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoPhysiologyStartEdit(JSONObject jsonObject, Passport passport){
        String physiologyStart = jsonObject.getString("physiologyStart");
        SysUserExtentUpdateResponse sysUserExtentUpdateResponse = new SysUserExtentUpdateResponse();
        // 得到当前登陆人扩展表
        SysUserExtentGetRequest getRequest = new SysUserExtentGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserExtentGetResponse userGetResponse = platformHelper.getSysUserExtent(getRequest, passport);
        SysUserExtent userExtent = userGetResponse.getSysUserExtent();

        // setting
        String settingStr = userExtent.getSetting();
        JSONObject settingObj = JSON.parseObject(settingStr);//将json字符串转换为json对象
        UserSetting userSetting = JSONObject.toJavaObject(settingObj,UserSetting.class);//将建json对象转换为Person对象
        if (userSetting == null){
            userSetting = new UserSetting();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            userSetting.setPhysiologyStart(dateFormat.parse(physiologyStart));
        }catch (Exception e){
            sysUserExtentUpdateResponse.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }
        JSONObject jsonObject1 = (JSONObject)JSON.toJSON(userSetting);
        settingStr = jsonObject1.toJSONString();
        userExtent.setSetting(settingStr);

        // 更新
        SysUserExtentUpdateRequest sysUserExtentUpdateRequest = mapper.map(userExtent, SysUserExtentUpdateRequest.class);

        sysUserExtentUpdateResponse = platformHelper.updateSysUserExtent(sysUserExtentUpdateRequest, passport);

        return sysUserExtentUpdateResponse;
    }

    /**
     *  根据用户ID查找该用户的所有体重记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWeightGetList(JSONObject jsonObject, Passport passport){
        SysUserCurveGetAllListByUserRequest request = JSON.toJavaObject(jsonObject, SysUserCurveGetAllListByUserRequest.class);
        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WEIGHT);
        SysUserCurveGetAllListByUserResponse response = platformHelper.getSysUserCurveAllListbyUser(request, passport);

        return response;
    }

    /**
     *  根据用户ID查找该用户的所有腰围信息
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWaistLineGetList(JSONObject jsonObject, Passport passport){
        SysUserCurveGetAllListByUserRequest request = JSON.toJavaObject(jsonObject, SysUserCurveGetAllListByUserRequest.class);
        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WAISTLINE);
        SysUserCurveGetAllListByUserResponse response = platformHelper.getSysUserCurveAllListbyUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的年度体重记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWeightGetYearList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        String year = startDate.substring(0,4);
        String endDate = year + "-12-31";
        SysUserCurveGetYearListByUserRequest request = new SysUserCurveGetYearListByUserRequest();
        SysUserCurveGetYearListByUserResponse response = new SysUserCurveGetYearListByUserResponse();
        /*计算的周期*/
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            request.setStartDate(dateFormat.parse(startDate));
            request.setEndDate(dateFormat.parse(endDate));
        }catch (Exception e){
            response.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WEIGHT);
        response = platformHelper.getSysUserCurveYearListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的月体重记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWeightGetMonthList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        SysUserCurveGetMonthListByUserRequest request = new SysUserCurveGetMonthListByUserRequest();
        SysUserCurveGetMonthListByUserResponse response = new SysUserCurveGetMonthListByUserResponse();
        // 根据前台传过来的日期间隔一个月截止
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            calendar.setTime(sdf.parse(startDate));
            calendar.set(Calendar.DAY_OF_MONTH,1);
            // 第一天
            Date firstDate = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            // 最后一天
            Date lastDate = calendar.getTime();
            request.setStartDate(firstDate);
            request.setEndDate(lastDate);
        }catch (Exception e){
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WEIGHT);
        response = platformHelper.getSysUserCurveMonthListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的周体重记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWeightGetWeekList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        SysUserCurveGetWeekListByUserRequest request = new SysUserCurveGetWeekListByUserRequest();
        SysUserCurveGetWeekListByUserResponse response = new SysUserCurveGetWeekListByUserResponse();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 获取给定的时间的周日的日期
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(dateFormat.parse(startDate));
            calendar.set(Calendar.DAY_OF_WEEK, 1);
            calendar.add(Calendar.WEEK_OF_MONTH, 1);
            request.setStartDate(dateFormat.parse(startDate));
            request.setEndDate(calendar.getTime());
        }catch (Exception e){
            response.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WEIGHT);
        response = platformHelper.getSysUserCurveWeekListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的年度腰围记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWaistLineGetYearList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        String year = startDate.substring(0,4);
        String endDate = year + "-12-31";
        SysUserCurveGetYearListByUserRequest request = new SysUserCurveGetYearListByUserRequest();
        SysUserCurveGetYearListByUserResponse response = new SysUserCurveGetYearListByUserResponse();
        /*计算的周期*/
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            request.setStartDate(dateFormat.parse(startDate));
            request.setEndDate(dateFormat.parse(endDate));
        }catch (Exception e){
            response.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WAISTLINE);
        response = platformHelper.getSysUserCurveYearListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的月腰围记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWaistLineGetMonthList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        SysUserCurveGetMonthListByUserRequest request = new SysUserCurveGetMonthListByUserRequest();
        SysUserCurveGetMonthListByUserResponse response = new SysUserCurveGetMonthListByUserResponse();
        // 根据前台传过来的日期间隔一个月截止
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            calendar.setTime(sdf.parse(startDate));
            calendar.set(Calendar.DAY_OF_MONTH,1);
            // 第一天
            Date firstDate = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            // 最后一天
            Date lastDate = calendar.getTime();
            request.setStartDate(firstDate);
            request.setEndDate(lastDate);
        }catch (Exception e){
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WAISTLINE);
        response = platformHelper.getSysUserCurveMonthListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的周腰围记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWaistLineGetWeekList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        SysUserCurveGetWeekListByUserRequest request = new SysUserCurveGetWeekListByUserRequest();
        SysUserCurveGetWeekListByUserResponse response = new SysUserCurveGetWeekListByUserResponse();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 获取给定的时间的周日的日期
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(dateFormat.parse(startDate));
            calendar.set(Calendar.DAY_OF_WEEK, 1);
            calendar.add(Calendar.WEEK_OF_MONTH, 1);
            request.setStartDate(dateFormat.parse(startDate));
            request.setEndDate(calendar.getTime());
        }catch (Exception e){
            response.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.WAISTLINE);
        response = platformHelper.getSysUserCurveWeekListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的年度臀围记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoHipLineGetYearList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        String year = startDate.substring(0,4);
        String endDate = year + "-12-31";
        SysUserCurveGetYearListByUserRequest request = new SysUserCurveGetYearListByUserRequest();
        SysUserCurveGetYearListByUserResponse response = new SysUserCurveGetYearListByUserResponse();
        /*计算的周期*/
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            request.setStartDate(dateFormat.parse(startDate));
            request.setEndDate(dateFormat.parse(endDate));
        }catch (Exception e){
            response.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.HIPLINE);
        response = platformHelper.getSysUserCurveYearListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的月臀围记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoHipLineGetMonthList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        SysUserCurveGetMonthListByUserRequest request = new SysUserCurveGetMonthListByUserRequest();
        SysUserCurveGetMonthListByUserResponse response = new SysUserCurveGetMonthListByUserResponse();
        // 根据前台传过来的日期间隔一个月截止
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            calendar.setTime(sdf.parse(startDate));
            calendar.set(Calendar.DAY_OF_MONTH,1);
            // 第一天
            Date firstDate = calendar.getTime();
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            // 最后一天
            Date lastDate = calendar.getTime();
            request.setStartDate(firstDate);
            request.setEndDate(lastDate);
        }catch (Exception e){
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.HIPLINE);
        response = platformHelper.getSysUserCurveMonthListByUser(request, passport);

        return response;
    }

    /**
     *  根据用户等查找该用户的周臀围记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoHipLineGetWeekList(JSONObject jsonObject, Passport passport){
        String startDate = jsonObject.getString("startDate");
        SysUserCurveGetWeekListByUserRequest request = new SysUserCurveGetWeekListByUserRequest();
        SysUserCurveGetWeekListByUserResponse response = new SysUserCurveGetWeekListByUserResponse();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 获取给定的时间的周日的日期
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setTime(dateFormat.parse(startDate));
            calendar.set(Calendar.DAY_OF_WEEK, 1);
            calendar.add(Calendar.WEEK_OF_MONTH, 1);
            request.setStartDate(dateFormat.parse(startDate));
            request.setEndDate(calendar.getTime());
        }catch (Exception e){
            response.addError(ErrorType.SYSTEM_ERROR, "日期转化出错");
            e.printStackTrace();
        }

        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.HIPLINE);
        response = platformHelper.getSysUserCurveWeekListByUser(request, passport);

        return response;
    }


    /**
     *  根据用户ID查找该用户的所有臀围信息
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoHiplineGetList(JSONObject jsonObject, Passport passport){
        SysUserCurveGetAllListByUserRequest request = JSON.toJavaObject(jsonObject, SysUserCurveGetAllListByUserRequest.class);
        request.setUserId(passport.getUserId());
        request.setType(CurveTypeEnum.HIPLINE);
        SysUserCurveGetAllListByUserResponse response = platformHelper.getSysUserCurveAllListbyUser(request, passport);

        return response;
    }

    /**
     *  根据条件删除体重记录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiAboutMeInfoWeightDelete(JSONObject jsonObject, Passport passport){
        Long userId = passport.getUserId();
        String date = jsonObject.getString("date");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null || "".equals(date)){
            date = dateFormat.format(new Date());
        }
        SysUserCurveDeleteByConditionRequest request = new SysUserCurveDeleteByConditionRequest();
        request.setUserId(userId);
        request.setType(CurveTypeEnum.WEIGHT);
        request.setRecordDate(date);
        SysUserCurveDeleteByConditionResponse response = platformHelper.deleteSysUserCurveByCondition(request, passport);

        return response;
    }

    private BaseResponse apiAboutMeInfoWaistLineDelete(JSONObject jsonObject, Passport passport){
        Long userId = passport.getUserId();
        String date = jsonObject.getString("date");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null || "".equals(date)){
            date = dateFormat.format(new Date());
        }
        SysUserCurveDeleteByConditionRequest request = new SysUserCurveDeleteByConditionRequest();
        request.setUserId(userId);
        request.setType(CurveTypeEnum.WAISTLINE);
        request.setRecordDate(date);
        SysUserCurveDeleteByConditionResponse response = platformHelper.deleteSysUserCurveByCondition(request, passport);

        return response;
    }

    private BaseResponse apiAboutMeInfoHiplineDelete(JSONObject jsonObject, Passport passport){
        Long userId = passport.getUserId();
        String date = jsonObject.getString("date");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(date == null || "".equals(date)){
            date = dateFormat.format(new Date());
        }
        SysUserCurveDeleteByConditionRequest request = new SysUserCurveDeleteByConditionRequest();
        request.setUserId(userId);
        request.setType(CurveTypeEnum.HIPLINE);
        request.setRecordDate(date);
        SysUserCurveDeleteByConditionResponse response = platformHelper.deleteSysUserCurveByCondition(request, passport);

        return response;
    }

}
