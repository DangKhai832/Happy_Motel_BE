package com.HappyMotelBE.service;


import com.HappyMotelBE.dto.request.UserRequest;
import com.HappyMotelBE.entity.User;
import com.HappyMotelBE.exception.AppException;
import com.HappyMotelBE.exception.ErrorCode;
import com.HappyMotelBE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createRequest(UserRequest request) {

        if (request.getUsername().length() < 8) {
            throw new AppException(ErrorCode.INVALID_USERNAME);
        }
        if (request.getPassword().length() < 8) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.DUPLICATE_USERNAME);
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.DUPLICATE_EMAIL);
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRealName(request.getRealName());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng") );
    }

    public User updateUser(UserRequest request) {
        if (request.getUsername().length() < 8) {
            throw new AppException(ErrorCode.INVALID_USERNAME);
        }
        if (request.getPassword().length() < 8) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        User user = getUser(request.getId());

        if (!request.getUsername().equals(user.getUsername()) && userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.DUPLICATE_USERNAME);
        }

        if (!request.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.DUPLICATE_EMAIL);
        }

        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRealName(request.getRealName());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setUpdateTime(new Date());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }
//
//    public void deleteUser(String id) {
//        userRepository.deleteById(id);
//    }
}
