package com.lulu.libros_service.service;

import com.lulu.libros_service.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll() throws Exception;

}
