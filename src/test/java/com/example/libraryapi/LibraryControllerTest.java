package com.example.libraryapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(LibraryController.class)
@Import(LibraryTestConfiguration.class)
public class LibraryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getLibrary() throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get("/libraries")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}