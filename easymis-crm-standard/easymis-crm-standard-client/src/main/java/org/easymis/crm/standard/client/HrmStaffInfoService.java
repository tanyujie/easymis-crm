package org.easymis.crm.standard.client;

import org.easymis.crm.standard.object.HrmStaffInfoQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrmStaffInfoService {
	@Autowired
	private HrmStaffInfoClient staffClient;

	@HystrixCommand(fallbackMethod = "findByMemberAndOrganizeFallback")
	public HrmStaffInfoQo findByMemberAndOrganize(String memberId, String orgId) {
		String json = staffClient.findByMemberAndOrganize(memberId, orgId);
		HrmStaffInfoQo staffInfo = new Gson().fromJson(json, HrmStaffInfoQo.class);
		return staffInfo;

	}

	private String findByMemberAndOrganizeFallback(String username, String password) {
		return null;
	}
}
