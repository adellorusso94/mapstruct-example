package com.example.mapstruct.mapper;

import com.example.mapstruct.MapstructApplication;
import com.example.mapstruct.dto.DeliveryAddress;
import com.example.mapstruct.entity.Address;
import com.example.mapstruct.entity.Customer;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = MapstructApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryAddressMapperUnitTest {

    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Test
    public void A_from() {

        Customer customer = new Customer();
        customer.setFirstName("Max");
        customer.setLastName("Powers");

        Address address = new Address();
        address.setStreet("123 Some Street");
        address.setCounty("Nevada");
        address.setPostalCode("89123");

        DeliveryAddress deliveryAddress = deliveryAddressMapper.from(customer,address);

        assertEquals(deliveryAddress.getForename(),customer.getFirstName());
        assertEquals(deliveryAddress.getSurname(),customer.getLastName());
        assertEquals(deliveryAddress.getStreet(),address.getStreet());
        assertEquals(deliveryAddress.getCounty(),address.getCounty());
        assertEquals(deliveryAddress.getPostalCode(),address.getPostalCode());

    }

    @Test
    public void B_updateAddress() {

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setForename("Max");
        deliveryAddress.setSurname("Powers");
        deliveryAddress.setStreet("123 Some Street");
        deliveryAddress.setCounty("Nevada");
        deliveryAddress.setPostalCode("89123");

        Address newAddress = new Address();
        newAddress.setStreet("456 Some other street");
        newAddress.setCounty("Arizona");
        newAddress.setPostalCode("12345");

        DeliveryAddress updatedDeliveryAddress = deliveryAddressMapper.updateAddress(deliveryAddress,newAddress);

        assertSame(deliveryAddress,updatedDeliveryAddress);
        assertEquals(deliveryAddress.getStreet(),newAddress.getStreet());
        assertEquals(deliveryAddress.getCounty(),newAddress.getCounty());
        assertEquals(deliveryAddress.getPostalCode(),newAddress.getPostalCode());

    }
}