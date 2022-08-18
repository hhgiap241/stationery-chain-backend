package com.kms.giaphoang.stationerychains.service.impl;

import com.kms.giaphoang.stationerychains.exception.CategoryNotFoundException;
import com.kms.giaphoang.stationerychains.exception.ProductNotFoundException;
import com.kms.giaphoang.stationerychains.model.dto.ProductDto;
import com.kms.giaphoang.stationerychains.model.entity.Category;
import com.kms.giaphoang.stationerychains.model.entity.Product;
import com.kms.giaphoang.stationerychains.repository.CategoryRepository;
import com.kms.giaphoang.stationerychains.repository.ProductRepository;
import com.kms.giaphoang.stationerychains.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id =  " + id + " not found."));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Integer saveProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + productDto.getCategoryId() + " not found"));
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .producer(productDto.getProducer())
                .image(productDto.getImage())
                .status(productDto.getStatus())
                .category(category)
                .build();
        return productRepository.save(product).getId();
    }

    @Override
    public Integer updateProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + productDto.getCategoryId() + " not found"));
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product with id = " + productDto.getId() + " not found."));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setProducer(productDto.getProducer());
        product.setImage(productDto.getImage());
        product.setStatus(productDto.getStatus());
        product.setCategory(category);
        return productRepository.save(product).getId();
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id = " + id + " not found."));
        productRepository.deleteById(id);
    }
}
