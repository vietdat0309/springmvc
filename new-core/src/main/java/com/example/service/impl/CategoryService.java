package com.example.service.impl;

import com.example.entity.CategoryEntity;
import com.example.repository.CategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Map<String, String> getCategories() {
        Map<String, String> results = new HashMap<>();
        categoryRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }
}
