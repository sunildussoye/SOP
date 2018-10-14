package com.salesorderprocessing.repository;

import com.salesorderprocessing.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
