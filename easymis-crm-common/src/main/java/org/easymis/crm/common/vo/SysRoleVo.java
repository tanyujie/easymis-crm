package org.easymis.crm.common.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色表
 * 
 * @ClassName: SysRoleVo
 * @Description: TODO(角色表)
 * @author lenovo-t
 * @date 2019年5月29日
 *
 */
@Data
@Accessors(chain = true)
public class SysRoleVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer roleId;

	/**
	 * 角色code用于springsecurity角色标识码
	 */
	private String roleCode;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime modifyTime;

	/**
	 * 是否删除 1-删除，0-未删除
	 */
	private String delFlag;
}
