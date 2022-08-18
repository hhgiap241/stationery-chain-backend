package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.model.dto.CategoryDto;
import com.kms.giaphoang.stationerychains.model.entity.Category;
import com.kms.giaphoang.stationerychains.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController extends AbstractApplicationController{
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        final List<Category> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories.stream().map(category -> mapper.toCategoryDto(category)).collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<Integer> saveCategory(@RequestBody CategoryDto categoryDto){
        final Integer id = categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(id);
    }
}
