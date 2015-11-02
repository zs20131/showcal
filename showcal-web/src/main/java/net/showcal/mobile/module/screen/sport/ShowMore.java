package net.showcal.mobile.module.screen.sport;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.thermalcontrol.domain.IntensityEnum;
import com.showcal.thermalcontrol.domain.SportAddressEnum;
import com.showcal.thermalcontrol.domain.SportHead;
import com.showcal.thermalcontrol.domain.SportLine;
import com.showcal.thermalcontrol.request.SportHeadFindRequest;
import com.showcal.thermalcontrol.request.SportLineGetAllListRequest;
import com.showcal.thermalcontrol.response.SportHeadFindResponse;
import com.showcal.thermalcontrol.response.SportLineGetAllListResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.thermalcontrol.helper.ThermalcontrolHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/10.
 */
public class ShowMore {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ThermalcontrolHelper thermalcontrolHelper;

    public void execute(Context context,@Param("pageIndex") Integer pageIndex, @Param("intensity") String intensity, @Param("address") String address, @Param("sporttime") Integer sportTime, @Param("bmi") Double bmi) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        SportHeadFindResponse sportHeadFindResponse=new SportHeadFindResponse();
        if (!"".equals(intensity) && !"".equals(address) && !"".equals(sportTime) && bmi != null) {
            SportHeadFindRequest sportHeadFindRequest = new SportHeadFindRequest();
            sportHeadFindRequest.setIntensity(IntensityEnum.valueOf(intensity));
            sportHeadFindRequest.setAddress(SportAddressEnum.valueOf(address));
            sportHeadFindRequest.setSportTime(sportTime);
            sportHeadFindRequest.setBMI(bmi);
            sportHeadFindRequest.setPageSize(3);
            sportHeadFindRequest.setPageNumber(pageIndex.intValue());
            sportHeadFindResponse = thermalcontrolHelper.findSportHead(sportHeadFindRequest, passport);
        }
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(sportHeadFindResponse, SerializerFeature.DisableCircularReferenceDetect);
             out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}