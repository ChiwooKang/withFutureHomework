package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.BookmanageService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/web/books")
public class WebController {
	
	private final BookmanageService bookmanageService;
    private final UserService userService;
    
    public WebController(BookmanageService bookmanageService, UserService userService) {
        this.bookmanageService = bookmanageService;
        this.userService = userService;
    }
    

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<?> processLogin(@RequestParam String username, @RequestParam String password) {
//        User user = userService.authenticate(username, password); 
//        System.out.println(user);
//
//        if (user != null) {
//         
//            return ResponseEntity.ok().body("로그인 성공 메시지");
//        } else {
//        
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패 메시지");
//        }
//    }

    
//    @PostMapping("/login")
//    public ResponseEntity<?> processLogin(@RequestBody Map<String, String> credentials) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//        
//        User user = userService.authenticate(username, password); 
//        System.out.println(user);
//
//        if (user != null) {
//           
//            return ResponseEntity.ok().body("로그인성봉");
//        } else {
//            
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("부정확,미인가");
//        }
//    }

    
    @GetMapping
    public List<Book> searchAll() {
        return bookmanageService.searchAll();
    }

    
    @PostMapping("/createUser")
    @ResponseBody
    public User createUser(@RequestBody Map<String, String> userDetails) {
        String username = userDetails.get("username");
        String password = userDetails.get("password");
        String role = userDetails.get("role");

        return userService.create(username, password, role);
    }
    
    @GetMapping("/allBooks")
    public String allBooksView(Model model) {
        List<Book> books = bookmanageService.searchAll();
        model.addAttribute("books", books);
        return "allBooks";
    }
    
    
    @GetMapping("/searchNumber")
    public String searchNumberPage(@RequestParam int bookNo, Model model) {
        Book book = bookmanageService.searchNumber(bookNo);
        model.addAttribute("book", book);
        return "searchNumber";
    }
    
    @PutMapping("/updateBook/{bookNo}")
    public Book updateBook(@PathVariable int bookNo, @RequestBody Book book) {
        Book updatedBook = bookmanageService.updateBook(bookNo, book);
        return  bookmanageService.updateBook(book.getBookNo(), book);
    }
    
    @DeleteMapping("/{bookNo}")
    public Book deleteBook(@PathVariable int bookNo) {
        bookmanageService.deleteBook(bookNo);
        return bookmanageService.deleteBook(bookNo);
    }

}

