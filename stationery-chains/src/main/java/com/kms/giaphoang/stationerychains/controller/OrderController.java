package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.model.dto.OrderDto;
import com.kms.giaphoang.stationerychains.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDto>> getOrderByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.getOrderByUserId(userId).stream()
                .map(order -> mapper.toOrderDto(order))
                .collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<Integer> saveOrder(@Valid @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.saveOrder(orderDto));
    }
}
