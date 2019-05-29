package org.easymis.crm.standard.restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo-t on 2019-05-16.
 */
public class BaseController {
    private PathMatcher pathMatcher = new AntPathMatcher();

/*    @Autowired
    private UserRestService userService;
    public Long getMerchantId(String userName){
        Long merchantId = null;
        String json =  userService.findByName(userName);
        UserQo user = new Gson().fromJson(json, UserQo.class);
        if(user != null) merchantId = user.getMerchant().getId();
        return merchantId;
    }

    public MerchantQo getMerchantByUserName(String userName){
        String merchantId = null;
        String json =  userService.findByName(userName);
        UserQo user = new Gson().fromJson(json, UserQo.class);
        return user.getMerchant();
    }*/
}
