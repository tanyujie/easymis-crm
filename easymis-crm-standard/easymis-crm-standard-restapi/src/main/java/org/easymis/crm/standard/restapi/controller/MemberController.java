package org.easymis.crm.standard.restapi.controller;

import java.util.concurrent.CompletableFuture;

import org.easymis.crm.standard.domain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/crm/standard/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@ApiOperation(value = "获取会员详细信息", notes = "根据url的memberName来获取会员详细信息")
	@ApiImplicitParam(name = "memberName", value = "会员名", required = true, dataType = "String")
	@RequestMapping(value = "/findByMemberName", method = RequestMethod.GET)
	public CompletableFuture<String> findById(String memberName) {
		return CompletableFuture.supplyAsync(() -> memberService.findByMemberName(memberName)).thenApply(member -> {
			return new Gson().toJson(member);
		});
	}

}
