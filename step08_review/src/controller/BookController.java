package controller;

import model.BookModel;
import model.dto.Book;
import view.FailView;
import view.SuccessView;

public class BookController {
	public static void bookOne(String isbn) {
		try {
			Book book = BookModel.bookOne(isbn);
			SuccessView.printBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.messageView(e.getMessage());
		}
	}
	
}
