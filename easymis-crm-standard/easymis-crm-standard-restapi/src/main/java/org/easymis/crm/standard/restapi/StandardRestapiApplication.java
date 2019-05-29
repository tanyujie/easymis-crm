package org.easymis.crm.standard.restapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = "org.easymis.crm.standard")
@ComponentScan(basePackages = "org.easymis.crm.standard")
@MapperScan("org.easymis.crm.standard.domain.mapper")
public class StandardRestapiApplication {
	public static void main(String[] args) {

		SpringApplication.run(StandardRestapiApplication.class, args);
	}

}
