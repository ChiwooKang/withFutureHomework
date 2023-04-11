package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookID;

@Repository
public interface BookmanageRepository extends JpaRepository<Book, BookID>{

}