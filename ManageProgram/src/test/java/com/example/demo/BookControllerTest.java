package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookmanageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private BookmanageRepository bookmanageRepository;


    @Test
    public void testInsertValidBook() throws Exception { // 삽입
        
        Book newBook = new Book();
        newBook.setBookNo(1);
        newBook.setBookTitle("book1");
        newBook.setBookWriter("writer1");

   
        String bookJson = objectMapper.writeValueAsString(newBook);

       
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));
    }
    
    @Test
    public void testInsertInvalidBookNumber() throws Exception { 

        Book newBook = new Book();
        newBook.setBookNo(1);
        newBook.setBookTitle("book1");
        newBook.setBookWriter("writer1");

        String validBookJson = objectMapper.writeValueAsString(newBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));

        // 유효하지 않은 책 번호로 삽입 시도
        Book invalidBook = new Book();
        invalidBook.setBookNo(0);  // 유효하지 않은 책 번호
        invalidBook.setBookTitle("invalidBook");
        invalidBook.setBookWriter("invalidWriter");

        String invalidBookJson = objectMapper.writeValueAsString(invalidBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().isBadRequest()); 
    }

    
    @Test
    public void testSearchAllBooks() throws Exception { // 전체찾기
        Book newBook = new Book();
        newBook.setBookNo(1);
        newBook.setBookTitle("book1");
        newBook.setBookWriter("writer1");

        String bookJson = objectMapper.writeValueAsString(newBook);

        
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));

       
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].bookNo").value(1))
                .andExpect(jsonPath("$[0].bookTitle").value("book1"))
                .andExpect(jsonPath("$[0].bookWriter").value("writer1"));
    }

    
    @Test
    public void testSearchAllBooksFail() throws Exception { // 전체 찾기 실패

        Book newBook = new Book();
        newBook.setBookNo(1);
        newBook.setBookTitle("book1");
        newBook.setBookWriter("writer1");

        String bookJson = objectMapper.writeValueAsString(newBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));

        // 모든 책 검색
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].bookNo").value(1))
                .andExpect(jsonPath("$[0].bookTitle").value("book1"))
                .andExpect(jsonPath("$[0].bookWriter").value("writer1"));
    }

    
    @Test
    public void testSearchBookByNumber() throws Exception { // 번호로 찾기
        // 책 데이터 생성 및 JSON 변환
        Book newBook = new Book();
        newBook.setBookNo(1);
        newBook.setBookTitle("book1");
        newBook.setBookWriter("writer1");
        String bookJson = objectMapper.writeValueAsString(newBook);

        // 먼저 책을 데이터베이스에 삽입
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));

        // 삽입된 책의 번호로 검색
        int bookNoToSearch = 1;
        mockMvc.perform(get("/books/" + bookNoToSearch))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));
    }

    @Test
    public void testSearchBookNumberFail() throws Exception { 
        
        Book validBook = new Book();
        validBook.setBookNo(1);
        validBook.setBookTitle("book1");
        validBook.setBookWriter("writer1");

        String validBookJson = objectMapper.writeValueAsString(validBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBookJson))
                .andExpect(status().isOk());

        // 이어서 유효하지 않은 책 정보를 추가를 시도합니다.
        Book invalidBook = new Book();
        invalidBook.setBookNo(0); // 유효하지 않은 bookNo
        invalidBook.setBookTitle("invalidBook");
        invalidBook.setBookWriter("invalidWriter");

        String invalidBookJson = objectMapper.writeValueAsString(invalidBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBookJson))
                .andExpect(status().isBadRequest());
    }

    
    @Test
    public void testUpdateBook() throws Exception { // 업데이트
        // 초기 책 데이터 생성 및 JSON 변환
        Book initialBook = new Book();
        initialBook.setBookNo(1);
        initialBook.setBookTitle("book1");
        initialBook.setBookWriter("writer1");
        String initialBookJson = objectMapper.writeValueAsString(initialBook);


        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(initialBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));


        Book updatedBook = new Book();
        updatedBook.setBookNo(1);
        updatedBook.setBookTitle("updatedTitle");
        updatedBook.setBookWriter("updatedWriter");
        String updatedBookJson = objectMapper.writeValueAsString(updatedBook);


        mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("updatedTitle"))
                .andExpect(jsonPath("$.bookWriter").value("updatedWriter"));
    }

    
    @Test
    public void testUpdateNonexistentBook() throws Exception { // 업데이트 실패
        Book nonExistentBook = new Book();
        nonExistentBook.setBookNo(999);  // 존재하지 않는 bookNo
        nonExistentBook.setBookTitle("Non-existent Book");
        nonExistentBook.setBookWriter("Unknown Writer");

        String bookJson = objectMapper.writeValueAsString(nonExistentBook);

        mockMvc.perform(put("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isNotFound());
    }
    
    @Test
    public void testDeleteBook() throws Exception { // 삭제

        Book validBook = new Book();
        validBook.setBookNo(1);
        validBook.setBookTitle("book1");
        validBook.setBookWriter("writer1");

        String validBookJson = objectMapper.writeValueAsString(validBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookNo").value(1))
                .andExpect(jsonPath("$.bookTitle").value("book1"))
                .andExpect(jsonPath("$.bookWriter").value("writer1"));


        int bookNoToDelete = 1;
        mockMvc.perform(delete("/books/" + bookNoToDelete))
                .andExpect(status().isOk());

 
        mockMvc.perform(get("/books/" + bookNoToDelete))
                .andExpect(status().isNotFound());
    }


    
    
    @Test
    public void testDeleteNonexistentBook() throws Exception { // 삭제 실패
        int nonExistentBookNo = 999;  // 존재하지 않는 bookNo

        mockMvc.perform(delete("/books/" + nonExistentBookNo))
                .andExpect(status().isNotFound());
    }


//    @Test
//    public void testSearchBookByNumber() throws Exception {
//        int bookNoToSearch = 1;
//        mockMvc.perform(get("/books/" + bookNoToSearch))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.bookNo").value(1))
//                .andExpect(jsonPath("$.bookTitle").value("book1"))
//                .andExpect(jsonPath("$.bookWriter").value("writer1"));
//    }
//    
//    @Test
//    public void testUpdateBook() throws Exception {
//        Book updatedBook = new Book();
//        updatedBook.setBookNo(1);
//        updatedBook.setBookTitle("updatedTitle");
//        updatedBook.setBookWriter("updatedWriter");
//
//        String bookJson = objectMapper.writeValueAsString(updatedBook);
//
//        mockMvc.perform(put("/books")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(bookJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.bookNo").value(1))
//                .andExpect(jsonPath("$.bookTitle").value("updatedTitle"))
//                .andExpect(jsonPath("$.bookWriter").value("updatedWriter"));
//    }
//    
//    @Test
//    public void testDeleteBook() throws Exception {
//        int bookNoToDelete = 1;
//        mockMvc.perform(delete("/books/" + bookNoToDelete))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.bookNo").value(1))
//                .andExpect(jsonPath("$.bookTitle").isNotEmpty())
//                .andExpect(jsonPath("$.bookWriter").isNotEmpty());
//    }
//
//
// 


}
