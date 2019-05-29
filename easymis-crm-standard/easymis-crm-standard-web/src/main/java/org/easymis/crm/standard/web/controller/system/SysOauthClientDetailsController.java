package org.easymis.crm.standard.web.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/client")
@Api(value = "oAuth2客户端controller", tags = {"oAuth2客户端操作接口"})
public class SysOauthClientDetailsController {

}
