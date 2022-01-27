package com.ssafy.ws04.step3;

public class BookTest {
	public static void main(String[] args) {
		BookManager bookManager = new BookManager();
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bookManager.add(new Book("21426", "Java Pro3", "김하나", "jaen.kr", 35000, "Java 심화"));
		
		System.out.println("******************* 도서 목록 *******************");
		for(Book book : bookManager.getList()) {
			System.out.println(book); // toString method 호출
		}
		
		System.out.println("************** 도서 조회 ( 21424 ) **************");
//		Book book = bookManager.searchByIsbn("21424");
//		System.out.println(book);
		System.out.println(bookManager.searchByIsbn("21424"));
		
		System.out.println("************** 도서 삭제 ( 21424 ) **************");
		bookManager.remove("21424");
		
		System.out.println("******************* 도서 목록 *******************");
		for(Book book : bookManager.getList()) {
			System.out.println(book);
		}
	}
}
