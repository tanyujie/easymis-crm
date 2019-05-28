package org.easymis.crm.leads.client.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeadsFuture {
	@Autowired
	private LeadsRestService leadsRestService;

	public CompletableFuture<String> findById(String id) {
		return CompletableFuture.supplyAsync(() -> {
			return leadsRestService.findById(id);
		});
	}
	public CompletableFuture<String> findByPage(Integer page,Integer size) {
		return CompletableFuture.supplyAsync(() -> {
			return leadsRestService.findByPage(page, size);
		});
	}
}