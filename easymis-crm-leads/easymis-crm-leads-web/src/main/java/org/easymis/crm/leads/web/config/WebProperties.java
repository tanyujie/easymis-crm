package org.easymis.crm.leads.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebProperties {
    @Value("${org.easymis.leads.name}")
    private String name;
    @Value("${org.easymis.leads.title}")
    private String title;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    
}
