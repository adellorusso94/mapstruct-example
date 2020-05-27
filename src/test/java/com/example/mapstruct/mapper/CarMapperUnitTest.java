package com.example.mapstruct.mapper;

import com.example.mapstruct.MapstructApplication;
import com.example.mapstruct.dto.CarDTO;
import com.example.mapstruct.dto.FuelType;
import com.example.mapstruct.entity.BioDieselCar;
import com.example.mapstruct.entity.Car;
import com.example.mapstruct.entity.ElectricCar;
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
public class CarMapperUnitTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void A_carToCarDTO() {

        Car car = new ElectricCar();
        car.setId(Long.valueOf(12));
        car.setName("Tesla Model C");

        CarDTO carDTO = carMapper.carToCarDTO(car);

        assertEquals("TESLA MODEL C", carDTO.getCarName());
        assertEquals(FuelType.ELECTRIC, carDTO.getFuelType());

    }

    @Test
    public void B_carToCarDTO() {

        Car car = new BioDieselCar();
        car.setId(Long.valueOf(11));
        car.setName("Tesla Model X");

        CarDTO carDTO = carMapper.carToCarDTO(car);

        assertEquals("TESLA MODEL X", carDTO.getCarName());
        assertEquals(FuelType.BIO_DIESEL, carDTO.getFuelType());

    }
}