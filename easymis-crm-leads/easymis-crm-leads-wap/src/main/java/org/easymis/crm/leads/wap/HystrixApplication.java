package org.easymis.crm.leads.wap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableHystrixDashboard
public class HystrixApplication {
	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}
	public static void main(String[] args) {

		SpringApplication.run(HystrixApplication.class, args);
	}

}
