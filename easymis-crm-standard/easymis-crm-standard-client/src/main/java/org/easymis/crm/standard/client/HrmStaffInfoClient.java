package org.easymis.crm.standard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("easymis-crm-standard-restapi")
public interface HrmStaffInfoClient {
	@RequestMapping(method = RequestMethod.GET, value = "/crm/standard/hrmStaffInfo/findByMemberAndOrganize")
	String findByMemberAndOrganize(@RequestParam("memberId") String memberId, @RequestParam("orgId") String orgId);

	@RequestMapping(method = RequestMethod.GET, value = "/crm/sys/dict/findByPage")
	String findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
