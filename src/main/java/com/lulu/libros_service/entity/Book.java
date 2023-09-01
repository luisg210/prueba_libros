package com.lulu.libros_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libro")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Category category;
    private double precio;
    private char estado;

}
