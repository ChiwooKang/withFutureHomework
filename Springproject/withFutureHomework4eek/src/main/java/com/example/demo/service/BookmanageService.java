package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookID;
import com.example.demo.repository.BookmanageRepository;



@Service
public class BookmanageService {

	private BookmanageRepository bookmanageRepository;

	public BookmanageService(BookmanageRepository bookmanageRepository) {
		this.bookmanageRepository = bookmanageRepository;
	}

	public List<Book> searchAll() {
		return bookmanageRepository.searchAll();
	}

	public Book searchNumber(Integer bookNo) {
		return bookmanageRepository.searchNumber(bookNo);
	}

	public Book updateBook(Integer bookNo, Book book) throws Exception {
		Book existingBook = bookmanageRepository.searchNumber(bookNo);
		if (existingBook == null) {
			throw new Exception("번호로 찾을수 없는 책 입니다" + bookNo);
		}
		existingBook.setBookWriter(book.getBookWriter());
		return bookmanageRepository.updateBook(existingBook);
	}

	public Book deleteBook(Integer bookNo) throws Exception {
		Book existingBook = bookmanageRepository.searchNumber(bookNo);
		if (existingBook == null) {
			throw new Exception("삭제할 책이 존재하지 않습니다.");
		}
		return bookmanageRepository.deleteBook(existingBook);
	}

	public Book insertBook(Book book) {
		return bookmanageRepository.insertBook(book);
	}
}