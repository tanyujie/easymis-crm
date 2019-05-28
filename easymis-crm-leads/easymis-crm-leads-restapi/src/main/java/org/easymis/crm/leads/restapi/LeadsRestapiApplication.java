package org.easymis.crm.leads.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = "org.easymis.crm.leads")
@ComponentScan(basePackages = "org.easymis.crm.leads")
public class LeadsRestapiApplication {
	public static void main(String[] args) {

		SpringApplication.run(LeadsRestapiApplication.class, args);
	}

}
