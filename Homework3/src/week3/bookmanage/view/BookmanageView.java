package week3.bookmanage.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import week3.bookmanage.vo.Book;



public class BookmanageView {

	List<Book> books = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public void view() {
		
		while(true) {
			System.out.println("도서관리 프로그램입니다.");
			System.out.println("1.전체 조회/2.도서 번호로 조회/3.도서 업데이트/4.도서 삭제/5.도서 추가/0.종료");
			String input=sc.nextLine();
			
			switch(input) {
			case("1") : searchAll();break;
			case("2") : searchNumber(); break;
			case("3") : updateBook(); break;
			case("4") : deleteBook(); break;
			case("5") : insertBook(); break;
			case("0") :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default : System.out.println("메뉴에 작성된 번호만 입력해주세요!");
				break;
		
			}
		}
	}




	private void searchAll() {
	    while (true) {
	        System.out.println("도서 목록");
	        books.forEach(System.out::println);

	        System.out.println("종료하려면 0을 입력하세요.");
	        String input = new Scanner(System.in).nextLine();
	        if (input.equalsIgnoreCase("0")) {
	            break;
	        }
	    }
	}
	
	
	private void searchNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 할 도서의 번호를 입력하세요");
		String bookNo = sc.nextLine();
		List<Book> result = books.stream().filter(book -> book.getBookNo().equals(bookNo))
					.collect(Collectors.toList());
			if(result.isEmpty()) {
				System.out.println("일치하는 도서가 없습니다.");
				
			}else {
				result.forEach(System.out::println);
			}
	}
	
	private void updateBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 도서 번호를 입력하세요.");
		String bookNo = sc.nextLine();
		System.out.println(bookNo);
//		List<Book>result = books.stream()
		books.stream()
				.filter(book -> book.getBookNo().equals(bookNo))
				.forEach(book -> {
					System.out.println("도서명을 입력하세요");
					String bookTitle = sc.nextLine();
					System.out.println("작가를 입력하세요");
					String bookWriter = sc.nextLine();
					
					book.setBookTitle(bookTitle);
					book.setBookWriter(bookWriter);
				});
//				.collect(Collectors.toList());
//		if(result.isEmpty()) {
//			System.out.println("일치하는 도서가 없습니다.");
//		}
//		if(result.isEmpty()) {
//			System.out.println("일치하는 도서가 없습니다.");
//				
//		}else {
//			System.out.println("도서명을 입력하세요");
//			String bookTitle = sc.nextLine();
//			System.out.println("작가를 입력하세요");
//			String bookWriter = sc.nextLine();
//			
//			result.get(0).setBookTitle(bookTitle);
//			result.get(0).setBookWriter(bookWriter);
//			
//			System.out.println("정보 수정 완료입니다.");
//			
//		}
	}
	
	
	private void deleteBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제를 원하는 도서의 번호를 입력하세요");
		String bookNo = sc.nextLine();
		boolean result = books.removeIf(book -> book.getBookNo().equals(bookNo));
							/*.filter(book -> book.getBookNo().equals(bookNo))
							.collect(Collectors.toList());*/
		if(!result) {
			System.out.println("삭제할 도서가 없습니다.");
			
		}else {
			//books.remove(result.get(0));
			System.out.println("도서 삭제가 완료되었습니다.");
		}
		
	}
	
	
	/*
	 * private void insertBook() { Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("도서명을 입력하세요"); String bookTitle = sc.nextLine();
	 * System.out.println("작가를 입력하세요"); String bookWriter = sc.nextLine();
	 * 
	 * 
	 * String bookNo = String.valueOf(books.stream() .map(Book::getBookNo)
	 * .filter(Objects::nonNull) .mapToInt(Integer::parseInt) .max() .orElse(0) +
	 * 1);
	 * 
	 * Book book = new Book(bookNo, bookTitle, bookWriter); books.add(book);
	 * 
	 * System.out.println("도서가 등록되었습니다."); }
	 */
	
	
	private void insertBook() {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("도서명을 입력하세요");
	    String bookTitle = sc.nextLine();
	    System.out.println("작가를 입력하세요");
	    String bookWriter = sc.nextLine();

	    String bookNo = UUID.randomUUID().toString();

	    Book book = new Book(bookNo, bookTitle, bookWriter);
	    books = Stream.concat(books.stream(), Stream.of(book))
	    					.collect(Collectors.toList());
	    
	    books.stream().forEach(System.out::println);
	    
	    System.out.println("도서가 등록되었습니다.");
	}
	
}

