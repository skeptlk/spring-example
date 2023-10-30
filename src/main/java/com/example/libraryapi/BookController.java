package com.example.libraryapi;


import com.example.libraryapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(path="/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
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


}
