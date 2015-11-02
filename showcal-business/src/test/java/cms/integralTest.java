package cms;

import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.IntegralRule;
import com.showcal.platform.domain.IntegralRuleStatusEnum;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.po.IntegralRulePO;
import com.showcal.platform.request.IntegralRuleCreateRequest;
import com.showcal.platform.response.IntegralRuleCreateResponse;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.base.BaseTest;
import com.xiniunet.framework.security.Passport;
//import javafx.beans.property.IntegerProperty;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/12.
 */
@TransactionConfiguration(defaultRollback = false)
public class integralTest extends BaseTest {
    @Autowired
    private Passport passport;
    @Autowired
    private PlatformService platformService;

    @Test
    public void test() {
//        Map<String,String> map=new HashMap<>();
//
//        IntegralRuleCreateRequest createRequest = new IntegralRuleCreateRequest();
//        createRequest.setStatus(1);
//        createRequest.setValue(5);
//        createRequest.setIsSetup(true);
//        createRequest.setType(IntegralRuleTypeEnum.FORWORD.name());
//        platformService.createIntegralRule(createRequest, passport);
//        createRequest.setStatus(1);
//        createRequest.setValue(1);
//        createRequest.setIsSetup(true);
//        createRequest.setType(IntegralRuleTypeEnum.LOGIN.name());
//        platformService.createIntegralRule(createRequest, passport);
//        createRequest.setStatus(1);
//        createRequest.setValue(2);
//        createRequest.setIsSetup(true);
//        createRequest.setType(IntegralRuleTypeEnum.QUESTION.name());
//        platformService.createIntegralRule(createRequest, passport);
//        createRequest.setStatus(1);
//        createRequest.setValue(1);
//        createRequest.setIsSetup(true);
//        createRequest.setType(IntegralRuleTypeEnum.REPLY.name());
//        platformService.createIntegralRule(createRequest, passport);
//        createRequest.setStatus(1);
//        createRequest.setValue(1);
//        createRequest.setIsSetup(true);
//        createRequest.setType(IntegralRuleTypeEnum.USERTC.name());
//        platformService.createIntegralRule(createRequest, passport);

    }


}
