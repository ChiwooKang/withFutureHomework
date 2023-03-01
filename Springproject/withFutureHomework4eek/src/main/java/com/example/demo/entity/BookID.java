package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BookID implements Serializable {

	@Column(name = "book_no")
	private int bookNo;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	public BookID(int bookNo, String bookTitle) {
		
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		
	}
	
}
