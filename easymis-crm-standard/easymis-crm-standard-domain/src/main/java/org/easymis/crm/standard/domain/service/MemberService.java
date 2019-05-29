package org.easymis.crm.standard.domain.service;

import org.easymis.crm.standard.domain.entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class MemberService {
	public Member findByMemberName(String memberName) {
		return null;
	}
}
