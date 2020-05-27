package com.example.mapstruct.controller;

import com.example.mapstruct.dto.ProductDTO;
import com.example.mapstruct.entity.Product;
import com.example.mapstruct.mapper.ProductMapper;
import com.example.mapstruct.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findOneById(id);
        return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        productService.save(productMapper.toProduct(productDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
