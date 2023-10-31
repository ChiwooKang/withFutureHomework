package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookmanageRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findByBookTitle(String bookTitle);

	  void deleteAllByBookNoIn(List<Integer> ids);

}
