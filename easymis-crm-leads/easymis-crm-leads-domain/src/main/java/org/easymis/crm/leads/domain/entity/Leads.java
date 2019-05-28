package org.easymis.crm.leads.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crm_leads")
public class Leads implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String leadsId;
	@Column(name = "leads_no")
	private String leadsNo;
	@Column(name = "leads_name")
	private String leadsName;
	@Column(name = "org_id")
	private String orgId;

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

}
