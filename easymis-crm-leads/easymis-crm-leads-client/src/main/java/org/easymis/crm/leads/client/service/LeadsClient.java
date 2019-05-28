package org.easymis.crm.leads.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient("EASYMIS-CRM-LEADS-RESTAPI")
public interface LeadsClient {
	@RequestMapping(method = RequestMethod.GET, value = "/crm/leads/{id}")
	String findById(@RequestParam("id") String id);
}
