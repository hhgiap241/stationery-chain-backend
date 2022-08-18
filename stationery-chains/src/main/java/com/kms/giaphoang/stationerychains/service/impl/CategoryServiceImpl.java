package com.kms.giaphoang.stationerychains.service.impl;

import com.kms.giaphoang.stationerychains.exception.CategoryExistedException;
import com.kms.giaphoang.stationerychains.model.dto.CategoryDto;
import com.kms.giaphoang.stationerychains.model.entity.Category;
import com.kms.giaphoang.stationerychains.repository.CategoryRepository;
import com.kms.giaphoang.stationerychains.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Integer saveCategory(CategoryDto categoryDto) {
        final Optional<Category> categoryOptional = categoryRepository.findCategoryByName(categoryDto.getName());
        if (categoryOptional.isPresent()) {
            throw new CategoryExistedException("Category " + categoryDto.getName() + " is already existed.");
        }
        Category category = Category.builder().name(categoryDto.getName()).build();
        final Integer id = categoryRepository.save(category).getId();
        return id;
    }
}
