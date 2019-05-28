package org.easymis.crm.leads.object;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LeadsQo extends PageQo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String leadsId;
	private String leadsNo;
	private String leadsName;
	private String orgId;
	private String orgName;
	private Integer filialeOrgId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public LeadsQo() {
	}

	public String getLeadsId() {
		return leadsId;
	}

	public void setLeadsId(String leadsId) {
		this.leadsId = leadsId;
	}

	public String getLeadsNo() {
		return leadsNo;
	}

	public void setLeadsNo(String leadsNo) {
		this.leadsNo = leadsNo;
	}

	public String getLeadsName() {
		return leadsName;
	}

	public void setLeadsName(String leadsName) {
		this.leadsName = leadsName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getFilialeOrgId() {
		return filialeOrgId;
	}

	public void setFilialeOrgId(Integer filialeOrgId) {
		this.filialeOrgId = filialeOrgId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

