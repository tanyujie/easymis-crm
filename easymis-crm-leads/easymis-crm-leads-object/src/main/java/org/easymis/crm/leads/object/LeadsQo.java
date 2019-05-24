package org.easymis.crm.leads.object;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LeadsQo extends PageQo implements java.io.Serializable {
	private String memberId;
    private String orgId;
    private String memberName;
    private String name;
    private String password;
	private Integer sex;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;

	public LeadsQo() {
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getOrgId() {
		return orgId;
	}



	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}

