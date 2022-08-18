package com.kms.giaphoang.stationerychains.model.dto;

import com.kms.giaphoang.stationerychains.model.enums.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@Builder
@Data
public class UserDto {
    @NotBlank(message = "Id is required")
    private String id;
    @NotBlank(message = "Name is required")
    private String username;
    private String email;
    private String address;
    private String phone;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Role role;
}
