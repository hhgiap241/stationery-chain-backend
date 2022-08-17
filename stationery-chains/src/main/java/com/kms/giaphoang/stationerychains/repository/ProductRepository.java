package com.kms.giaphoang.stationerychains.repository;

import com.kms.giaphoang.stationerychains.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
