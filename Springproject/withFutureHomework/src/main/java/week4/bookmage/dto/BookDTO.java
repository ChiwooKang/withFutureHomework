package week4.bookmage.dto;

public class BookDTO {

	private Integer bookNo;
	private String bookTitle;
	private String bookWriter;
	
	public BookDTO() {
		
	}
	
	public BookDTO(Integer bookNo, String bookTitle, String bookWriter) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
	}
	
	public Integer getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(Integer bookNo) {
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
	
	
}
