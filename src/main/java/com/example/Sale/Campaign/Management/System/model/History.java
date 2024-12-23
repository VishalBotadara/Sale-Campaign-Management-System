package com.example.Sale.Campaign.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id")
    private int historyId;
    private double discount;
    private LocalDate date;
    private double oldPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productHistory;
}
