package com.xworkz.cinexa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seat_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "seat_name")
    private String seatName;
    @Column(name = "seat_available")
    private String seatStatus;
}
