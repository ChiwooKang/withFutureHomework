package week1.bookmanage.vo;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);
	
	private String bookNo;
	private String bookTitle;
	private String bookWriter;
	private boolean bookAvail;
	
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public boolean bookAvail() {
		return bookAvail;
	}
	
	public void setbookAvail(boolean bookAvail) {
		this.bookAvail = bookAvail;
	}
}


	
	

