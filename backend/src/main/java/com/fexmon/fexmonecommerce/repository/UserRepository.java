package com.fexmon.fexmonecommerce.repository;

import com.fexmon.fexmonecommerce.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
