package com.kms.giaphoang.stationerychains.util;

import com.kms.giaphoang.stationerychains.model.dto.*;
import com.kms.giaphoang.stationerychains.model.entity.*;
import com.kms.giaphoang.stationerychains.model.enums.Role;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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

    public CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .createdDate(category.getCreatedAt())
                .updatedDate(category.getUpdatedAt())
                .products(category.getProducts())
                .build();
    }

    public UserDto toCustomerDto(User customer) {
        return UserDto.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .createdDate(customer.getCreatedAt())
                .updatedDate(customer.getUpdatedAt())
                .role(Role.valueOf(customer.getRole()))
                .build();
    }

    public OrderDto toOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .shippingPrice(order.getShippingPrice())
                .createdAt(order.getCreatedAt())
                .updateAt(order.getUpdatedAt())
                .userId(order.getUser().getId())
                .status(order.getStatus())
                .orderDetailDtos(order.getOrderDetails().stream()
                        .map(orderDetail -> toOrderDetailDto(orderDetail))
                        .collect(Collectors.toList()))
                .build();
    }

    public OrderDetailDto toOrderDetailDto(OrderDetail orderDetail) {
        return OrderDetailDto.builder()
                .orderId(orderDetail.getId().getOrderId())
                .productId(orderDetail.getId().getProductId())
                .quantity(orderDetail.getQuantity())
                .price(orderDetail.getPrice())
                .build();
    }
}
