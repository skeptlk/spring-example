package com.example.libraryapi;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class LibraryTestConfiguration {

    @Bean
    public LibraryRepository libraryRepository() {
        return Mockito.mock(LibraryRepository.class);
    }
}
