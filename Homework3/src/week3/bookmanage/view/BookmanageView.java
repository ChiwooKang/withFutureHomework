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
			System.out.println("�������� ���α׷��Դϴ�.");
			System.out.println("1.��ü ��ȸ/2.���� ��ȣ�� ��ȸ/3.���� ������Ʈ/4.���� ����/5.���� �߰�/0.����");
			String input=sc.nextLine();
			
			switch(input) {
			case("1") : searchAll();break;
			case("2") : searchNumber(); break;
			case("3") : updateBook(); break;
			case("4") : deleteBook(); break;
			case("5") : insertBook(); break;
			case("0") :
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default : System.out.println("�޴��� �ۼ��� ��ȣ�� �Է����ּ���!");
				break;
		
			}
		}
	}




	private void searchAll() {
	    while (true) {
	        System.out.println("���� ���");
	        books.forEach(System.out::println);

	        System.out.println("�����Ϸ��� 0�� �Է��ϼ���.");
	        String input = new Scanner(System.in).nextLine();
	        if (input.equalsIgnoreCase("0")) {
	            break;
	        }
	    }
	}
	
	
	private void searchNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�˻� �� ������ ��ȣ�� �Է��ϼ���");
		String bookNo = sc.nextLine();
		List<Book> result = books.stream().filter(book -> book.getBookNo().equals(bookNo))
					.collect(Collectors.toList());
			if(result.isEmpty()) {
				System.out.println("��ġ�ϴ� ������ �����ϴ�.");
				
			}else {
				result.forEach(System.out::println);
			}
	}
	
	private void updateBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���� ��ȣ�� �Է��ϼ���.");
		String bookNo = sc.nextLine();
		System.out.println(bookNo);
//		List<Book>result = books.stream()
		books.stream()
				.filter(book -> book.getBookNo().equals(bookNo))
				.forEach(book -> {
					System.out.println("�������� �Է��ϼ���");
					String bookTitle = sc.nextLine();
					System.out.println("�۰��� �Է��ϼ���");
					String bookWriter = sc.nextLine();
					
					book.setBookTitle(bookTitle);
					book.setBookWriter(bookWriter);
				});
//				.collect(Collectors.toList());
//		if(result.isEmpty()) {
//			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
//		}
//		if(result.isEmpty()) {
//			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
//				
//		}else {
//			System.out.println("�������� �Է��ϼ���");
//			String bookTitle = sc.nextLine();
//			System.out.println("�۰��� �Է��ϼ���");
//			String bookWriter = sc.nextLine();
//			
//			result.get(0).setBookTitle(bookTitle);
//			result.get(0).setBookWriter(bookWriter);
//			
//			System.out.println("���� ���� �Ϸ��Դϴ�.");
//			
//		}
	}
	
	
	private void deleteBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���ϴ� ������ ��ȣ�� �Է��ϼ���");
		String bookNo = sc.nextLine();
		boolean result = books.removeIf(book -> book.getBookNo().equals(bookNo));
							/*.filter(book -> book.getBookNo().equals(bookNo))
							.collect(Collectors.toList());*/
		if(!result) {
			System.out.println("������ ������ �����ϴ�.");
			
		}else {
			//books.remove(result.get(0));
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
		}
		
	}
	
	
	/*
	 * private void insertBook() { Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("�������� �Է��ϼ���"); String bookTitle = sc.nextLine();
	 * System.out.println("�۰��� �Է��ϼ���"); String bookWriter = sc.nextLine();
	 * 
	 * 
	 * String bookNo = String.valueOf(books.stream() .map(Book::getBookNo)
	 * .filter(Objects::nonNull) .mapToInt(Integer::parseInt) .max() .orElse(0) +
	 * 1);
	 * 
	 * Book book = new Book(bookNo, bookTitle, bookWriter); books.add(book);
	 * 
	 * System.out.println("������ ��ϵǾ����ϴ�."); }
	 */
	
	
	private void insertBook() {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("�������� �Է��ϼ���");
	    String bookTitle = sc.nextLine();
	    System.out.println("�۰��� �Է��ϼ���");
	    String bookWriter = sc.nextLine();

	    String bookNo = UUID.randomUUID().toString();

	    Book book = new Book(bookNo, bookTitle, bookWriter);
	    books = Stream.concat(books.stream(), Stream.of(book))
	    					.collect(Collectors.toList());
	    
	    books.stream().forEach(System.out::println);
	    
	    System.out.println("������ ��ϵǾ����ϴ�.");
	}
	
}

