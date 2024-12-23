package com.example.Sale.Campaign.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_product")
public class Product {
    @Id
    @Column(name = "product_id")
    private int productId;
    private String title;
    private String description;
    private double mrp;
    private double currentPrice;
    private double discount;
    private int inventoryCount;

    @OneToMany(mappedBy = "productHistory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<History> historyList;

    @OneToMany(mappedBy = "productDiscount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Discount> discountList;

    public Product(int productId) {
        this.productId = productId;
    }
}
