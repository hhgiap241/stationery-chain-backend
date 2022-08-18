package com.kms.giaphoang.stationerychains.service.impl;

import com.kms.giaphoang.stationerychains.model.entity.Order;
import com.kms.giaphoang.stationerychains.repository.OrderRepository;
import com.kms.giaphoang.stationerychains.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
