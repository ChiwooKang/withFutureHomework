package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookmanageRepository;


@Component
public class BookmanageService {


	
	/** 전체 조회
	 * @return
	 */
	public List<Book> searchAll() {
		
		BookmanageRepository bookmanageRepository = new BookmanageRepository();
		
		return bookmanageRepository.searchAll();
	}

	/** 번호로 조회
	 * @param bookNo
	 * @return
	 */
	public Book searchNumber(Integer bookNo) {
		
		BookmanageRepository bookmanageRepository = new BookmanageRepository();
		
		return bookmanageRepository.searchNumber(bookNo);
	}

	
	public  Book updateBook(Integer bookNo, Book book) throws Exception {
		
		BookmanageRepository bookmanageRepository = new BookmanageRepository();
		
		Book oneBook = BookmanageRepository.searchNumber(bookNo);
		
		if(oneBook == null) {
			throw new Exception("번호로 찾을수 없는 책 입니다" + bookNo);
		}
		
		oneBook.setBookTitle(book.getBookTitle());
		oneBook.setBookWriter(book.getBookWriter());
		
		
	
		
		return bookmanageRepository.updateBook(bookNo, oneBook); 
		
	}
	
	public Book deleteBook(Integer bookNo) {
		
		BookmanageRepository bookmanageRepository = new BookmanageRepository();
		
		
		
		return bookmanageRepository.deleteBook(bookNo);
	}
	
	public Book insertBook(Book book) {
		
		BookmanageRepository bookmanageRepository = new BookmanageRepository();
		
		return bookmanageRepository.insertBook(book);
		
	}

}

