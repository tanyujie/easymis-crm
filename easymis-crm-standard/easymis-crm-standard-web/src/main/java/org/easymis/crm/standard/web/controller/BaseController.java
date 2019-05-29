package org.easymis.crm.standard.web.controller;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	public Logger log = null;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 获取日志对象
	 * 
	 * @return
	 */
	public Logger getInstance() {
		if (log == null) {
			log = LoggerFactory.getLogger(BaseController.class);
		}
		return log;
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}

	/**
	 * 获得模板路径。不对模板文件进行本地化处理。
	 * 
	 * @param solution
	 *            方案路径
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。不本地化处理。
	 * @return
	 */
	public String getTplPath(String name) {
		String path = getRequest().getContextPath();
		String basePath = getRequest().getScheme() + "://" + getRequest().getServerName() + ":"
				+ getRequest().getServerPort() + path;
		getModelAndView().addObject("base", basePath);
		return "/" + name;
	}

	public String getTplPath(ModelMap model, String name) {
		String path = getRequest().getContextPath();
		String basePath = getRequest().getScheme() + "://" + getRequest().getServerName() + ":"
				+ getRequest().getServerPort() + path;
		model.put("base", basePath);
		return "/" + name;
	}

	public String getTplPath(String dir, String name) {
		return "/" + dir + "/" + name;
	}

	public String getTplPath(String solution, String dir, String name) {
		return solution + "/" + dir + "/" + name;
	}

	public static String getStringParamDefaultBlank(HttpServletRequest request, String paramName) {
		return getStringParamDefault(request, paramName, "");
	}

	public static String getStringParamDefault(HttpServletRequest request, String paramName, String deault) {
		String value = request.getParameter(paramName);
		return value == null ? deault : value;
	}
/*
	public String getMemberId(String tokerId) {
		*//** Shiro管理Session **//*
		Subject sub = SecurityUtils.getSubject();
		Session session = sub.getSession();
		String memberId = null;
		if (tokerId != null && session.getAttribute(tokerId + ":memberId") != null)
			memberId = session.getAttribute(tokerId + ":memberId").toString();
		return memberId;
	}

	public String getStaffId(String tokerId) {
		*//** Shiro管理Session **//*
		Subject sub = SecurityUtils.getSubject();
		Session session = sub.getSession();
		String memberId = null;
		if (tokerId != null && session.getAttribute(tokerId + ":staffId") != null)
			memberId = session.getAttribute(tokerId + ":staffId").toString();
		return memberId;
	}

	public Object getOrgId(String tokerId) {
		*//** Shiro管理Session **//*
		Subject sub = SecurityUtils.getSubject();
		Session session = sub.getSession();
		String orgId = null;
		if (tokerId != null && session.getAttribute(tokerId + ":orgId") != null)
			orgId = session.getAttribute(tokerId + ":orgId").toString();
		return orgId;
	}

	public Object getStaff(String tokerId) {
		*//** Shiro管理Session **//*
		Subject sub = SecurityUtils.getSubject();
		Session session = sub.getSession();
		if (tokerId != null && session.getAttribute(tokerId + ":sessionStaff") != null)
			return session.getAttribute(tokerId + ":sessionStaff");
		return null;
	}*/

	
	protected String getContextPath(){
		return request.getContextPath();
}
}
