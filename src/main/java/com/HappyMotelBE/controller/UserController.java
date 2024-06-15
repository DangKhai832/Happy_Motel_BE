package com.HappyMotelBE.controller;

import com.HappyMotelBE.dto.request.UserRequest;
import com.HappyMotelBE.dto.response.ApiResponse;
import com.HappyMotelBE.entity.User;
import com.HappyMotelBE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    ApiResponse<User> createUser(@RequestBody @Valid UserRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/updateUser")
    User updateUser(@RequestBody UserRequest request) {
        return userService.updateUser(request);
    }

    @GetMapping("/delete/{userId}")
    ApiResponse deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Đã xóa người dùng thành công");
        return apiResponse;
    }
}
