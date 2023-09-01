package com.lulu.libros_service.service.impl;

import com.lulu.libros_service.entity.Category;
import com.lulu.libros_service.repository.CategoryRepository;
import com.lulu.libros_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() throws Exception {
        return repository.findAll();
    }
}
