package net.showcal.apitest;

import com.alibaba.fastjson.JSON;
import net.showcal.api.DefaultXiniuClient;
import net.showcal.api.XiniuClient;
import net.showcal.api.domain.mobile.OpenTypeEnum;
import net.showcal.api.domain.mobile.SexEnum;
import net.showcal.api.request.mobile.*;
import net.showcal.api.response.mobile.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.apitest
 *  Description:
 * ***************************************************************
 *  10/13 0013  V1.0  xiniu    New Files for net.showcal.apitest
 * </pre>
 */
public class TestUserInfoRecord {
    XiniuClient client;

    @Before
    public void before() {
        client = new DefaultXiniuClient("http://local.xiniunet.com/open/router", "0617CA8376F9901F28FF46B69BF9CF47", "28570C9D069ED51226DD9F028BD5E6DC");
    }

    @Test
    public void userInfoRecord(){
        UserInfoRecordRequest userInfoRecordRequest = new UserInfoRecordRequest();
        userInfoRecordRequest.setUserId(00L);
        userInfoRecordRequest.setBirthday(new Date());
        userInfoRecordRequest.setHeight(185);
        userInfoRecordRequest.setSex(SexEnum.FEMALE);
        userInfoRecordRequest.setHipline(11.0);
        userInfoRecordRequest.setWeight(120.0);
        userInfoRecordRequest.setWaistLine(220.0);
        UserInfoRecordResponse response = client.execute(userInfoRecordRequest, "653777984473665536");
        System.out.println(response.getBody());
    }
    @Test
    public void getPassport(){
        PassportGetRequest passportGetRequest = new PassportGetRequest();
        passportGetRequest.setId(653777984473665536L);
        PassportGetResponse passportGetResponse =  client.execute(passportGetRequest);
        System.out.println(JSON.toJSONString(passportGetResponse.getPassport()));
    }
    @Test
    public void getUserInfo(){
        CurrentUserInfoGetRequest currentUserInfoGetRequest = new CurrentUserInfoGetRequest();
        CurrentUserInfoGetResponse currentUserInfoGetResponse = client.execute(currentUserInfoGetRequest,"653777984473665536");
        System.out.println(currentUserInfoGetResponse.getBody());
    }
    @Test
    public void getSql(){
        SyncSqlIncrementRequest sqlIncrementRequest = new SyncSqlIncrementRequest();
        sqlIncrementRequest.setCurrentVersion(1);
        SyncSqlIncrementResponse sqlIncrementResponse = client.execute(sqlIncrementRequest,"653777984473665536");
    }
    @Test
    public void testMaxVersion(){
        MaxSqlVersionGetRequest maxSqlVersionGetRequest = new MaxSqlVersionGetRequest();
        MaxSqlVersionGetResponse response = client.execute(maxSqlVersionGetRequest,"653777984473665536");
        System.out.println(response.getBody());
    }

    @Test
    public void getShowCal(){
        ShowCalQueryRequest showCalQueryRequest = new ShowCalQueryRequest();
        showCalQueryRequest.setPageNumber(1);
        showCalQueryRequest.setPageSize(10);
        ShowCalQueryResponse showCalQueryResponse = client.execute(showCalQueryRequest,"653777984473665536");
        System.out.println(showCalQueryResponse.getBody());
    }
    @Test
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccount("18625090483");
        loginRequest.setPassword("resss");
        LoginResponse loginResponse = client.execute(loginRequest);
        System.out.println(loginResponse.getBody());
    }
    @Test
    public void testSelectedShowCal(){
        ShowCalSelectedRequest selectedRequest = new ShowCalSelectedRequest();
        selectedRequest.setShowCalId(11L);
        ShowCalSelectedResponse selectedResponse = client.execute(selectedRequest,"653777984473665536");
        System.out.println(selectedResponse.getBody());
    }
    @Test
    public void testAuth(){
        AuthLoginRequest request = new AuthLoginRequest();
        request.setType(OpenTypeEnum.WECHAT);
        request.setOpenId("00000100100100101001");
        request.setUserName("测试张小三");
        AuthLoginResponse authLoginResponse = client.execute(request);
        System.out.println(authLoginResponse.getBody());
    }

    /**
     * 同步热量
     */
    @Test
    public void testSyncHeat(){
        SyncHeatCreateRequest createRequest = new SyncHeatCreateRequest();
        createRequest.setMealsId(001L);
        createRequest.setGrade(1.0);
        createRequest.setTotalCarbohydrate(1.0);
        createRequest.setTotalProtein(1.1);
        createRequest.setTotalDf(1.0);
        createRequest.setTotalFat(1.0);
        createRequest.setTotalHeat(1.0);
        SyncHeatDetailCreateRequest detailCreateRequest = new SyncHeatDetailCreateRequest();
        detailCreateRequest.setFoodId(1L);
        detailCreateRequest.setFoodName("测试食物");
        detailCreateRequest.setActualValue(1.0);
        detailCreateRequest.setRecommendValue(0.0);
        detailCreateRequest.setUnit("碗");
        List<SyncHeatDetailCreateRequest> details = new ArrayList<>();
        details.add(detailCreateRequest);
        createRequest.setDetail(details);
        SyncHeatCreateResponse response = client.execute(createRequest,"653777984473665536");
        System.out.println(response.getBody());
    }

    public void testUpload(){
        UploadFileRequest uploadFileRequest = new UploadFileRequest();
        UploadFileResponse response = (UploadFileResponse) client.execute(uploadFileRequest,"");
    }
}
