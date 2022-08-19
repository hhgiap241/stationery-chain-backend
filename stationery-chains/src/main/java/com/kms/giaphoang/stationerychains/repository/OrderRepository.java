package com.kms.giaphoang.stationerychains.repository;

import com.kms.giaphoang.stationerychains.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrderByUserId(String userId);
}
