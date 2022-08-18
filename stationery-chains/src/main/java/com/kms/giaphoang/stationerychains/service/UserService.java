package com.kms.giaphoang.stationerychains.service;

import com.kms.giaphoang.stationerychains.model.dto.UserDto;
import com.kms.giaphoang.stationerychains.model.entity.User;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
public interface UserService {
    List<User> getAllCustomer();
    String saveCustomer(UserDto customerDto);
}
