package com.kms.giaphoang.stationerychains.service;

import com.kms.giaphoang.stationerychains.model.dto.CategoryDto;
import com.kms.giaphoang.stationerychains.model.entity.Category;

import java.util.List;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
public interface CategoryService {
    List<Category> getAllCategory();
    Integer saveCategory(CategoryDto categoryDto);
}
