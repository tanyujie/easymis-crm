package org.easymis.crm.standard.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.crm.standard.domain.entity.SysDict;

@Mapper
public interface SysDictMapper {
    @Select("SELECT * FROM crm_sys_dict WHERE dict_id = #{dictId}")
    SysDict findById(@Param("dictId") String dictId);
}
