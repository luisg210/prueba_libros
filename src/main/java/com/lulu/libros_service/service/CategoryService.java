package com.lulu.libros_service.service;

import com.lulu.libros_service.entity.Category;

import java.util.List;

public interface CategoryService {

     List<Category> findAll() throws Exception;

}
