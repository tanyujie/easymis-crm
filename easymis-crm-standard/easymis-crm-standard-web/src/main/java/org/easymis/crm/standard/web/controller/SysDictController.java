package org.easymis.crm.standard.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/dict")
@Api(value = "字典controller", tags = {"系统字典操作接口"})
public class SysDictController {
/*	@GetMapping("/top/name")
	public R<List<SysDict>> getTopDictList(@RequestParam String name) {
		return R.ok(baseService.getTopDictListByDesc(name));
	}*/
}
