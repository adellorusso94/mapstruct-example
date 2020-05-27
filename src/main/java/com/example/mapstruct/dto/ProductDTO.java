package com.example.mapstruct.dto;

import lombok.Data;

import java.math.BigDecimal;

// DTO (Data Transfer Object): Design pattern used for
// customizing/aggregating data input and output so reducing the
// number of call to remove API
@Data
public class ProductDTO {

    private String name;
    private String description;
    private BigDecimal price;

}
