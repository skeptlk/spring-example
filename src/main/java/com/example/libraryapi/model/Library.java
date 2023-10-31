package com.example.libraryapi.model;


import jakarta.persistence.*;

@Entity
public final class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    public int id;
    public String name;
    public String description;

}
