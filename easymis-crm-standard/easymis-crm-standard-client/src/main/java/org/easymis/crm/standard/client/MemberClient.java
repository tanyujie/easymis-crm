package org.easymis.crm.standard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("easymis-crm-standard-restapi")
public interface MemberClient {
	@RequestMapping(method = RequestMethod.GET, value = "/crm/standard/member/findByMemberName")
	String findByMemberName(@RequestParam("memberName") String memberName);

	@RequestMapping(method = RequestMethod.GET, value = "/crm/sys/dict/findByPage")
	String findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
