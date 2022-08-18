package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.model.dto.ProductDto;
import com.kms.giaphoang.stationerychains.model.entity.Product;
import com.kms.giaphoang.stationerychains.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends AbstractApplicationController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products.stream()
                .map(product -> mapper.toProductDto(product))
                .collect(Collectors.toList())
        );
    }
    @PostMapping
    public ResponseEntity<Integer> saveProduct(@RequestBody ProductDto productDto){
        final Integer id = productService.saveProduct(productDto);
        return ResponseEntity.ok(id);
    }
}
