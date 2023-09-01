package com.lulu.libros_service.service.impl;

import com.lulu.libros_service.entity.Book;
import com.lulu.libros_service.repository.BookRepository;
import com.lulu.libros_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() throws Exception {
        return repository.findByEstado('d');
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> findById(Long id) throws Exception {
        return Optional.of(repository.findById(id)).orElse(null);
    }

    @Override
    @Transactional
    public Book save(Book book) throws Exception {
        return repository.save(book);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        repository.deleteById(id);
    }
}