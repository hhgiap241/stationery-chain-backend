package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/12/2022, Friday
 * @project: stationery
 **/
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private List<Customer> customerList = List.of(
            new Customer("1", "Nguyen Van A"),
            new Customer("2", "Nguyen Van B"),
            new Customer("3", "Nguyen Van C")
    );
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(customerList);
    }
}
