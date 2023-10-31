package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.service.BookmanageService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/books")
public class BookViewController {

   private final UserService userService;
   private BookmanageService bookmanageService;

   public BookViewController(UserService userService, BookmanageService bookmanageService) {
       this.userService = userService;
       this.bookmanageService = bookmanageService;
   }

   @GetMapping("/login")
   public String loginPage() {
       return "login";
   }

   @GetMapping("/allBooks")
   public String allBooksPage() {
       return "allBooks";
   }

//   @GetMapping("/searchNumber")
//   public String searchNumberPage() {
//       return "searchNumber";
//   }
   

   @GetMapping("/insertBook")
   public String insertBookPage() {
       return "insertBooks";
   }
   
//   @GetMapping("/updateBook")
//   public String updateBookPage(@RequestParam("bookNo") int bookNo, Model model) {
//       Book book = bookmanageService.searchNumber(bookNo);
//       model.addAttribute("book", book);
//       return "updateBook";
//   }
//   
   
   @GetMapping("/detail/{bookNo}") 
   public String detailPage(@PathVariable int bookNo, Model model) {
       Book book = bookmanageService.searchNumber(bookNo); 
       if (book != null) {
           model.addAttribute("book", book);
       } 
       return "detail";
   }

   
   @GetMapping("/updateBook/{bookNo}")
   public String updateBookPage(@PathVariable int bookNo, Model model) {
       Book book = bookmanageService.searchNumber(bookNo);
       if (book != null) {
    	   model.addAttribute("bookNo", book.getBookNo());
           model.addAttribute("bookTitle", book.getBookTitle());
           model.addAttribute("bookWriter", book.getBookWriter());
       } 
       return "updateBook";
   }

//   @GetMapping("/updateBook")
//   public String updateBookPage() {
//       return "updateBook";
//   }

}
