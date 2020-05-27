package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.ProductDTO;
import com.example.mapstruct.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// Here you define simple method signatures for converting Entity to
// DTO, DTO to Entity, List of Entity to List of DTOs, while MapStruct
// will generate implementation code during build time
@Mapper
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProductDTOs(List<Product> products);
    Product toProduct(ProductDTO productDTO);

}
