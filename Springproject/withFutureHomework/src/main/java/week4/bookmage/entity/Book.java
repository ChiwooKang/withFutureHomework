package week4.bookmage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	private Integer bookNo;
	private String bookTitle;
	private String bookWriter;
	public Object getBookTitle() {
		
		return bookTitle;
	}
	public void setBookTitle(Object bookTitle2) {
		
	}
	
	public void setBookWriter(Object object) {
		
	}
	public Object getBookWriter() {
		
		return bookWriter;
	}
	public Integer getBookNo() {
		
		return bookNo;
	}
	
	
}
