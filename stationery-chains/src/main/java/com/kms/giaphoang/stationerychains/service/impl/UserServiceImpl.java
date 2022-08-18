package com.kms.giaphoang.stationerychains.service.impl;

import com.kms.giaphoang.stationerychains.exception.UserExistedException;
import com.kms.giaphoang.stationerychains.model.dto.UserDto;
import com.kms.giaphoang.stationerychains.model.entity.User;
import com.kms.giaphoang.stationerychains.repository.UserRepository;
import com.kms.giaphoang.stationerychains.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }

    @Override
    public String saveCustomer(UserDto customerDto) {
        final Optional<User> optionalUser = userRepository.findById(customerDto.getId());
        if(optionalUser.isPresent()){
            throw new UserExistedException("Customer " + customerDto.getUsername() +  " already existed.");
        }
        User user = User.builder()
                .id(customerDto.getId())
                .username(customerDto.getUsername())
                .email(customerDto.getEmail())
                .phone(customerDto.getPhone())
                .address(customerDto.getAddress())
                .role(customerDto.getRole().name())
                .build();
        return userRepository.save(user).getId();
    }
}