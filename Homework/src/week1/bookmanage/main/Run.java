package week1.bookmanage.main;

import week1.bookmanage.view.BookmanageView;
import week1.bookmanage.vo.Book;

public class Run {

	public static void main(String[] args) {
		Book book = new Book();
		
		new BookmanageView().view();
	

	}

}
