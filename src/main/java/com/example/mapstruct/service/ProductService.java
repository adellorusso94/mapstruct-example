package com.example.mapstruct.service;

import com.example.mapstruct.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAll();
    public Optional<Product> findOneById(Long id);
    public Product save(Product stock);
    public void deleteById(Long id);

}
