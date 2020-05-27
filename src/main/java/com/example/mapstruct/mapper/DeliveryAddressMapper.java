package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.DeliveryAddress;
import com.example.mapstruct.entity.Address;
import com.example.mapstruct.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper
public interface DeliveryAddressMapper {

    @Mappings({
            @Mapping(source = "customer.firstName", target = "forename"),
            @Mapping(source = "customer.lastName", target = "surname"),
            @Mapping(source = "address.street", target = "street"),
            @Mapping(source = "address.postalCode", target = "postalCode"),
            @Mapping(source = "address.county", target = "county")
    })
    DeliveryAddress from(Customer customer, Address address);

    @Mappings({
            @Mapping(source = "address.street", target = "street"),
            @Mapping(source = "address.postalCode", target = "postalCode"),
            @Mapping(source = "address.county", target = "county")
    })
    DeliveryAddress updateAddress(@MappingTarget DeliveryAddress deliveryAddress, Address address);

}
