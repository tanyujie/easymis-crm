package org.easymis.crm.leads.restapi.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.easymis.crm.leads.domain.entity.Leads;
import org.easymis.crm.leads.domain.service.LeadsService;
import org.easymis.crm.leads.restapi.exception.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/crm/leads")
public class LeadsController {
	@Autowired
	private LeadsService leadsService;

	@ApiOperation(value = "获取线索详细信息", notes = "根据url的id来获取线索详细信息")
	@ApiImplicitParam(name = "id", value = "线索ID", required = true, dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CompletableFuture<String> findById(@PathVariable String id) {
		return CompletableFuture.supplyAsync(() -> leadsService.findById(id)).thenApply(leads -> {
			return new Gson().toJson(leads);
		});
	}

	@ApiOperation(value = "findAllLeads", notes = "获取所有的内容", tags = "leads")
	@RequestMapping(value = "/findAllLeads", method = RequestMethod.GET)
	public PageInfo findAllLeads(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "4") int pageSize) {
		// 这是整个过程中最核心的一条语句
		PageHelper.startPage(pageNum, pageSize);
		List<Leads> leadsList = leadsService.findAll();
		PageInfo<Leads> pageInfo = new PageInfo<Leads>(leadsList);
		return pageInfo;
	}

	@ApiOperation(value = "findByPage", notes = "获取所有的内容", tags = "leads")
	@RequestMapping(value = "/findByPage", method = RequestMethod.GET)
	public CompletableFuture<String> findByPage(
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		System.out.println("size:"+pageSize);
		return CompletableFuture.supplyAsync(() -> leadsService.findAll(pageNum, pageSize)).thenApply(leads -> {
			return new Gson().toJson(leads);
		});
	}
	@RequestMapping("/json")
	public String json() throws RestApiException {
		throw new RestApiException("发生错误2");
	}
}
