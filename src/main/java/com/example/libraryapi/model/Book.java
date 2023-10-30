package com.example.libraryapi.model;

import jakarta.persistence.*;

@Entity
public final class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    public int id;
    public String title;
    public String description;
    public int authorId;
    public int libraryId;
    public boolean isAssigned;

}
