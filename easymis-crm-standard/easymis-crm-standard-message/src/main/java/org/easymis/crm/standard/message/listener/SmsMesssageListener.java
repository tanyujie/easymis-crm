/*package org.easymis.crm.standard.message.listener;

import java.util.Map;
import java.util.Objects;

import org.easymis.crm.standard.message.handler.sms.SmsMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = MqQueueNameConstant.MOBILE_CODE_QUEUE)
public class SmsMesssageListener {

    @Autowired
    private Map<String, SmsMessageHandler> smsMessageHandlerMap;

    @RabbitHandler
    public void listener(SmsMessageTemplate messageTemplate) {
        long start = System.currentTimeMillis();
        log.info("message service had receive push request");
        String channel = messageTemplate.getChannel();
        SmsMessageHandler smsMessageHandler = smsMessageHandlerMap.get(channel);
        if(Objects.isNull(smsMessageHandler)) {
            log.error("not found channel:{}.", channel);
        }
        smsMessageHandler.handleMessage(messageTemplate);
        long end = System.currentTimeMillis();
        log.info("had send message, use time:{} ms", (end -start));
    }

}
*/