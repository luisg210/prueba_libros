package com.lulu.libros_service.repository;

import com.lulu.libros_service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByEstado(char estado);

}
