package com.fexmon.fexmonecommerce.service;

import com.fexmon.fexmonecommerce.dto.UserDTO;
import com.fexmon.fexmonecommerce.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel fetchUser(final Long userId);

    List<UserModel> fetchUserList();

    UserModel saveUser(final UserModel user);

    UserModel updateUser(final UserDTO userDTO, final Long userId);

    void removeUser(final Long userId);
}
