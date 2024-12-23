package com.example.Sale.Campaign.Management.System.controller;

import com.example.Sale.Campaign.Management.System.model.SaleCampaign;
import com.example.Sale.Campaign.Management.System.services.CampaignServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaign")
public class CampaignController {
    @Autowired
    private CampaignServices campaignServices;
    @PostMapping("/saveCampaign")
    public void saveCampaign(@RequestBody SaleCampaign saleCampaign)
    {
        campaignServices.saveCampaign(saleCampaign);
    }
}
