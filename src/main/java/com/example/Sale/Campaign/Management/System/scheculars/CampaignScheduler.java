package com.example.Sale.Campaign.Management.System.scheculars;

import com.example.Sale.Campaign.Management.System.model.Discount;
import com.example.Sale.Campaign.Management.System.model.History;
import com.example.Sale.Campaign.Management.System.model.Product;
import com.example.Sale.Campaign.Management.System.model.SaleCampaign;
import com.example.Sale.Campaign.Management.System.repository.CampaignRepository;
import com.example.Sale.Campaign.Management.System.repository.HistoryRepository;
import com.example.Sale.Campaign.Management.System.repository.ProductRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Port;
import java.util.Date;
import java.util.List;
@Component
public class CampaignScheduler {
    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Scheduled(cron = "0 0 0 * * *")

    public void StartCampaign() {
        List<SaleCampaign> saleCampaigns = campaignRepository.startedCampaign();
        for (SaleCampaign saleCampaign : saleCampaigns) {
            for (Discount discount : saleCampaign.getDiscountList()) {
                Product product = discount.getProductDiscount();
                makeHistory(product, saleCampaign);
                product.setCurrentPrice(product.getCurrentPrice() - product.getCurrentPrice() * discount.getDiscountRate() / 100);
                product.setDiscount(product.getDiscount() + discount.getDiscountRate());
                productRepository.save(product);
            }
        }
    }

    private void makeHistory(Product product, SaleCampaign saleCampaign) {
        History history = new History();
        history.setProductHistory(product);
        history.setOldPrice(product.getCurrentPrice());
        history.setDiscount(product.getDiscount());
        history.setDate(saleCampaign.getStartDate());
        historyRepository.save(history);
    }

    @Scheduled(cron = "59 59 23 * * *")
    public void endCampaign() {
        System.out.println("Campaign End");
        List<SaleCampaign> saleCampaigns = campaignRepository.endCampaign();
        for (SaleCampaign saleCampaign : saleCampaigns) {
            for (Discount discount : saleCampaign.getDiscountList()) {
                Product product = discount.getProductDiscount();
                History oldHistory = historyRepository.getOldHistory(product.getProductId(),saleCampaign.getStartDate());
                makeEndDateHistory(product, saleCampaign);
                product.setCurrentPrice(oldHistory.getOldPrice());
                product.setDiscount(oldHistory.getDiscount());
                productRepository.save(product);
            }
        }
    }

    private void makeEndDateHistory(Product product, SaleCampaign saleCampaign) {
        History history = new History();
        history.setProductHistory(product);
        history.setOldPrice(product.getCurrentPrice());
        history.setDiscount(product.getDiscount());
        history.setDate(saleCampaign.getEndDate());
        historyRepository.save(history);
    }


}
