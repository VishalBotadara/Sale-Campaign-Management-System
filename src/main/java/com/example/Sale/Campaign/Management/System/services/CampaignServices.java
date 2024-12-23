package com.example.Sale.Campaign.Management.System.services;

import com.example.Sale.Campaign.Management.System.model.Discount;
import com.example.Sale.Campaign.Management.System.model.SaleCampaign;
import com.example.Sale.Campaign.Management.System.repository.CampaignRepository;
import com.example.Sale.Campaign.Management.System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServices {
    @Autowired
    private CampaignRepository campaignRepository;

    public void saveCampaign(SaleCampaign saleCampaign) {
        List<Discount> list = saleCampaign.getDiscountList();
        for(Discount discount : list){
            discount.setSaleCampaign(saleCampaign);
        }
        saleCampaign.setDiscountList(list);
        campaignRepository.save(saleCampaign);
    }
}
