package com.xworkz.foods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String userEmail;
    private long userPhone;
    private String userPassword;
    private int userAge;
    private String userGender;
    private String userCity;
    private String userCountry;
    private String userSkills;
}
