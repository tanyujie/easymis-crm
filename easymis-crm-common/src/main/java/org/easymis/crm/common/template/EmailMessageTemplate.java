package org.easymis.crm.common.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailMessageTemplate extends MessageTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * email地址
	 */
	private String email;

}
