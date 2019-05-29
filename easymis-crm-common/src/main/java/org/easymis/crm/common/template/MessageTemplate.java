package org.easymis.crm.common.template;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息发送基础模板
 * 
 * @ClassName: MessageTemplate
 * @Description: TODO(消息发送基础模板)
 * @author lenovo-t
 * @date 2019年5月29日
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 消息通道
	 */
	private String channel;
}
