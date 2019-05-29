package org.easymis.crm.standard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("EASYMIS-CRM-LEADS-RESTAPI")
public interface SysDictClient {
	@RequestMapping(method = RequestMethod.GET, value = "/crm/sys/dict/{id}")
	String findById(@RequestParam("dictId") String dictId);

	@RequestMapping(method = RequestMethod.GET, value = "/crm/sys/dict/findByPage")
	String findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
