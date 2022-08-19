package com.kms.giaphoang.stationerychains.service;

import com.kms.giaphoang.stationerychains.model.dto.OrderDto;
import com.kms.giaphoang.stationerychains.model.entity.Order;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
public interface OrderService {
    List<Order> getAllOrder();
    List<Order> getOrderByUserId(String userId);
    Integer saveOrder(OrderDto orderDto);
}
