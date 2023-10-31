package com.example.libraryapi;


import com.example.libraryapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(path="/{id}", produces = "application/json")
    public Optional<Book> getBook(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @GetMapping(path="/", produces = "application/json")
    public Iterable<Book> listBooks() {
        return bookRepository.findAll();
    }

    @PostMapping(path="/", produces = "application/json")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public Optional<Book> deleteBook(@PathVariable Long id) {
        var book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        }
        return book;
    }

}
