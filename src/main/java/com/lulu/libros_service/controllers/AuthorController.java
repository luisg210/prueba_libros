package com.lulu.libros_service.controllers;

import com.lulu.libros_service.entity.Author;
import com.lulu.libros_service.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "AuthorController", description = "Controlador de autores")
@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = "*")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @Operation(description = "Retorna lista de autores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<List<Author>>(service.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}