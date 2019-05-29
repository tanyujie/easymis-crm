package org.easymis.crm.standard.web.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户controller", tags = { "用户操作接口" })
public class SysUserController {
	private static final String MODULE_NAME = "系统用户模块";
/*	@Autowired
	private SysUserService sysUserService;
    @ApiOperation(value = "获取用户信息", notes = "用户详细信息，附带角色信息，权限信息", httpMethod = "GET")
    @GetMapping("/info")
    public ApiResult<SysUserInfoDTO> getInfo(){
        Integer userId =UserUtil.getUserId(request);
        List<String> roles =UserUtil.getRoles(request);
        return new ApiResult<>(sysUserService.getUserInfo(userId, roles));
    }*/
}
