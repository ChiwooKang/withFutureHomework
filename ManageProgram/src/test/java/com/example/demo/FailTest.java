package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.constants.StatusCode;
import com.example.demo.entity.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.service.BookmanageService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class FailTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookmanageService bookmanageService;

    @BeforeEach
    void setUp() {
        Book mockBook = new Book(1, "책이름", "작가이름");

       
       // given(bookmanageService.searchNumber(1)).willReturn(mockBook);
    }
    
    @Autowired
    private MessageSource messageSource; 

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }



    @Test
    public void invaildInsert() throws Exception {
        
        String invalidBookJson = "{\"bookNo\": -1, \"bookTitle\": \"\", \"bookWriter\": \"123!\"}";

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY )) // StatusCode에 맞게 수정
                .andExpect(jsonPath("$.errors.bookNo", is(getMessage("book.number.min"))))
                .andExpect(jsonPath("$.errors.bookTitle", is(getMessage("book.title.size"))))
                .andExpect(jsonPath("$.errors.bookWriter", is(getMessage("book.writer.pattern"))));
        		
    }

//    @Test
//    public void bookNotFound() throws Exception {
//        int bookNo = 12345;
//        given(bookmanageService.searchNumber(bookNo)).willThrow(new BookNotFoundException("해당 번호의 책을 찾을 수 없습니다: " + bookNo));
//
//        mockMvc.perform(get("/books/" + bookNo))
//                .andExpect(status().isNotFound());
//    }
    
//    @Test
//    public void bookNotFound() throws Exception {
//        int bookNo = 12345;
//       // given(bookmanageService.searchNumber(bookNo)).willThrow(new BookNotFoundException("해당 번호의 책을 찾을 수 없습니다: " + bookNo));
//
//        mockMvc.perform(get("/books/" + bookNo))
//                .andExpect(status().isNotFound())
//                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BookNotFoundException))
//        		.andExpect(jsonPath("$.message", is(getMessage("book.error.notfound"))));
//    }
    
    	

    
    @Test
    public void deleteBookBookNotFound() throws Exception {
        int nonExistBookNo = 9999; 
   //    given(bookmanageService.deleteBook(nonExistBookNo)).willThrow(new BookNotFoundException("해당 번호의 책을 찾을 수 없습니다: " + nonExistBookNo));

        mockMvc.perform(delete("/books/" + nonExistBookNo))
                .andExpect(status().is(StatusCode.NOT_FOUND))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BookNotFoundException))
                .andExpect(jsonPath("$.message", is(getMessage("book.error.notfound"))));
    }

    
    @Test
    public void insertBookInvalidBookNumber() throws Exception {
        String invalidBookJson = "{\"bookNo\": 0, \"bookTitle\": \"Valid Title\", \"bookWriter\": \"Valid Writer\"}";

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
                .andExpect(jsonPath("$.errors.bookNo",is(getMessage("book.number.min"))));
    }

    @Test
    public void insertBookEmptyBookTitl() throws Exception {
        String invalidBookJson = "{\"bookNo\": 10, \"bookTitle\": \"\", \"bookWriter\": \"Valid Writer\"}";

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
                .andExpect(jsonPath("$.errors.bookTitle", is(getMessage("book.title.size"))));
    }

    @Test
    public void insertBookTooLongBookTitle() throws Exception {
        String longTitle = new String(new char[101]).replace("\0", "a");
        String invalidBookJson = String.format("{\"bookNo\": 10, \"bookTitle\": \"%s\", \"bookWriter\": \"Valid Writer\"}", longTitle);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
        		.andExpect(jsonPath("$.errors.bookTitle", is(getMessage("book.title.size"))));
    }

    @Test
    public void insertBookEmptyBookWriter() throws Exception {
        String invalidBookJson = "{\"bookNo\": 10, \"bookTitle\": \"Valid Title\", \"bookWriter\": \"\"}";

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
                .andExpect(jsonPath("$.errors.bookWriter", is(getMessage("book.writer.notempty"))));
    }

    @Test
    public void insertBookInvalidBookWriterPattern() throws Exception {
        String invalidBookJson = "{\"bookNo\": 10, \"bookTitle\": \"Valid Title\", \"bookWriter\": \"12345\"}"; 

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
        		.andExpect(jsonPath("$.errors.bookWriter", is(getMessage("book.writer.pattern"))));
    }

    @Test
    public void insertBookLongBookWriter() throws Exception {
        String longWriter = new String(new char[51]).replace("\0", "a");
        String invalidBookJson = String.format("{\"bookNo\": 10, \"bookTitle\": \"Valid Title\", \"bookWriter\": \"%s\"}", longWriter);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
        		.andExpect(jsonPath("$.errors.bookWriter", is(getMessage("book.writer.size"))));
    }
    
   

    @Test
    public void updateBookNoexistBook() throws Exception {
        String validBookJson = "{\"bookNo\": 9, \"bookTitle\": \"Valid Title\", \"bookWriter\": \"Valid Writer\"}";

        mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBookJson))
                .andExpect(status().is(StatusCode.NOT_FOUND))
        		.andExpect(jsonPath("$.message", is(getMessage("book.error.notfound"))));
           
        		
    }

    @Test
    public void updateBookInvalidBookTitle() throws Exception {
        String invalidBookJson = "{\"bookNo\": 1, \"bookTitle\": \"\", \"bookWriter\": \"Valid Writer\"}";

        mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
        		.andExpect(jsonPath("$.errors.bookTitle", is(getMessage("book.title.size"))));
        		
    }
    
    @Test
    public void updateBookInvalidBookWriter() throws Exception {
  
        String invalidBookWriterJson = "{\"bookNo\": 1, \"bookTitle\": \"Updated Title\", \"bookWriter\": \"123!\"}";

        mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookWriterJson))
                .andExpect(status().is(StatusCode.UNPROCESSABLE_ENTITY))
        		.andExpect(jsonPath("$.errors.bookWriter", is(getMessage("book.writer.pattern"))));
    }








}
