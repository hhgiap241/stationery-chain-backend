package com.kms.giaphoang.stationerychains.model.dto;

import com.kms.giaphoang.stationerychains.model.entity.Category;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/
@Data
@Builder
public class ProductDto {
    private Integer id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Price is required")
    private Double price;
    @NotBlank(message = "Quantity is required")
    private Integer quantity;
    @NotBlank(message = "Producer's name is required")
    private String producer;
    @NotBlank(message = "Image is required")
    private String image;
    @NotBlank(message = "Status is required")
    private Boolean status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Integer categoryId;
    private String categoryName;
}
