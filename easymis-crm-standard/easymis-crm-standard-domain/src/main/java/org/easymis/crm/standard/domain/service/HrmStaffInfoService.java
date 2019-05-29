package org.easymis.crm.standard.domain.service;

import org.easymis.crm.standard.domain.entity.HrmStaffInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HrmStaffInfoService {
	public HrmStaffInfo findByMemberAndOrganize(String memberId,  String orgId) {
		return null;
	}
}
