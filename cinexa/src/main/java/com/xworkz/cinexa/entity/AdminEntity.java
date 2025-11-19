package com.xworkz.cinexa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin_info")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name="admin_email",unique = true)
    private String adminEmail;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_verify_time")
    private LocalDateTime localDateTime;
}
