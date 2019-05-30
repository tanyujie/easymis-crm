package org.easymis.crm.standard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("EASYMIS-CRM-STANDARD-RESTAPI")
public interface SysDictClient {
	@RequestMapping(method = RequestMethod.GET, value = "/crm/standard/sys/dict/{id}")
	String findById(@RequestParam("dictId") String dictId);

	@RequestMapping(method = RequestMethod.GET, value = "/crm/standard/sys/dict/findByPage")
	String findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
