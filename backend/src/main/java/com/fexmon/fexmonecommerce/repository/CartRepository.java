package com.fexmon.fexmonecommerce.repository;

import com.fexmon.fexmonecommerce.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartModel, Long> {
}
