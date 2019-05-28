package org.easymis.crm.leads.restapi.controller;

import java.util.concurrent.CompletableFuture;

import org.easymis.crm.leads.domain.service.LeadsService;
import org.easymis.crm.leads.restapi.exception.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/json")
    public String json() throws RestApiException {
        throw new RestApiException("发生错误2");
    }
}
