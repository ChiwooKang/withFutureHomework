package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookmanageRepository;
//import com.example.demo.entity.BookID;
import com.example.demo.service.BookmanageService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/books")
public class BookmanageController {
   
   private BookmanageService bookmanageService;
   private UserService userService;
   
   public BookmanageController(BookmanageService bookmanageService, UserService userService) {
       this.bookmanageService = bookmanageService;
       this.userService = userService;
   }
    
  @GetMapping
  public List<Book> searchAll() {
      return bookmanageService.searchAll();
  }
  

  @GetMapping("/{bookNo}")
 
  public Book searchNumber(@PathVariable int bookNo) {
      return bookmanageService.searchNumber(bookNo);
  }


  @PutMapping("/updateBook")
  public Book updateBook( @RequestBody Book book){// @ Valid 삭제
      return bookmanageService.updateBook(book.getBookNo(), book);
  }

  
  @DeleteMapping("/{bookNo}")
  public Book deleteBook(@PathVariable int bookNo) throws Exception {
      return bookmanageService.deleteBook(bookNo);
  }
  
  
  @PostMapping
  public Book insertBook( @RequestBody Book book) throws Exception { //@Valid 삭제 후 테스트
      return bookmanageService.insertBook(book);
  }
}


   
//   @GetMapping("/login")
//   public String  loginPage(){
//       return "login";  
//   }
//    @GetMapping("/login")
//       public ModelAndView loginPage() {
//           ModelAndView modelAndView = new ModelAndView();
//           modelAndView.setViewName("login");
//           return modelAndView;
//       }
   
// 무조건 리다이렉트로 로그인 시도해보기, 성공 확인    
//    @PostMapping("/postLogin")
//    public ModelAndView postLogin() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/books/allBooks");
//        return modelAndView;
//    }

//   @GetMapping("/allBooks")
//   public String allBooks() {
//       return "allBooks";  
//   }

//    @GetMapping("/allBooks")
//    public ModelAndView allBooksView() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("allBooks");  
//        // 데이터 설정 (modelAndView.addObject("books", bookList);)
//        return modelAndView;
//    }
    
//    @GetMapping("/searchNumber")
//    public ModelAndView searchNumberPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("searchNumber"); 
//        return modelAndView;
//    }


//@Controller
//@RequestMapping("/books")
//public class BookmanageController {
//
//    private BookmanageService bookmanageService;
//    
//    @GetMapping("/allBooks")
//    public String allBooks() {
//        return "allBooks";  // allBooks.html 페이지를 반환
//    }
//   
//
//    public BookmanageController(BookmanageService bookmanageService) {
//        this.bookmanageService = bookmanageService;
//    }
//    
//    @GetMapping
//    @ResponseBody
//    public List<Book> searchAll() {
//        return bookmanageService.searchAll();
//    }
//    
//
//    @GetMapping("/{bookNo}")
//    @ResponseBody
//    public Book searchNumber(@PathVariable int bookNo) {
//        return bookmanageService.searchNumber(bookNo);
//    }
//
//
//    @PutMapping
//    @ResponseBody
//    public Book updateBook(@RequestBody Book book) throws Exception {
//        return bookmanageService.updateBook(book.getBookNo(), book);
//    }
//
//    
//    @DeleteMapping("/{bookNo}")
//    @ResponseBody
//    public Book deleteBook(@PathVariable int bookNo) throws Exception {
//        return bookmanageService.deleteBook(bookNo);
//    }
//
//
//    @PostMapping
//    @ResponseBody
//    public Book insertBook(@Valid @RequestBody Book book) throws Exception { //@Valid 삭제 후 테스트
//        return bookmanageService.insertBook(book);
//    }
//}

