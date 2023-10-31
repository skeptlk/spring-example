package com.example.libraryapi;


import com.example.libraryapi.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
    public static class ResourceNotFoundException extends RuntimeException { }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Book is already assigned")
    public static class BookAssignedException extends RuntimeException { }

    @GetMapping(path="", produces = "application/json")
    public Iterable<Book> listBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping(path="", produces = "application/json")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping(path="/{id}", produces = "application/json")
    public Book updateBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @Operation(summary = "Mark book as assigned if not assigned, throw an error otherwise")
    @PutMapping(path="/{id}/assign", produces = "application/json")
    public Book assignBook(@PathVariable Long id) {
        var book = bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (book.isAssigned) {
            throw new BookAssignedException();
        } else {
            book.isAssigned = true;
            return bookRepository.save(book);
        }
    }

    @Operation(summary = "Mark book as not assigned")
    @PutMapping(path="/{id}/unassign", produces = "application/json")
    public Book unAssignBook(@PathVariable Long id) {
        var book = bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        book.isAssigned = false;
        return bookRepository.save(book);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public Book deleteBook(@PathVariable Long id) {
        var book = bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        bookRepository.deleteById(id);
        return book;
    }

}
