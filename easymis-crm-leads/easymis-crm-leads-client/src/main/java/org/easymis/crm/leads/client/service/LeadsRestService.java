package org.easymis.crm.leads.client.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class LeadsRestService {
	@Autowired
	private LeadsClient leadsClient;

	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public String findById(String id) {
		String temp=leadsClient.findById(id);
		System.out.println(id+":"+temp);
		return leadsClient.findById(id);
	}
	private String findByIdFallback(String id){
		return null;
	}
}
