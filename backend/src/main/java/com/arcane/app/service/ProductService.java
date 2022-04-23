package com.arcane.app.service;

import com.arcane.app.domain.Product;
import com.arcane.app.repository.ProductRepository;
import com.arcane.app.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    List<Product> getAllProducts(){
//        return productRepository.getAllProducts();
//    }
//
//    public Page<Product> getAllProducts(int page, int size){
//        Pageable pageable = PageRequest.of(page,size);
//        return productRepository.getAllProducts(pageable);
//    }

    public Page<Product> getAllProducts(Pageable pageable, String search){


        Specification<Product> where = null;

        if (!StringUtils.isEmpty(search)) {
            ProductSpecification nameSpecification = new ProductSpecification("name", "LIKE", search);
            ProductSpecification nameCategorySpecification = new ProductSpecification("category.name", "LIKE", search);
            where = Specification.where(nameSpecification).or(nameCategorySpecification);
        }
        return productRepository.findAll(where, pageable);
    }
}
