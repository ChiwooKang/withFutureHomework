package week1.bookmanage.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import week1.bookmanage.vo.Book;

public class BookmanageView {
	
	Scanner sc = new Scanner(System.in);
	
	
	
	Book book = new Book();
	 
	 private ArrayList<Book> bookList = new ArrayList<Book>();
	
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
			
			Book book = new Book();
			
			while(true) {
				
				for(int i=0; i<bookList.size(); i++) {				
	                System.out.println("책 번호 : " + bookList.get(i).getBookNo());
	                System.out.println("책 제목 : " + bookList.get(i).getBookTitle());
	                System.out.println("작가  : " + bookList.get(i).getBookWriter());          
				}
				
				System.out.println("뒤로가기 : b / 프로그램 종료 : 0 ");
				String temp = sc.nextLine();
				
				if(temp.equals("b")) {
					break;
				}else if (temp.equals("0")) {
	                System.out.println("프로그램을 종료합니다.");
	                System.exit(0);
	            } else {
	                System.out.println("잘못 누르셨습니다. 초기화면으로 이동합니다.");
	                
	                break; 
	            } 
				
			}
		}
		
		private void searchNumber() {
			 while (true) {
		            System.out.println("검색 할 책의 번호를 입력하세요");
		            String temp = sc.nextLine();
		            int cnt = 0;
		            for (int i = 0; i < bookList.size(); i++) {
		                if (temp.equals(bookList.get(i).getBookNo())) {
		                   
		                    System.out.println("책 번호 : " + bookList.get(i).getBookNo());
		                    System.out.println("책 제목 : " + bookList.get(i).getBookTitle());
		                    System.out.println("지은이  : " + bookList.get(i).getBookWriter());
		                    
		                    cnt++;
		                    break;
		                }
		            } 
		            if (cnt == 0) {
		                System.out.println(" 도서가 존재하지 않습니다.");
		            } else {
		                break;
		            }
		        } 
			
		}
		
		private void updateBook() {
			while (true) {
	            System.out.println("수정을 원하는 도서의 번호를 입력해주세요");
	            String temp = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < bookList.size(); i++) {
	                if (temp.equals(bookList.get(i).getBookNo())) {
	                    System.out.println("새로운 제목 입력: ");
	                    bookList.get(i).setBookTitle(sc.nextLine());
	                    System.out.println("새로운 지은이 입력: ");
	                    bookList.get(i).setBookWriter(sc.nextLine());
	                   
	                    cnt++;
	                    System.out.println("도서 수정 완료");
	                    break;
	                }
	            } 
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
	            } else {
	                break;
	            }
	        } 
		}
		
		private void deleteBook() {
			 while (true) {
		            System.out.println("삭제 할 도서의 번호를 입력해주세요");
		            String temp = sc.nextLine();
		            int cnt = 0;
		            for (int i = 0; i < bookList.size(); i++) {
		                if (temp.equals(bookList.get(i).getBookNo())) {
		                    bookList.remove(i);
		                    cnt++;
		                    System.out.println("도서 삭제 완료");
		                    break;
		                }
		            } 
		            if (cnt == 0) {
		                System.out.println("해당 도서가 존재하지 않습니다.");
		            } else {
		                break;
		            }
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
		                for (int i = 0; i < bookList.size(); i++) {
		                    if (temp.equals(bookList.get(i).getBookNo())) {
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
		                bookList.add(book);
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


