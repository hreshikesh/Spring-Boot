package com.xworkz.laptop.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDto {
    private int id;
    @NotNull(message = "Laptop name should not be empty")
    @Size(min = 3, max = 10, message = "Laptop name should be between 3 and 10")
    private String laptopName;
    @NotNull(message = "Laptop price should not be empty")
    @Min(value = 10000, message = "Price should be minimum 10000")
    @Max(value = 500000, message = "Price should be maximum 500000")
    private int laptopPrice;
    @NotNull(message = "Laptop brand should not be empty")
    @Size(min = 3, max = 10, message = "Laptop brand should be between 3 and 10")
    private String laptopBrand;
    @NotNull(message = "Owner name should not be empty")
    @Size(min = 3, max = 10, message = "Owner name should be between 3 and 10")
    private String ownerName;
}
