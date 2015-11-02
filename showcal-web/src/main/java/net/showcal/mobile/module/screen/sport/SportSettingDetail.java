package net.showcal.mobile.module.screen.sport;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.thermalcontrol.domain.SportHead;
import com.showcal.thermalcontrol.domain.SportLine;
import com.showcal.thermalcontrol.request.SportHeadFindRequest;
import com.showcal.thermalcontrol.request.SportLineGetAllListRequest;
import com.showcal.thermalcontrol.response.SportHeadFindResponse;
import com.showcal.thermalcontrol.response.SportLineGetAllListResponse;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.auth.LocalData;
import net.showcal.thermalcontrol.helper.ThermalcontrolHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by Administrator on 2015/9/10.
 */
public class SportSettingDetail {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ThermalcontrolHelper thermalcontrolHelper;

    @Autowired
    private FoundationService foundationService;

    public void execute(Context context, @Param("id") Long id) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
     /*   SportLineGetAllListRequest sportLineGetAllListRequest=new SportLineGetAllListRequest();
        sportLineGetAllListRequest.setId(id);
        SportLineGetAllListResponse sportLineGetAllListResponse=thermalcontrolHelper.getSportLineAllList(sportLineGetAllListRequest, LocalData.getCurrentPassport());
        SportHeadFindRequest sportHeadFindRequest=new SportHeadFindRequest();
        sportHeadFindRequest.setId(sportLineGetAllListResponse.getResult().get(0).getHeadId());
        SportHeadFindResponse sportHeadFindResponse = thermalcontrolHelper.findSportHead(sportHeadFindRequest,LocalData.getCurrentPassport())
        context.put("sportSettings", sportLineGetAllListResponse.getResult());*/
        SportHeadFindRequest sportHeadFindRequest=new SportHeadFindRequest();
        sportHeadFindRequest.setId(id);
        SportHeadFindResponse sportHeadFindResponse = thermalcontrolHelper.findSportHead(sportHeadFindRequest,LocalData.getCurrentPassport());

        SportLineGetAllListRequest sportLineGetAllListRequest=new SportLineGetAllListRequest();
        sportLineGetAllListRequest.setHeadId(id);
        SportLineGetAllListResponse sportLineGetAllListResponse=thermalcontrolHelper.getSportLineAllList(sportLineGetAllListRequest, LocalData.getCurrentPassport());
        SportHead sportHead = sportHeadFindResponse.getResult().get(0);

        List<SportLine> sportLines = sportLineGetAllListResponse.getResult();
        if(sportLines != null && !sportLines.isEmpty()){
            for(SportLine sportLine : sportLines){
                if (sportLine.getSportSetting().getCover()!= null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(sportLine.getSportSetting().getCover());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest,LocalData.getCurrentPassport());
                    sportLine.getSportSetting().setUrl(filePathGetResponse.getUrl());
                } else if("Picture".equals(sportLine.getSportSetting().getType())) {
                    sportLine.getSportSetting().setUrl("../images/avatar_default.png");
                }
            }
        }


        sportHead.setSportLineList(sportLineGetAllListResponse.getResult());
        context.put("sportHead", sportHead);

    }
}