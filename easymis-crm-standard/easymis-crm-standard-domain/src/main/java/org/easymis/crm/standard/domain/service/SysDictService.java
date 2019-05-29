package org.easymis.crm.standard.domain.service;

import org.easymis.crm.standard.domain.entity.SysDict;
import org.easymis.crm.standard.domain.mapper.SysDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysDictService {
    @Autowired
    private SysDictMapper dictMapper;
	public SysDict findById(String dictId) {
		return dictMapper.findById(dictId);
	}
}
