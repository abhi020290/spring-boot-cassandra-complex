package com.springbootcassandra.springbootcassandra.service;

import com.springbootcassandra.springbootcassandra.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> findAll();

    Product findById(UUID id);

    void deleteById(UUID id);

    Product saveOrUpdate(Product product);
}
