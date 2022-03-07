package model;

import java.util.HashMap;

import model.dto.Book;

public class BookModel {
	private static HashMap<String, Book> books = new HashMap<>();
	
	static {
		books.put("01a", new Book("01a", "Ÿ��", "Ÿ�θ�����", 100));
		books.put("02a", new Book("02a", "IT���", "Java������", 200));
		books.put("03a", new Book("03a", "��", "������", 300));
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
			throw new Exception("�ϰ� ��û�� å ����!!!");
		}else {
			return b;
		}
	}
}
