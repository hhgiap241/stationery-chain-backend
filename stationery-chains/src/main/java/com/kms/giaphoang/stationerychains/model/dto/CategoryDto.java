package com.kms.giaphoang.stationerychains.model.dto;

import com.kms.giaphoang.stationerychains.model.entity.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@Data
@Builder
public class CategoryDto {
    private Integer id;
    @NotBlank(message = "Name is required")
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Set<Product> products;
}
