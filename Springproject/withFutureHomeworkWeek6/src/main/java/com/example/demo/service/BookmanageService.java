package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
		return bookmanageRepository.findAll();
	}

	public Book searchNumber(BookID bookId) {
		return bookmanageRepository.findById(bookId).orElse(null);
	}

	public Book updateBook(BookID bookId, Book book) throws Exception {
	    Book oneBook = bookmanageRepository.findById(bookId).orElse(null);
	    if (oneBook == null) {
	        throw new Exception("번호로 찾을수 없는 책 입니다" + bookId);
	    }
	    oneBook.setBookWriter(book.getBookWriter());
	    return bookmanageRepository.save(oneBook);
	}

	public Book deleteBook(BookID bookId) throws Exception {
	    Optional<Book> optionalBook = bookmanageRepository.findById(bookId);
	    if (optionalBook.isPresent()) {
	        Book book = optionalBook.get();
	        bookmanageRepository.delete(book);
	        return book;
	    } else {
	        throw new Exception("삭제할 책이 존재하지 않습니다.");
	    }
	}
	public Book insertBook(Book book) throws Exception {
	    if (book.getBookID() == null || book.getBookID().getBookNo() == 0 || book.getBookWriter() == null) {
	        throw new Exception("입력된 정보가 부족합니다.");
	    }
	    return bookmanageRepository.save(book);
	}
}