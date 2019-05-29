/*package org.easymis.crm.standard.message.handler.sms;

import org.easymis.crm.standard.message.config.TencentCloudPropteriesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsTencentCloudMessageHandler extends SmsMessageHandler {

    @Autowired
    private TencentCloudPropteriesConfig tencentCloudPropteriesConfig;

    @Override
    public Boolean execute(MessageTemplate messageTemplate) {
        try {
            SmsMessageTemplate smsMessageTemplate = (SmsMessageTemplate) messageTemplate;
            //数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsMultiSender msender = new SmsMultiSender(tencentCloudPropteriesConfig.getAppId(), tencentCloudPropteriesConfig.getAppKey());
            String[] mobile = {smsMessageTemplate.getMobile()};
            Integer templateId = Integer.valueOf(smsMessageTemplate.getTemplate());
            // 签名参数未提供或者为空时，会使用默认签名发送短信
            SmsMultiSenderResult result =  msender.sendWithParam("86", mobile,
                    templateId, smsMessageTemplate.getParams(), smsMessageTemplate.getSignName(), "", "");
            log.info("短信发送成功,号码:{}, 返回code:{}",smsMessageTemplate.getMobile(), result);
        } catch (Exception e){
            log.error("短信发送失败：{}", e.getMessage());
            return false;
        }
        return true;
    }
}*/