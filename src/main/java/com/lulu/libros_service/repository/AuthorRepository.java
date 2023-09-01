package com.lulu.libros_service.repository;

import com.lulu.libros_service.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
