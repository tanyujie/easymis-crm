package org.easymis.crm.standard.restapi.controller;

import java.util.concurrent.CompletableFuture;

import org.easymis.crm.standard.domain.service.HrmStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/crm/standard/hrmStaffInfo")
public class HrmStaffInfoController {
	@Autowired
	private HrmStaffInfoService staffInfoService;

	@ApiOperation(value = "获取员工详细信息", notes = "根据url的memberName来获取员工详细信息")
	@ApiImplicitParam(name = "memberName", value = "员工名", required = true, dataType = "String")
	@RequestMapping(value = "/findByMemberAndOrganize", method = RequestMethod.GET)
	public CompletableFuture<String> findByMemberAndOrganize(String memberId,String orgId) {
		return CompletableFuture.supplyAsync(() -> staffInfoService.findByMemberAndOrganize(memberId, orgId)).thenApply(staffInfo -> {
			return new Gson().toJson(staffInfo);
		});
	}

}
