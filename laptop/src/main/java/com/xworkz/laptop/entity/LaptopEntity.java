package com.xworkz.laptop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptop_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "laptop_name")
    private  String laptopName;
    @Column(name="laptop_price")
    private int laptopPrice;
    @Column(name = "laptop_brand")
    private String laptopBrand;
    @Column(name = "owner_name")
    private String ownerName;
}
