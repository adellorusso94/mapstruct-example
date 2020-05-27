package com.example.mapstruct.dto;

import lombok.Data;

@Data
public class DeliveryAddress {

    private String forename;
    private String surname;
    private String street;
    private String postalCode;
    private String county;

}
