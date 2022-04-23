package com.arcane.app.repository;

import com.arcane.app.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring Data SQL repository for the Product entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

//    @Query("SELECT a FROM Product a " +
//        "LEFT JOIN FETCH a.orderDetails LEFT JOIN FETCH a.images")
//    Page<Product> getAllProducts(Pageable pageable);
}
