package org.easymis.crm.standard.client;


import java.util.ArrayList;

import org.easymis.crm.standard.object.SysDictQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class SysDictRestService {
	@Autowired
	private SysDictClient leadsClient;

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

	public ArrayList<SysDictQo> find() {
		return null;
	}

	private String findByIdFallback(String id) {
		return null;
	}
	private String findByPageFallback(Integer page,Integer size) {
		return null;
	}
}
