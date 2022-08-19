package com.kms.giaphoang.stationerychains.service.impl;

import com.kms.giaphoang.stationerychains.exception.ProductNotFoundException;
import com.kms.giaphoang.stationerychains.exception.UserNotFoundException;
import com.kms.giaphoang.stationerychains.model.dto.OrderDto;
import com.kms.giaphoang.stationerychains.model.entity.*;
import com.kms.giaphoang.stationerychains.repository.OrderDetailRepository;
import com.kms.giaphoang.stationerychains.repository.OrderRepository;
import com.kms.giaphoang.stationerychains.repository.ProductRepository;
import com.kms.giaphoang.stationerychains.repository.UserRepository;
import com.kms.giaphoang.stationerychains.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderByUserId(String userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    @Override
    public Integer saveOrder(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + orderDto.getUserId() + " not found"));
        AtomicReference<Double> totalPrice = new AtomicReference<>(0.0);
        orderDto.getOrderDetailDtos().forEach(orderDetailDto -> {
            totalPrice.updateAndGet(v -> v + orderDetailDto.getPrice() * orderDetailDto.getQuantity());
        });
        Order order = Order.builder()
                .totalPrice(totalPrice.get())
                .shippingPrice(orderDto.getShippingPrice())
                .status(orderDto.getStatus())
                .user(user)
                .build();
        final Integer id = orderRepository.save(order).getId();
        orderDto.getOrderDetailDtos().forEach(orderDetailDto -> {
            Product product = productRepository.findById(orderDetailDto.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Product with id " + orderDetailDto.getProductId() + " not found"));
            OrderDetail orderDetail = OrderDetail.builder()
                    .id(new OrderDetailKey(product.getId(), id))
                    .order(order)
                    .product(product)
                    .quantity(orderDetailDto.getQuantity())
                    .price(orderDetailDto.getPrice())
                    .build();
            orderDetailRepository.save(orderDetail);
        });
        return id;
    }
}
