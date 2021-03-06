package org.easymis.crm.leads.client.service;


import java.util.ArrayList;

import org.easymis.crm.leads.object.LeadsQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class LeadsRestService {
	@Autowired
	private LeadsClient leadsClient;

	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public String findById(String id) {
		String temp = leadsClient.findById(id);
		System.out.println(id + ":" + temp);
		return leadsClient.findById(id);
	}
	@HystrixCommand(fallbackMethod = "findByPageFallback")
	public String findByPage(Integer page,Integer size) {
		System.out.println("size:"+size);
		return leadsClient.findByPage(page, size);
	}
	public void remove(String id) {
	}

	public ArrayList<LeadsQo> find() {
		return null;
	}

	private String findByIdFallback(String id) {
		return null;
	}
	private String findByPageFallback(Integer page,Integer size) {
		return null;
	}
}
