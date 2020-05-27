package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.CarDTO;
import com.example.mapstruct.dto.FuelType;
import com.example.mapstruct.entity.BioDieselCar;
import com.example.mapstruct.entity.Car;
import com.example.mapstruct.entity.ElectricCar;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CarMapper {

    @BeforeMapping
    protected void enrichDTOWithFuelType(Car car, @MappingTarget CarDTO carDTO) {
        if (car instanceof ElectricCar) {
            carDTO.setFuelType(FuelType.ELECTRIC);
        } else if (car instanceof BioDieselCar) {
            carDTO.setFuelType(FuelType.BIO_DIESEL);
        }
    }

    @Mappings({
            @Mapping(target = "carName", source = "car.name")
    })
    public abstract CarDTO carToCarDTO(Car car);

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget CarDTO carDTO) {
        carDTO.setCarName(carDTO.getCarName().toUpperCase());
    }

}
