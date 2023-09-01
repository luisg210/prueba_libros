package com.lulu.libros_service.service.impl;

import com.lulu.libros_service.entity.Author;
import com.lulu.libros_service.repository.AuthorRepository;
import com.lulu.libros_service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() throws Exception {
        return repository.findAll();
    }
}
