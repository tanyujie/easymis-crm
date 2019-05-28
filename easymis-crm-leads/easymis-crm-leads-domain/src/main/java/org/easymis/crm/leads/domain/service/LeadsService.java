package org.easymis.crm.leads.domain.service;

import java.util.List;
import java.util.Optional;

import org.easymis.crm.leads.domain.config.CacheComponent;
import org.easymis.crm.leads.domain.entity.Leads;
import org.easymis.crm.leads.domain.mapper.LeadsMapper;
import org.easymis.crm.leads.domain.repository.LeadsRepository;
import org.easymis.crm.leads.domain.util.CommonUtils;
import org.easymis.crm.leads.domain.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class LeadsService {
    @Autowired
    private LeadsRepository leadsRepository;
    @Autowired
    private LeadsMapper leadsMapper;
    @Autowired
    private CacheComponent cacheComponent;
    public  Leads findOne(String id){
    	Leads user = null;
        //使用缓存
        Object object = cacheComponent.get(Constant.CRM_LEADS_ID, id.toString());
        if (CommonUtils.isNull(object)) {
        	Optional<Leads> member = leadsRepository.findById(id);
            if (member.isPresent()) {
            	user=member.get();
                cacheComponent.put(Constant.CRM_LEADS_ID, id.toString(), user, 12);            	
            }

        } else {
            user = (Leads) object;
        }
        return  user;
    }

	public Leads findById(String id) {
		Leads leads = null;
		// 使用缓存
		Object object = cacheComponent.get(Constant.CRM_LEADS_ID, id.toString());
		if (CommonUtils.isNull(object)) {
			leads = leadsMapper.findById(id);
			if (leads != null) {
				cacheComponent.put(Constant.CRM_LEADS_ID, id.toString(), leads, 12);
			}

		} else {
			leads = (Leads) object;
		}
		return leads;
	}

	public PageInfo findAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Leads> leadsList = leadsMapper.findAll();
		PageInfo<Leads> pageInfo = new PageInfo<Leads>(leadsList);
		return pageInfo;
	}
    public List<Leads> findAll() {
        return leadsMapper.findAll();
    }
}
