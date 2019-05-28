package org.easymis.crm.leads.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.crm.leads.domain.entity.Leads;

@Mapper
public interface  LeadsMapper {
    @Select("SELECT * FROM crm_leads WHERE leads_id = #{leadsId}")
    Leads findById(@Param("leadsId") String leadsId);
    @Insert("INSERT INTO crm_leads(leads_id, leads_name, org_id,creator_id,delete_status) VALUES(#{leadsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("leadsId") String leadsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO crm_leads(leads_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{leadsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO crm_leads(leads_id, leads_name, org_id,creator_id,delete_status) VALUES(#{leadsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insertByUser(Leads leads);

    @Update("UPDATE crm_leads leads_name = #{leadsName} WHERE leads_id = #{leadsId}")
    void update(Leads leads);

    @Delete("DELETE FROM crm_leads WHERE leads_id = #{leadsId}")
    void delete(String leadsId);

    @Results({
            @Result(property = "leadsId", column = "leads_id"),
            @Result(property = "leadsName", column = "leads_name"),
            @Result(property = "orgId", column = "org_id")
    })
    @Select("SELECT leads_id, leads_name, org_id FROM crm_leads")
    List<Leads> findAll();
}
