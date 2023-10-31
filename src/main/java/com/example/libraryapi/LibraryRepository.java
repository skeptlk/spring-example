package com.example.libraryapi;

import com.example.libraryapi.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LibraryRepository extends CrudRepository<Library, Long>, PagingAndSortingRepository<Library, Long> {
}