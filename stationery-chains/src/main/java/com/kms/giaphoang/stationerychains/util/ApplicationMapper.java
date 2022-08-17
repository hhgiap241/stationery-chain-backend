package com.kms.giaphoang.stationerychains.util;

import com.kms.giaphoang.stationerychains.model.dto.ProductDto;
import com.kms.giaphoang.stationerychains.model.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/
@Component
public class ApplicationMapper {
    public ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .producer(product.getProducer())
                .image(product.getImage())
                .status(product.getStatus())
                .createdDate(product.getCreatedDate())
                .updatedDate(product.getUpdatedDate())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .build();
    }
}
