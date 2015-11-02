import com.alibaba.fastjson.JSON;
import com.showcal.thermalcontrol.request.SyncHeatDetailCreateRequest;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: PACKAGE_NAME
 *  Description:
 * ***************************************************************
 *  10/19 0019  V1.0  xiniu    New Files for PACKAGE_NAME
 * </pre>
 */
public class StringJsonTest {
    public static void main(String[] args) {
        String s = "[\"{\"locale\":\"zh_CN\",\"foodId\":\"654993634198163508\",\"foodName\":\"粳米饭(蒸)\",\"sign_method\":\"md5\",\"format\":\"json\",\"unit\":\"克\",\"actualValue\":\"170.000000\",\"v\":\"1.0\",\"timestamp\":\"1445224449814\",\"recommendValue\":\"170.000000\"}\",\"{\"locale\":\"zh_CN\",\"foodId\":\"654993634198163507\",\"foodName\":\"米饭\",\"sign_method\":\"md5\",\"format\":\"json\",\"unit\":\"克\",\"actualValue\":\"170.000000\",\"v\":\"1.0\",\"timestamp\":\"1445224449815\",\"recommendValue\":\"170.000000\"}\"]";
        List<SyncHeatDetailCreateRequest> requestList = JSON.parseArray(s,SyncHeatDetailCreateRequest.class);
        System.out.println(requestList.get(0).getFoodId());
    }
}
