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
import com.example.demo.service.BookmanageService;


@RestController
@RequestMapping("/books")
public class BookmanageController {

	private BookmanageService bookmanageService;

	public BookmanageController(BookmanageService bookmanageService) {
		this.bookmanageService = bookmanageService;
	}

	@GetMapping
	public List<Book> searchAll() {
		return bookmanageService.searchAll();
	}

	@GetMapping("/{bookNo}")
	public Book searchNumber(@PathVariable Integer bookNo) {
		return bookmanageService.searchNumber(bookNo);
	}

	@PutMapping("/{bookNo}")
	public Book updateBook(@PathVariable Integer bookNo, @RequestBody Book book) throws Exception {
		return bookmanageService.updateBook(bookNo, book);
	}

	@DeleteMapping("/{bookNo}")
	public Book deleteBook(@PathVariable Integer bookNo) throws Exception {
		return bookmanageService.deleteBook(bookNo);
	}

	@PostMapping
	public Book insertBook(@RequestBody Book book) {
		return bookmanageService.insertBook(book);
	}
}