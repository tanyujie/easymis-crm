package org.easymis.crm.leads.web;

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
public class LeadsWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(LeadsWebApplication.class, args);
	}

}
