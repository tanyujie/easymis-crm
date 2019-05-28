package org.easymis.crm.leads.web.controller;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpSession;

import org.easymis.crm.leads.client.service.LeadsFuture;
import org.easymis.crm.leads.client.service.LeadsRestService;
import org.easymis.crm.leads.object.LeadsQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Created by lenovo-t on 2019-05-16.
 */
@Controller
@RequestMapping("/crm/leads")
public class LeadsController {
	@Autowired
	private LeadsRestService userService;
	@Autowired
	private LeadsFuture leadsFuture;

	@RequestMapping("/index")
	public String index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "index";
	}
	@ApiOperation(value = "获取线索详细信息", notes = "根据url的id来获取线索详细信息")
    @ApiImplicitParam(name = "id", value = "线索ID", required = true, dataType = "String")
	@RequestMapping(value = "/show/{id}")
	public CompletableFuture<String> show(ModelMap model, @PathVariable String id) {
		return leadsFuture.findById(id).thenApply(json -> {
			LeadsQo leads = new Gson().fromJson(json, LeadsQo.class);
			model.addAttribute("leads", leads);
			return "leads/show";
		});
	}
}
