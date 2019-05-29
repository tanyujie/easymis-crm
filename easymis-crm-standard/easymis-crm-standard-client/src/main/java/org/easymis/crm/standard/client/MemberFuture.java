package org.easymis.crm.standard.client;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberFuture {
	@Autowired
	private SysDictRestService sysDictRestService;

	public CompletableFuture<String> findById(String id) {
		return CompletableFuture.supplyAsync(() -> {
			return sysDictRestService.findById(id);
		});
	}
	public CompletableFuture<String> findByPage(Integer page,Integer size) {
		return CompletableFuture.supplyAsync(() -> {
			return sysDictRestService.findByPage(page, size);
		});
	}
}