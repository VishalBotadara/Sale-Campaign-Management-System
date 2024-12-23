package com.example.Sale.Campaign.Management.System.repository;

import com.example.Sale.Campaign.Management.System.model.SaleCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<SaleCampaign,Integer> {

    @Query(value = "select * from tbl_sale_campaign where start_date=current_date()",nativeQuery = true)
    List<SaleCampaign> startedCampaign();
    @Query(value = "select * from tbl_sale_campaign where end_date=current_date()",nativeQuery = true)
    List<SaleCampaign> endCampaign();
}
