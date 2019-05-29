package org.easymis.crm.common.exception;

public class EasymisCrmPermissionDefinedException  extends RuntimeException {
	public EasymisCrmPermissionDefinedException() {
		super("权限不足，访问失败");
	}
}
