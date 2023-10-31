package com.example.libraryapi;

import com.example.libraryapi.model.Library;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("libraries")
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Library not found")
    public static class ResourceNotFoundException extends RuntimeException { }

    @GetMapping(path = "", produces = "application/json")
    public Page<Library> listLibraries(@ParameterObject Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Library getLibrary(@PathVariable Long id) {
        return libraryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Library updateLibrary(@RequestBody Library library) {
        return libraryRepository.save(library);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public Library deleteLibrary(@PathVariable Long id) {
        var library = libraryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        libraryRepository.deleteById(id);
        return library;
    }
}
