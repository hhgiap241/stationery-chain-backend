package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.model.dto.OrderDto;
import com.kms.giaphoang.stationerychains.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController extends AbstractApplicationController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrder() {
        return ResponseEntity.ok(orderService.getAllOrder().stream()
                .map(order -> mapper.toOrderDto(order))
                .collect(Collectors.toList()));
    }
}
