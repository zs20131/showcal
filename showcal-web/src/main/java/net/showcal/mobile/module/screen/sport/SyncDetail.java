package net.showcal.mobile.module.screen.sport;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.thermalcontrol.domain.*;
import com.showcal.thermalcontrol.request.SportHeadFindRequest;
import com.showcal.thermalcontrol.request.SportLineGetAllListRequest;
import com.showcal.thermalcontrol.request.SyncHeatCreateRequest;
import com.showcal.thermalcontrol.request.SyncSportCreateRequest;
import com.showcal.thermalcontrol.response.SportHeadFindResponse;
import com.showcal.thermalcontrol.response.SportLineGetAllListResponse;
import com.showcal.thermalcontrol.response.SyncSportCreateResponse;
import com.xiniunet.apiframework.response.ErrorResponse;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.auth.LocalData;
import net.showcal.thermalcontrol.helper.ThermalcontrolHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2015/9/10.
 */
public class SyncDetail {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ThermalcontrolHelper thermalcontrolHelper;

    @Autowired
    private FoundationService foundationService;

    public void execute(Context context,  @Param("totalTime") Integer totalTime, @Param("sportHeadId") Long sportHeadId,@Param("intensity") String intensity,@Param("address") String address) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        SyncSportCreateRequest request = new SyncSportCreateRequest();
        request.setIntensity(intensity);
        request.setAddress(address);
        request.setSportHeadId(sportHeadId);
        request.setTotalTime(totalTime);
        request.setIsSynced(true);
       SyncSportCreateResponse response= thermalcontrolHelper.createSyncSport(request, passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}