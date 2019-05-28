package org.easymis.crm.leads.web.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpSession;

import org.easymis.crm.leads.client.service.LeadsFuture;
import org.easymis.crm.leads.client.service.LeadsRestService;
import org.easymis.crm.leads.object.LeadsQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Created by lenovo-t on 2019-05-16.
 */
@Controller
@RequestMapping("/crm/leads")
public class LeadsController {

	@Autowired
	private LeadsRestService leadsService;

	@Autowired
	private LeadsFuture leadsFuture;

	@RequestMapping("/index")
	public String index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getLeads(ModelMap model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize)
			throws InterruptedException, ExecutionException {

		// model.addAttribute("pageInfo", leadsService.findByPage(pageNum, pageSize));
		return leadsService.findByPage(pageNum, pageSize);

	}
	@RequestMapping(value = "/show/page")
	@ResponseBody
	public CompletableFuture<String> showPage(ModelMap model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return leadsFuture.findByPage(pageNum, pageSize).thenApply(json -> {
			return json;
		});
	}
	public List<LeadsQo> getLeadsList() {
		// 处理"/crm/leads/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		List<LeadsQo> r = null;// leadsService.find();
		return r;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute LeadsQo leads) {
		// 处理"/crm/leads/"的POST请求，用来创建User
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		// users.put(user.getId(), user);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public LeadsQo getLeads(@PathVariable Long id) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		// return users.get(id);
		return null;
	}

	/*
	 * @ApiOperation(value = "获取线索详细信息", notes = "根据url的id来获取线索详细信息")
	 * 
	 * @ApiImplicitParam(name = "id", value = "线索ID", required = true, dataType =
	 * "String")
	 */
	@RequestMapping(value = "/show/{id}")
	public CompletableFuture<String> show(ModelMap model, @PathVariable String id) {
		return leadsFuture.findById(id).thenApply(json -> {
			LeadsQo leads = new Gson().fromJson(json, LeadsQo.class);
			model.addAttribute("leads", leads);
			return "leads/show";
		});
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putLeads(@PathVariable Long id, @ModelAttribute LeadsQo leads) {
		// 处理"/crm/leads/{id}"的PUT请求，用来更新User信息
		/*
		 * User u = users.get(id); u.setName(user.getName()); u.setAge(user.getAge());
		 * users.put(id, u);
		 */
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteLeads(@PathVariable String id) {
		// 处理"/crm/leads/{id}"的DELETE请求，用来删除User
		// leadsService.remove(id);
		return "success";
	}

	@RequestMapping("/exception")
	public String hello() throws Exception {
		throw new Exception("发生错误");
	}
}
