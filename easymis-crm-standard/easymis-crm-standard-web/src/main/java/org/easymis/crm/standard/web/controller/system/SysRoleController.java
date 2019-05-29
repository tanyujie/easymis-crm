package org.easymis.crm.standard.web.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/role")
@Api(value = "角色controller", tags = { "角色操作接口" })
public class SysRoleController {
	private static final String MODULE_NAME = "系统角色模块";

}
