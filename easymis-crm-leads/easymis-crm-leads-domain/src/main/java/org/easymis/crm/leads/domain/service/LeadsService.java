package org.easymis.crm.leads.domain.service;

import java.util.Optional;

import org.easymis.crm.leads.domain.config.CacheComponent;
import org.easymis.crm.leads.domain.entity.Leads;
import org.easymis.crm.leads.domain.repository.LeadsRepository;
import org.easymis.crm.leads.domain.util.CommonUtils;
import org.easymis.crm.leads.domain.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeadsService {
    @Autowired
    private LeadsRepository leadsRepository;
    @Autowired
    private CacheComponent cacheComponent;
    public  Leads findOne(String id){
    	Leads user = null;
        //使用缓存
        Object object = cacheComponent.get(Constant.MERCHANT_CENTER_USER_ID, id.toString());
        if (CommonUtils.isNull(object)) {
        	Optional<Leads> member = leadsRepository.findById(id);
            if (member.isPresent()) {
            	user=member.get();
                cacheComponent.put(Constant.MERCHANT_CENTER_USER_ID, id.toString(), user, 12);            	
            }

        } else {
            user = (Leads) object;
        }
        return  user;
    }
}
