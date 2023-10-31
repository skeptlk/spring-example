package com.example.libraryapi;


import com.example.libraryapi.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Author not found")
    public static class ResourceNotFoundException extends RuntimeException { }

    @GetMapping(path="", produces = "application/json")
    public Iterable<Author> listAuthors() {
        return authorRepository.findAll();
    }

}
