package com.example.mapstruct.service;

import com.example.mapstruct.entity.Product;
import com.example.mapstruct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findOneById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product stock) {
        return productRepository.save(stock);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}