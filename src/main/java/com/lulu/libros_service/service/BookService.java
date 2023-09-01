package com.lulu.libros_service.service;

import com.lulu.libros_service.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll() throws Exception;
    Optional<Book> findById(Long id) throws Exception;
    Book save(Book book) throws Exception;
    void delete(Long id) throws Exception;

}
