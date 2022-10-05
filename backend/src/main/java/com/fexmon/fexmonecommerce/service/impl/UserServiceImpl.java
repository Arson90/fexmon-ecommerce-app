package com.fexmon.fexmonecommerce.service.impl;

import com.fexmon.fexmonecommerce.dto.UserDTO;
import com.fexmon.fexmonecommerce.exception.UserNotFoundException;
import com.fexmon.fexmonecommerce.model.UserModel;
import com.fexmon.fexmonecommerce.repository.UserRepository;
import com.fexmon.fexmonecommerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel fetchUser(final Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public List<UserModel> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserModel saveUser(final UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel updateUser(final UserDTO userDTO, final Long userId) {
        return userRepository.findById(userId)
                .map(userModel -> userModelWrapper(userModel, userDTO))
                .orElseThrow(() -> UserNotFoundException.createUserNotFoundException(userId));
    }

    @Override
    public void removeUser(final Long userId) {

    }

    private UserModel userModelWrapper(final UserModel userModel, final UserDTO userDTO) {
        userModel.setFirstName(userDTO.getFirstName());
        userModel.setLastName(userDTO.getLastName());
        userModel.setEmail(userDTO.getEmail());
        return userRepository.save(userModel);
    }
}
