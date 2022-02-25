package view;

import org.junit.Test;

import controller.BookController;

public class StartView {
	
	@Test
	public void getBook() {
		BookController.bookOne("01a"); 
	}
	
}
