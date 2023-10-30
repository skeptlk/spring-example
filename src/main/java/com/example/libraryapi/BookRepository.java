package com.example.libraryapi;

import com.example.libraryapi.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(int id);

}