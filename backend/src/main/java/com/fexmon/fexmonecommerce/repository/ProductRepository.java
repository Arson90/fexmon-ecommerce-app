package com.fexmon.fexmonecommerce.repository;

import com.fexmon.fexmonecommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
