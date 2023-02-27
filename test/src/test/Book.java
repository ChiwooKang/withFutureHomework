package test;

public class Book {

String title;
int price; // 이걸 만들었기 때문에
private String isbn;
public Book(String title, int price) {
	super();
	this.title = title;
	this.price = price;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
