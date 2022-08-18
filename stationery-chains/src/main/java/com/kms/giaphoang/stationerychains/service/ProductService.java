package com.kms.giaphoang.stationerychains.service;

import com.kms.giaphoang.stationerychains.model.dto.ProductDto;
import com.kms.giaphoang.stationerychains.model.entity.Product;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/
public interface ProductService {
    List<Product> getAllProducts();
    Product findProductById(Integer id);
    Integer saveProduct(ProductDto productDto);
    Integer updateProduct(ProductDto productDto);

    void deleteProduct(Integer id);
}
