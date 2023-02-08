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
            System.out.println("�������� ���α׷��Դϴ�.");
            System.out.println("1.��ü ��ȸ/2.���� ��ȣ�� ��ȸ/3.���� ������Ʈ/4.���� ����/5.���� �߰�/0.����");
            String input = sc.nextLine();

            switch (input) {
                case ("1"): searchAll(); break;
                case ("2"): searchNumber(); break;
                case ("3"): updateBook(); break;
                case ("4"): deleteBook(); break;
                case ("5"): insertBook(); break;
                case ("0"):
                    System.out.println("���α׷��� �����մϴ�.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("�޴��� �ۼ��� ��ȣ�� �Է����ּ���!");
                    break;
            }
        }
    }

    


	private void searchAll() {
    	
        Iterator<String> iterator = bookList.keySet().iterator();
        
        while (iterator.hasNext()) {
            String bookNo = iterator.next();
            Book book = bookList.get(bookNo);
            System.out.println("å ��ȣ : " + book.getBookNo());
            System.out.println("å ���� : " + book.getBookTitle());
            System.out.println("�۰�  : " + book.getBookWriter());
        }
        System.out.println("�ڷΰ��� : b / ���α׷� ���� : 0 ");
        String temp = sc.nextLine();
        if (temp.equals("b")) {
            return;
        } else if (temp.equals("0")) {
            System.out.println("���α׷��� �����մϴ�.");
            System.exit(0);
        } else {
        	 System.out.println("�߸� �����̽��ϴ�. �ʱ�ȭ������ �̵��մϴ�.");
        }
    }
    
    private void searchNumber() {
    	
    	Iterator<String> iterator = bookList.keySet().iterator();
    	
		 while (iterator.hasNext()) {
	            System.out.println("�˻� �� å�� ��ȣ�� �Է��ϼ���");
	            String temp = sc.nextLine();
	            
            if (bookList.containsKey(temp)) {
            	String bookNo = iterator.next();
                Book book = bookList.get(bookNo);
            	System.out.println("å ��ȣ : " + book.getBookNo());
                System.out.println("å ���� : " + book.getBookTitle());
                System.out.println("�۰�  : " + book.getBookWriter());
                break;
            }else {
            	System.out.println(" ������ �������� �ʽ��ϴ�.");
            	break;
            }
	             
	    } 
		
	}
    

    private void updateBook() {
    	
    	System.out.println("������ ���ϴ� ������ ��ȣ�� �Է����ּ���");
    	String temp = sc.nextLine();
    	Book findBook = bookList.get(temp);
    	
    	if(findBook == null) {
    		System.out.println("�������� �ʴ� �����Դϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���");
    	}else {
    		System.out.println("���ο� ���� �Է� : ");
    		findBook.setBookTitle(sc.nextLine());
    		System.out.println("���ο� �۰� �Է� : ");
    		findBook.setBookWriter(sc.nextLine());
    		
    		System.out.println("���� �Ϸ�");
    	}
		
	}
    
    private void deleteBook() {
    	
    	System.out.println("������ ������ ��ȣ�� �Է����ּ���");
    	
    	String temp = sc.nextLine();
    	
    	if(bookList.containsKey(temp)) {
    		bookList.remove(temp);
    		System.out.println("���� �Ϸ�");
    	}else {
    		System.out.println("�������� �ʴ� �����Դϴ�.");
    	}
    	
    }
    
private void insertBook() {
		
		Book book = new Book();
		
		book.setBookNo(UUID.randomUUID().toString());
		
		 while (true) {
	            
	            while (true) {
	                int cnt=0;
	                System.out.println("���� ��ȣ �Է�");
	                String temp = sc.nextLine();
	                for (Entry<String, Book> entry : bookList.entrySet()) {
	                    if (temp.equals(entry.getValue().getBookNo())) {
	                        cnt++;
	                        System.out.println("���� ��ȣ �ߺ��Դϴ�. �ٽ� �Է��ϼ���.");
	                        break;
	                    } 
	                } 
	                if(cnt==0) {
	                    book.setBookNo(temp);
	                    break;
	                }
	            } 
	            System.out.println("å ���� �Է�");
	            book.setBookTitle(sc.nextLine());
	            System.out.println("�۰� �Է�");
	            book.setBookWriter(sc.nextLine());
	           
	            
	            System.out.println("������ȣ : " + book.getBookNo());
	            System.out.println("�������� : " + book.getBookTitle());
	            System.out.println("�۰�  : " + book.getBookWriter());
	     
	 
	            System.out.println("�Է��Ͻ� ������ ��� �½��ϱ�? ��(Y) �ƴϿ�(N)");
	            String confirm = sc.nextLine();
	            if (confirm.equals("y")) {
	                bookList.put(book.getBookNo(), book);
	                System.out.println("======�Է� �Ϸ�=====");
	                break;
	            } else if (confirm.equals("n")) {
	                System.out.println("���� ������ ���� �Է��ϼ���.");
	            } else {
	                System.out.println("�߸� �����̽��ϴ�. ���� �޴��� �̵��մϴ�");
	                break; 
	            } 
		 	}
		}    
}