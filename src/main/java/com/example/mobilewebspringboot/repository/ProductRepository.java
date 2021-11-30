package com.example.mobilewebspringboot.repository;

import java.util.List;

import com.example.mobilewebspringboot.entity.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
}
