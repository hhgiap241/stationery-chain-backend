package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.model.dto.UserDto;
import com.kms.giaphoang.stationerychains.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/12/2022, Friday
 * @project: stationery
 **/
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends AbstractApplicationController{
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllCustomer() {
        return ResponseEntity.ok(userService.getAllCustomer().stream()
                .map(user -> mapper.toCustomerDto(user))
                .collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveCustomer(userDto));
    }
}
