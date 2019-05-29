package org.easymis.crm.standard.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/route")
@Api(value = "zuul路由controller", tags = {"zuul路由操作接口"})
public class SysZuulRouteController {

}
