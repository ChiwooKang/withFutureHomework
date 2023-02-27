package test;

public class Book2 {
	public static void main(String[] args)  {
	
	Book b1 = new Book(); // 기본 생성자 객체생성 // 아래 -- 의 경우 여기서 에러발생
	Book b2 = new Book("책", 1000); // 매개변수를 가진 생성자 호출
 }
}
