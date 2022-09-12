package com.fexmon.fexmonecommerce.repository;

import com.fexmon.fexmonecommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    Optional<ProductModel> findByProductName(final String productName);
}
