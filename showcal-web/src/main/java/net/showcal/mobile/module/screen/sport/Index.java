package net.showcal.mobile.module.screen.sport;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.request.PassportGetRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.PassportGetResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.platform.service.PlatformService;
import com.showcal.thermalcontrol.domain.IntensityEnum;
import com.showcal.thermalcontrol.domain.SportAddressEnum;
import com.showcal.thermalcontrol.domain.SportHead;
import com.showcal.thermalcontrol.domain.SportLine;
import com.showcal.thermalcontrol.request.SportHeadFindRequest;
import com.showcal.thermalcontrol.request.SportLineGetAllListRequest;
import com.showcal.thermalcontrol.response.SportHeadFindResponse;
import com.showcal.thermalcontrol.response.SportLineGetAllListResponse;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.auth.LocalData;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.thermalcontrol.helper.ThermalcontrolHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/10.
 */
public class Index {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private ThermalcontrolHelper thermalcontrolHelper;

    public void execute(Context context, @Param("passprtid") Long passportid, @Param("intensity") String intensity, @Param("address") String address, @Param("sporttime") Integer sportTime, @Param("bmi") Double bmi) throws Exception {
        if (passportid != null) {
            PassportGetRequest passportGetRequest = new PassportGetRequest();
            passportGetRequest.setId(passportid);
            PassportGetResponse response = platformService.getPassport(passportGetRequest);
     /*   intensity="LOW";
        address="HOME";
        sportTime=30;
        bmi=40.0;*/
            if(response!=null){
            if (!"".equals(intensity) && !"".equals(address) && !"".equals(sportTime) && bmi != null) {
                SportHeadFindRequest sportHeadFindRequest = new SportHeadFindRequest();
                sportHeadFindRequest.setIntensity(IntensityEnum.valueOf(intensity));
                sportHeadFindRequest.setAddress(SportAddressEnum.valueOf(address));
                sportHeadFindRequest.setSportTime(sportTime);
                sportHeadFindRequest.setBMI(bmi);
                sportHeadFindRequest.setPageSize(3);
                SportHeadFindResponse sportHeadFindResponse = thermalcontrolHelper.findSportHead(sportHeadFindRequest, response.getPassport());
                context.put("sportHeads", sportHeadFindResponse.getResult());
                context.put("totalCount", sportHeadFindResponse.getTotalCount());
                context.put("address", address);
                context.put("intensity", intensity);
                context.put("sporttime", sportTime);
                context.put("bmi", bmi);
            }
            context.put("passport", response.getPassport());
        }
    }

    }
}