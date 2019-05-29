package org.easymis.crm.common.template.sms;

import java.io.Serializable;

import org.easymis.crm.common.template.MessageTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmsMessageTemplate extends MessageTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4312549379591702413L;

	/**
	 * 电话号码
	 */
	private String mobile;

	/**
	 * 短信签名
	 */
	private String signName;

	/**
	 * 模板
	 */
	private String template;

	/**
	 * 腾讯云参数回填
	 */
	private String[] params;
}
