package org.easymis.crm.leads.domain.repository;

import java.util.Optional;

import org.easymis.crm.leads.domain.entity.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, String>, JpaSpecificationExecutor<Leads> {

    @Query("select distinct u from Leads u where u.leadsId= :leadsId")
    Optional<Leads> findById(@Param("leadsId") String leadsId);

}