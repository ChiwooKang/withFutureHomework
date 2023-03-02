package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookID;
import com.example.demo.service.BookmanageService;


@RestController
@RequestMapping("/books")
public class BookmanageController {

	@Autowired
	private BookmanageService bookmanageService;

	public BookmanageController(BookmanageService bookmanageService) {
		this.bookmanageService = bookmanageService;
	}

	@GetMapping
	public List<Book> searchAll() {
		return bookmanageService.searchAll();
	}

	@GetMapping("/{bookNo}/{bookTitle}")
	public Book searchNumber(@PathVariable int bookNo, @PathVariable String bookTitle) {
	    BookID bookId = new BookID(bookNo, bookTitle);
	    return bookmanageService.searchNumber(bookId);
	}

	@PutMapping
	public Book updateBook(@RequestBody Book book) throws Exception {
	    BookID bookId = new BookID(book.getBookID().getBookNo(),book.getBookID().getBookTitle());
	    return bookmanageService.updateBook(bookId, book);
	}

	@DeleteMapping("/{bookNo}/{bookTitle}")
	public Book deleteBook(@PathVariable int bookNo, @PathVariable String bookTitle) throws Exception {
		BookID bookId = new BookID(bookNo,bookTitle );
		return bookmanageService.deleteBook(bookId);
	}

	@PostMapping
	public Book insertBook(@RequestBody Book book) throws Exception {
		return bookmanageService.insertBook(book);
	}
}