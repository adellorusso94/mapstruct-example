package com.example.mapstruct.mapper;

import com.example.mapstruct.MapstructApplication;
import com.example.mapstruct.dto.ProductDTO;
import com.example.mapstruct.entity.Product;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = MapstructApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductMapperUnitTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void A_toProductDTO() {

        Product product = new Product();
        product.setName("Source Name");
        product.setDescription("Source Description");
        product.setPrice(new BigDecimal(99.90));

        ProductDTO productDTO = productMapper.toProductDTO(product);

        assertEquals(product.getName(),productDTO.getName());
        assertEquals(product.getDescription(),productDTO.getDescription());
        assertEquals(product.getPrice(),productDTO.getPrice());

    }

    @Test
    public void B_toProductDTOs() {

        List<Product> products = new ArrayList<Product>();
        for (int i = 1; i <= 5; i++) {
            Product product = new Product();
            product.setName("Source Name " + i);
            product.setDescription("Source Description " + i);
            product.setPrice(new BigDecimal(99.90*i));
            products.add(product);
        }

        List<ProductDTO> productDTOs = productMapper.toProductDTOs(products);

        for (int j = 0; j < 5; j++) {
            ProductDTO productDTO = productDTOs.get(j);
            Product product = products.get(j);
            assertEquals(productDTO.getName(), product.getName());
            assertEquals(productDTO.getDescription(), product.getDescription());
            assertEquals(productDTO.getPrice(), product.getPrice());
        }

    }

    @Test
    public void C_toProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Destination Name");
        productDTO.setDescription("Destination Description");
        productDTO.setPrice(new BigDecimal(89.90));

        Product product = productMapper.toProduct(productDTO);

        assertEquals(productDTO.getName(),product.getName());
        assertEquals(productDTO.getDescription(),product.getDescription());
        assertEquals(productDTO.getPrice(),product.getPrice());
    }
}