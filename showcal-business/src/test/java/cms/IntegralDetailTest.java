package cms;

import com.showcal.platform.domain.IntegralDetail;
import com.showcal.platform.domain.IntegralRule;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.request.*;
import com.showcal.platform.response.IntegralDetailFindResponse;
import com.showcal.platform.response.IntegralRuleFindResponse;
import com.showcal.platform.response.IntegralRuleGetResponse;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.base.BaseTest;
import com.xiniunet.framework.security.Passport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Administrator on 2015/10/12.
 */
@TransactionConfiguration(defaultRollback = false)
public class IntegralDetailTest extends BaseTest {
    @Autowired
    private Passport passport;
    @Autowired
    private PlatformService platformService;

    @Test
    public void test() {
        Passport passport=new Passport();
        passport.setUserId(657512467878252544L);
//        passport.setUserName("ceshiz");
//        for(int i=0;i<2;i++) {
//            IntegralDetailCreateRequest request = new IntegralDetailCreateRequest();
//            request.setType(IntegralRuleTypeEnum.LOGIN.name());
//        request.setType(IntegralRuleTypeEnum.LOGIN.name());
//        request.setType(IntegralRuleTypeEnum.QUESTION.name());
//        request.setType(IntegralRuleTypeEnum.USERTC.name());
//        request.setType(IntegralRuleTypeEnum.FORWORD.name());
//            platformService.createIntegralDetail(request, passport);
//        }
        //获取积分明细
        IntegralDetailFindRequest integralDetailFindRequest=new IntegralDetailFindRequest();
        integralDetailFindRequest.setUserId(passport.getUserId());
        IntegralDetailFindResponse integralDetailFindResponse=platformService.findIntegralDetail(integralDetailFindRequest,passport);
        for(IntegralDetail integralDetail:integralDetailFindResponse.getResult()){
            IntegralRuleFindRequest integralRuleFindRequest=new IntegralRuleFindRequest();
            integralRuleFindRequest.setId(integralDetail.getRuleId());
            IntegralRuleFindResponse integralRuleFindResponse=platformService.find(integralRuleFindRequest,passport);
            System.out.println("积分"+integralRuleFindResponse.getResult().get(0).getType() + "   "+"\t积分值"+integralDetail.getValue()+"\t积分时间 "+integralDetail.getIntegralTime());
        }
    }


}
