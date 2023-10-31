package com.example.libraryapi.model;


import jakarta.persistence.*;

@Entity
public final class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    public int id;
    public String firstName;
    public String middleName;
    public String lastName;
    public int birthYear;

}
