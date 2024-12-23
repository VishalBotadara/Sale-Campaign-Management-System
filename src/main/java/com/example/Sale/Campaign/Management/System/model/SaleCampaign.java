package com.example.Sale.Campaign.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_sale_campaign")
public class SaleCampaign {
    @Id
    @Column(name = "campaignId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int campaignId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String campaignName;

    @OneToMany(mappedBy = "saleCampaign",cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<Discount> discountList;
}