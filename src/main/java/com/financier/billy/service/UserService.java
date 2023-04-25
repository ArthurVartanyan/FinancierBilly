package com.financier.billy.service;

import com.financier.billy.dto.UserDTO;
import com.financier.billy.mapper.UserMapper;
import com.financier.billy.model.User;
import com.financier.billy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDTO generateUser() {
        return userMapper.map(userRepository.save(new User()), UserDTO.class);
    }

    public boolean userExistsById(Long userId) {
        return userRepository.existsById(userId);
    }
}