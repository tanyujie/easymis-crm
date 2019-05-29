package org.easymis.crm.standard.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.crm.standard.client.HrmStaffInfoService;
import org.easymis.crm.standard.client.MemberService;
import org.easymis.crm.standard.object.HrmStaffInfoQo;
import org.easymis.crm.standard.object.MemberQo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;



@Controller
@Api(value = "系统登录controller", tags = { "系统登录操作接口" })
public class LoginController extends BaseController{
	@Autowired
	MemberService memberService;
	@Autowired
	HrmStaffInfoService staffInfoService;
	/**
	 * 访问后台登录页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="跳转登录页面", notes="跳转登录页面")
	//@SysLog("跳转登陸页面")
	@RequestMapping(value = { "login.html", "login" }, method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public ModelAndView toLogin() throws ClassNotFoundException {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login");
		return mv;
	}
    @ApiOperation(value = "登录系统 ",notes = "",produces = MediaType.ALL_VALUE)
    @ApiImplicitParams({ @ApiImplicitParam(name = "username",value = "帐号",dataType = "java.lang.String",required = true), @ApiImplicitParam(name = "password",value = "密码",dataType = "java.lang.String",required = true) })
    @ResponseBody
    @RequestMapping(value = "/login.json",method = { RequestMethod.GET, RequestMethod.POST })
    public JSONObject login(HttpServletRequest httpServletRequest,ModelMap map) throws Exception{
        // 首先检测验证码
		JSONObject json = new JSONObject();
        String username = getStringParamDefaultBlank(httpServletRequest, "username");
        String password = getStringParamDefaultBlank(httpServletRequest, "password");
        if(true) {
			// 保存登录IP
			getRemortIP(username);
			HttpSession session=httpServletRequest.getSession();
			MemberQo member=memberService.doLoginCheck(username, password);
			if(null!=member) {
				//保存員工信息
				HrmStaffInfoQo staff=staffInfoService.findByMemberAndOrganize(member.getMemberId(), null);
				session.setAttribute("staffId", staff.getStaffId());
				session.setAttribute("staffName", staff.getName());
				//session.setAttribute(org.easymis.commons.Constants.SESSION_STAFF, staff);	
				String tokenId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
				if (staff != null) {
					//session.setAttribute(tokenId + ":memberId", member.getMemberId());
					session.setAttribute(tokenId + ":staffId", staff.getStaffId());
					session.setAttribute(tokenId + ":orgId", staff.getOrgId());
					session.setAttribute(tokenId + ":staffName", staff.getName());
					session.setAttribute(tokenId + ":sessionStaff", staff);
				}

				json.put("msg", "登陆成功");
				json.put("success", true);
			}

        }
        else {
        	json.put("msg", "登陆失败/账号不存在");
        	json.put("success", false);
        }
		return json;
    }
	/**
	 * 获取登录用户的IP
	 * 
	 * @throws Exception
	 */
	public void getRemortIP(String username) {
		HttpServletRequest request = this.getRequest();
		Map<String, String> map = new HashMap<String, String>();
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		map.put("username", username);
		map.put("loginIp", ip);
		/*memberService.saveIp(map);
	*/}
	
	
}
