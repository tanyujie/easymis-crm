package org.easymis.crm.leads.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
@EnableFeignClients(basePackages = "org.easymis.crm.leads")
@ComponentScan(basePackages = "org.easymis.crm.leads")
public class LeadsWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(LeadsWebApplication.class, args);
	}

}
