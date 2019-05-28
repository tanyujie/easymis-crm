package org.easymis.crm.leads.restapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常创建对应的处理
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO(异常创建对应的处理)
 * @author lenovo-t
 * @date 2019年5月28日
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = RestApiException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, RestApiException e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
}
