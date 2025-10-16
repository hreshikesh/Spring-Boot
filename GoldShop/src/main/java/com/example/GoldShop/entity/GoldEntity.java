package com.example.GoldShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gold_table")
public class GoldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ornament_name")
    private String goldOrnamentName;
    @Column(name = "gold_price")
    private int goldPrice;
    @Column(name = "gold_company")
    private  String company;
    @Column(name = "gold_dealer")
    private String dealer;

}
