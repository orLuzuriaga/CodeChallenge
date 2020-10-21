package com.codeChallenge.codeChallenge.dto;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private LocalDate  birthDate;
    private AddressDto  Address;  
}
