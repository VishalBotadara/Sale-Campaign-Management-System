package com.example.Sale.Campaign.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int discountId;

    private double discountRate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productDiscount;

    @ManyToOne
    @JoinColumn(name = "saleCampaign_id")
    private SaleCampaign saleCampaign;



}
