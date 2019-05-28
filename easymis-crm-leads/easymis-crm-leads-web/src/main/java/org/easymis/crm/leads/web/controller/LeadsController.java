package org.easymis.crm.leads.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.crm.leads.client.service.LeadsFuture;
import org.easymis.crm.leads.client.service.LeadsRestService;
import org.easymis.crm.leads.object.LeadsQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Created by lenovo-t on 2019-05-16.
 */
@Controller
@RequestMapping("/crm/leads")
public class LeadsController {
	@Autowired
	private LeadsRestService userService;
	@Autowired
	private LeadsFuture userFuture;

	@RequestMapping("/index")
	public String index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "index";
	}

	@RequestMapping(value = "/show/{id}")
	public CompletableFuture<String> show(ModelMap model, @PathVariable String id) {
		return userFuture.findById(id).thenApply(json -> {
			LeadsQo user = new Gson().fromJson(json, LeadsQo.class);
			model.addAttribute("user", user);
			return "user/show";
		});
	}
}
