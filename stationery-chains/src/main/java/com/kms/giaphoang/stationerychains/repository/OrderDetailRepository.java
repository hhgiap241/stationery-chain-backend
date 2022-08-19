package com.kms.giaphoang.stationerychains.repository;

import com.kms.giaphoang.stationerychains.model.entity.OrderDetail;
import com.kms.giaphoang.stationerychains.model.entity.OrderDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/19/2022, Friday
 * @project: stationery
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailKey> {
    List<OrderDetail> findByIdProductIdAndOrderId(Integer productId, Integer orderId);
}
