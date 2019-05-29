package org.easymis.crm.standard.client;

import org.easymis.crm.standard.object.MemberQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MemberService {
	@Autowired
	private MemberClient memberClient;

	@HystrixCommand(fallbackMethod = "doLoginCheckFallback")
	public MemberQo doLoginCheck(String username, String password) {
		String json = memberClient.findByMemberName(username);
		MemberQo member = new Gson().fromJson(json, MemberQo.class);
		if (password != null && !"".equals(password) && password.equals(member.getPassword()))
			return member;
		else
			return null;

	}
	private String doLoginCheckFallback(String username, String password) {
		return null;
	}

}
