package week3.bookmanage.vo;

public class Book {

	private String bookNo;
	private String bookTitle;
	private String bookWriter;
	
	
	
	public Book(String bookNo, String bookTitle, String bookWriter) {
		
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		
	}



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
	
	 @Override
	    public String toString() {
	        return "������ȣ: " + bookNo + ", ������: " + bookTitle + ", �۰�: " + bookWriter;
	    }
	
	
	
}
