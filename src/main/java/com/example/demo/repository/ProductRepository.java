package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    List<Product> findAll();

    //     Below Query is automatically executed when we call the below find method
//    @Query("SELECT p FROM Product p WHERE " +
//            "LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
//            "LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
//            "LOWER(p.category) LIKE LOWER(CONCAT('%', :query, '%'))")
//    List<Product> searchProducts(String query);

    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(String query1, String query2, String query3);
}
