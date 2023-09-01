package com.lulu.libros_service.controllers;

import com.lulu.libros_service.entity.Book;
import com.lulu.libros_service.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "BookController", description = "Controlador de libros")
@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService service;

    @Operation(description = "Retorna lista de libros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<List<Book>>(service.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Retorna libro por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "400", description = "Not Found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Book> oBook;
        try {
            oBook = service.findById(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        if (oBook.isPresent()){
            return new ResponseEntity<Book>(oBook.get(), HttpStatus.ACCEPTED);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(description = "Guarda un libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creado"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Book book){
        try {
            return new ResponseEntity<Book>(service.save(book), HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Actualiza un libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "400", description = "Not Found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Long id){
        try {
            Optional<Book> oBook = service.findById(id);

            if (oBook.isPresent()){
                book.setId(id);
                return new ResponseEntity<Book>(service.save(book), HttpStatus.CREATED);

            }else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Actualiza el estado de un libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "400", description = "Not Found")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateState(@PathVariable Long id){
        try {
            Optional<Book> oBook = service.findById(id);

            if (oBook.isPresent()){
                Book bookUpdate = oBook.get();

                bookUpdate.setEstado(bookUpdate.getEstado() == 'd' ? 'n' : 'd');
                service.save(bookUpdate);
                return ResponseEntity.noContent().build();

            }else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Elimina un libro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Exito"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "400", description = "Not Found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            Optional<Book> oBook = service.findById(id);

            if (oBook.isPresent()){
                service.delete(id);

                return ResponseEntity.noContent().build();

            }else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
