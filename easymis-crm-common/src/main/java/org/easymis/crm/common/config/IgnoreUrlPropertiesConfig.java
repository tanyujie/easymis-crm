package org.easymis.crm.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
/*@RefreshScope*/
@ConfigurationProperties(prefix = "ignore")
@Component
public class IgnoreUrlPropertiesConfig {

    private List<String> urls = new ArrayList<>();

    private List<String> client = new ArrayList<>();

}
