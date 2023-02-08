package week2.bookmanage.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import week2.bookmanage.vo.Book;

public class BookmanageView {

    Scanner sc = new Scanner(System.in);

    HashMap<String, Book> bookList = new HashMap<>();

    public void view() {
        while (true) {
            System.out.println("도서관리 프로그램입니다.");
            System.out.println("1.전체 조회/2.도서 번호로 조회/3.도서 업데이트/4.도서 삭제/5.도서 추가/0.종료");
            String input = sc.nextLine();

            switch (input) {
                case ("1"): searchAll(); break;
                case ("2"): searchNumber(); break;
                case ("3"): updateBook(); break;
                case ("4"): deleteBook(); break;
                case ("5"): insertBook(); break;
                case ("0"):
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("메뉴에 작성된 번호만 입력해주세요!");
                    break;
            }
        }
    }

    


	private void searchAll() {
    	
        Iterator<String> iterator = bookList.keySet().iterator();
        
        while (iterator.hasNext()) {
            String bookNo = iterator.next();
            Book book = bookList.get(bookNo);
            System.out.println("책 번호 : " + book.getBookNo());
            System.out.println("책 제목 : " + book.getBookTitle());
            System.out.println("작가  : " + book.getBookWriter());
        }
        System.out.println("뒤로가기 : b / 프로그램 종료 : 0 ");
        String temp = sc.nextLine();
        if (temp.equals("b")) {
            return;
        } else if (temp.equals("0")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        } else {
        	 System.out.println("잘못 누르셨습니다. 초기화면으로 이동합니다.");
        }
    }
    
    private void searchNumber() {
    	
    	Iterator<String> iterator = bookList.keySet().iterator();
    	
		 while (iterator.hasNext()) {
	            System.out.println("검색 할 책의 번호를 입력하세요");
	            String temp = sc.nextLine();
	            
            if (bookList.containsKey(temp)) {
            	String bookNo = iterator.next();
                Book book = bookList.get(bookNo);
            	System.out.println("책 번호 : " + book.getBookNo());
                System.out.println("책 제목 : " + book.getBookTitle());
                System.out.println("작가  : " + book.getBookWriter());
                break;
            }else {
            	System.out.println(" 도서가 존재하지 않습니다.");
            	break;
            }
	             
	    } 
		
	}
    

    private void updateBook() {
    	
    	System.out.println("수정을 원하는 도서의 번호를 입력해주세요");
    	String temp = sc.nextLine();
    	Book findBook = bookList.get(temp);
    	
    	if(findBook == null) {
    		System.out.println("존재하지 않는 도서입니다. 도서 번호를 다시 입력하세요");
    	}else {
    		System.out.println("새로운 제목 입력 : ");
    		findBook.setBookTitle(sc.nextLine());
    		System.out.println("새로운 작가 입력 : ");
    		findBook.setBookWriter(sc.nextLine());
    		
    		System.out.println("수정 완료");
    	}
		
	}
    
    private void deleteBook() {
    	
    	System.out.println("삭제할 도서의 번호를 입력해주세요");
    	
    	String temp = sc.nextLine();
    	
    	if(bookList.containsKey(temp)) {
    		bookList.remove(temp);
    		System.out.println("삭제 완료");
    	}else {
    		System.out.println("존재하지 않는 도서입니다.");
    	}
    	
    }
    
private void insertBook() {
		
		Book book = new Book();
		
		book.setBookNo(UUID.randomUUID().toString());
		
		 while (true) {
	            
	            while (true) {
	                int cnt=0;
	                System.out.println("도서 번호 입력");
	                String temp = sc.nextLine();
	                for (Entry<String, Book> entry : bookList.entrySet()) {
	                    if (temp.equals(entry.getValue().getBookNo())) {
	                        cnt++;
	                        System.out.println("도서 번호 중복입니다. 다시 입력하세요.");
	                        break;
	                    } 
	                } 
	                if(cnt==0) {
	                    book.setBookNo(temp);
	                    break;
	                }
	            } 
	            System.out.println("책 제목 입력");
	            book.setBookTitle(sc.nextLine());
	            System.out.println("작가 입력");
	            book.setBookWriter(sc.nextLine());
	           
	            
	            System.out.println("도서번호 : " + book.getBookNo());
	            System.out.println("도서제목 : " + book.getBookTitle());
	            System.out.println("작가  : " + book.getBookWriter());
	     
	 
	            System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
	            String confirm = sc.nextLine();
	            if (confirm.equals("y")) {
	                bookList.put(book.getBookNo(), book);
	                System.out.println("======입력 완료=====");
	                break;
	            } else if (confirm.equals("n")) {
	                System.out.println("도서 정보를 새로 입력하세요.");
	            } else {
	                System.out.println("잘못 누르셨습니다. 시작 메뉴로 이동합니다");
	                break; 
	            } 
		 	}
		}    
}