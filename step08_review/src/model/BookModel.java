package model;

import java.util.HashMap;

import model.dto.Book;

public class BookModel {
	private static HashMap<String, Book> books = new HashMap<>();
	
	static {
		books.put("01a", new Book("01a", "타로", "타로마스터", 100));
		books.put("02a", new Book("02a", "IT기술", "Java마스터", 200));
		books.put("03a", new Book("03a", "시", "윤동주", 300));
	}
	
	public static HashMap<String, Book> bookAll(){
		return books;
	}
	
	public static Book book(String isbn) {   
		return books.get(isbn);
	}
	
	public static Book bookOne(String isbn) throws Exception {
		Book b = books.get(isbn);
		if(b == null) {
			throw new Exception("니가 요청한 책 없다!!!");
		}else {
			return b;
		}
	}
}
