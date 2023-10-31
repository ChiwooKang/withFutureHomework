package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookmanageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class Successtest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private BookmanageRepository bookmanageRepository;

    @Autowired
    private MessageSource messageSource; 

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Test
    public void testInsertValidBook() throws Exception { 
        Book newBook = createNewBook();

        String bookJson = objectMapper.writeValueAsString(newBook);
        performPostRequest(bookJson)
            .andExpect(jsonPath("$.bookNo").value(1))
            .andExpect(jsonPath("$.bookTitle").value(getMessage("title")))
            .andExpect(jsonPath("$.bookWriter").value(getMessage("writer")));
    }

    @Test
    public void testSearchAllBooks() throws Exception {
        Book newBook = createNewBook();
        
        String bookJson = objectMapper.writeValueAsString(newBook);
        performPostRequest(bookJson);

        mockMvc.perform(get("/books"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].bookNo").value(1))
            .andExpect(jsonPath("$[0].bookTitle").value(getMessage("title")))
            .andExpect(jsonPath("$[0].bookWriter").value(getMessage("writer")));
    }

    @Test
    public void testSearchBookByNumber() throws Exception {
        Book newBook = createNewBook();
        
        String bookJson = objectMapper.writeValueAsString(newBook);
        performPostRequest(bookJson);

        int bookNoToSearch = 1;
        mockMvc.perform(get("/books/" + bookNoToSearch))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.bookNo").value(1))
            .andExpect(jsonPath("$.bookTitle").value(getMessage("title")))
            .andExpect(jsonPath("$.bookWriter").value(getMessage("writer")));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book initialBook = createNewBook();
        
        String initialBookJson = objectMapper.writeValueAsString(initialBook);
        performPostRequest(initialBookJson);

        Book updatedBook = new Book();
        updatedBook.setBookNo(1);
        updatedBook.setBookTitle(getMessage("title"));
        updatedBook.setBookWriter(getMessage("writer"));
        
        String updatedBookJson = objectMapper.writeValueAsString(updatedBook);
        mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value(getMessage("title")))
                .andExpect(jsonPath("$.bookWriter").value(getMessage("writer")));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book validBook = createNewBook();
        
        String validBookJson = objectMapper.writeValueAsString(validBook);
        performPostRequest(validBookJson);

        int bookNoToDelete = 1;
        mockMvc.perform(delete("/books/" + bookNoToDelete))
            .andExpect(status().isOk());

        mockMvc.perform(get("/books/" + bookNoToDelete))
            .andExpect(status().isNotFound());
    }

    private Book createNewBook() {
        Book newBook = new Book();
        newBook.setBookNo(1);
        newBook.setBookTitle(getMessage("title"));
        newBook.setBookWriter(getMessage("writer"));
        return newBook;
    }

    private ResultActions performPostRequest(String bookJson) throws Exception {
        return mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(bookJson))
            .andExpect(status().isOk());
    }
}
