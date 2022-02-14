package com.ssafy.hw0126.hw02;

public class BookTest {
	public static void main(String[] args) {
		IBookManager bookManager = BookManagerImpl.getInstance();
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bookManager.add(new Book("21429", "Spring", "김하나", "jaen.kr", 25000, "Spring 기본 문법"));
		bookManager.add(new Book("21426", "Java Pro3", "김하나", "jaen.kr", 35000, "Java 심화"));
		
		System.out.println("******************* 도서 목록 *******************");
		for(Book book : bookManager.getList()) {
			System.out.println(book); // toString method 호출
		}
		
		System.out.println("************** 도서 조회 ( 21424 ) **************");
		System.out.println(bookManager.searchByIsbn("21424"));
		
		System.out.println("************* 도서 제목 포함 검색 : Java *************");
		bookManager.SearchByTitle("Java");

		System.out.println("************* 가격순으로 정렬 *************");
		bookManager.priceSorted();
		
		System.out.println("************* 제목순으로 정렬 *************");
		bookManager.titleSorted();
		
	}
}
