package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.controller.BookmanageController;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookID;
import com.example.demo.service.BookmanageService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookmanageController.class)
public class BookmanageControllerTest {

    @Mock
    private BookmanageService bookmanageService;

    @InjectMocks
    private BookmanageController bookmanageController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchAll() {
        // given
        List<Book> books = new ArrayList<>();
        books.add(new Book(new BookID(1, "book1"), "writer1"));
        books.add(new Book(new BookID(2, "book2"), "writer2"));
        Mockito.when(bookmanageService.searchAll()).thenReturn(books);

        // when
        List<Book> result = bookmanageController.searchAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getBookID().getBookNo()).isEqualTo(1);
        assertThat(result.get(0).getBookID().getBookTitle()).isEqualTo("book1");
        assertThat(result.get(0).getBookWriter()).isEqualTo("writer1");
        
        System.out.println(books.get(0).getBookID());
        System.out.println(books.get(0).getBookWriter());
        System.out.println(books);
     
    }
    
    @Test
    public void testSearchNumber() {
	    // given
	    int bookNo = 1;
	    String bookTitle = "book1";
	    BookID bookId = new BookID(bookNo, bookTitle);
	    Book book = new Book(bookId, "writer1");
	    Mockito.when(bookmanageService.searchNumber(bookId)).thenReturn(book);

	    // when
	    Book result = bookmanageController.searchNumber(bookNo, bookTitle, null);
	
	    // then
	    assertThat(result.getBookID().getBookNo()).isEqualTo(bookNo);
	    assertThat(result.getBookID().getBookTitle()).isEqualTo(bookTitle);
	    assertThat(result.getBookWriter()).isEqualTo("writer1");
	    
	   System.out.println(book);
	   System.out.println(book.getBookID());
	   System.out.println(book.getBookWriter());
    }
    
    @Test
    public void testUpdateBook() throws Exception {
	    // given
	    Book book = new Book(new BookID(1, "book1"), "writer1");
	    Mockito.when(bookmanageService.updateBook(Mockito.any(BookID.class), Mockito.any(Book.class))).thenReturn(book);
	
	    // when
	    Book result = bookmanageController.updateBook(book);
	
	    // then
	    assertThat(result.getBookID().getBookNo()).isEqualTo(1);
	    assertThat(result.getBookID().getBookTitle()).isEqualTo("book1");
	    assertThat(result.getBookWriter()).isEqualTo("writer1");
	    

    }
    
    @Test
	public void testDeleteBook() throws Exception {
	    // given
	    int bookNo = 1;
	    String bookTitle = "book1";
	    BookID bookId = new BookID(bookNo, bookTitle);
	    Book book = new Book(bookId, "writer1");
	    Mockito.when(bookmanageService.deleteBook(bookId)).thenReturn(book);
	
	    // when
	    Book result = bookmanageController.deleteBook(bookNo, bookTitle);
	
	    // then
	    assertThat(result.getBookID().getBookNo()).isEqualTo(bookNo);
	    assertThat(result.getBookID().getBookTitle()).isEqualTo(bookTitle);
	    assertThat(result.getBookWriter()).isEqualTo("writer1");
	    
	  
    }
    
    @Test
    public void testInsertBook() throws Exception {
        // given
        Book book = new Book(new BookID(1, "book1"), "writer1");
        Mockito.when(bookmanageService.insertBook(Mockito.any(Book.class))).thenReturn(book);

        // when
        Book result = bookmanageController.insertBook(book);

        // then
        assertThat(result.getBookID().getBookNo()).isEqualTo(1);
        assertThat(result.getBookID().getBookTitle()).isEqualTo("book1");
        assertThat(result.getBookWriter()).isEqualTo("writer1");
        
        System.out.println(book.getBookWriter());
        System.out.println(book.getBookID());
        System.out.println(book);
    }
    
   
}


