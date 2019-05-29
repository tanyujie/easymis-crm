package org.easymis.crm.standard.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
/**
 * 消息发送中心 处理短信发送 邮件发送
* @ClassName: StandardMessageApplication
* @Description: TODO(消息发送中心 处理短信发送 邮件发送)
* @author lenovo-t
* @date 2019年5月29日
*
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"org.easymis.crm.standard.message", "org.easymis.crm.common"})
public class StandardMessageApplication {
	public static void main(String[] args) {
        SpringApplication.run(StandardMessageApplication.class, args);
    }
}
