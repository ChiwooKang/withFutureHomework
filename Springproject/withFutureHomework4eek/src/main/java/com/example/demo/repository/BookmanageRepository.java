package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;



@Repository
public class BookmanageRepository {

	private static Map<Integer, Book>books = new HashMap<>();
	
	public static List<Book> searchAll(){
		return new ArrayList<>(books.values());
	}
	
	public static Book searchNumber(Integer bookNo) {
		
		return books.get(bookNo);
	}
	
	public Book updateBook(Integer bookNo, Book book) {
		
		return books.put(bookNo, book);
	}
	
	public Book deleteBook(Integer bookNo) {
		
		return books.remove(bookNo);
	}
	
	public Book insertBook(Book book) {
		
		return books.put(book.getBookNo(), book);
	}
}
