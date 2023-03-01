package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookID;
@Repository
public class BookmanageRepository {

	private static Map<Integer, Book> books = new HashMap<>();

	public List<Book> searchAll() {
		return new ArrayList<>(books.values());
	}

	public Book searchNumber(Integer bookNo) {
		return books.get(bookNo);
	}

	public Book updateBook(Book book) {
		books.put(book.getBookID().getBookNo(), book);
		return book;
	}

	public Book deleteBook(Book book) {
		return books.remove(book.getBookID().getBookNo());
	}

	public Book insertBook(Book book) {
		books.put(book.getBookID().getBookNo(), book);
		return book;
	}
}