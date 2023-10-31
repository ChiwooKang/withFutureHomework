package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookmanageRepository;
import com.example.demo.service.BookmanageService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private BookmanageRepository bookmanageRepository;
    
    @Autowired
    private ObjectMapper objectMapper;

	 
    @MockBean
    private BookmanageService bookmanageService;

//    @Test
//    public void accessPermittedTest() throws Exception {
//        mockMvc.perform(get("/login"))
//               .andExpect(status().isOk());
//
//        mockMvc.perform(get("/books"))
//               .andExpect(status().isOk());
//    }
//
//    @Test
//    @WithMockUser(username = "user", roles = {"USER"})
//    public void accessUserPageWithUserRole() throws Exception {
//        mockMvc.perform(get("/user"))
//               .andExpect(status().isOk());
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"ADMIN"})
//    public void accessAdminPageWithAdminRole() throws Exception {
//        mockMvc.perform(get("/admin"))
//               .andExpect(status().isOk());
//    }
//
//    @Test
//    @WithMockUser(username = "user", roles = {"USER"})
//    public void accessAdminPageWithUserRoleShouldFail() throws Exception {
//    	mockMvc.perform(get("/admin").with(user("username").roles("ADMIN")))
//               .andExpect(status().isForbidden());
//    }
//    
    @Test
    @WithMockUser(roles = "ADMIN")
    public void testInsertBookWithAdminRole() throws Exception {
        Book book = new Book();
        book.setBookNo(1);
        book.setBookTitle("Test Book");
        book.setBookWriter("Test Writer");

       
        when(bookmanageService.insertBook(any())).thenReturn(book);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(book)))
               .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testInsertBookWithInvalidData() throws Exception {
        Book book = new Book();
        book.setBookNo(0);  
        book.setBookTitle(""); 
        book.setBookWriter("12345"); 

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(book)))
               .andExpect(status().isUnprocessableEntity());  
    }

}


