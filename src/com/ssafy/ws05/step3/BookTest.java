package com.ssafy.ws05.step3;

import java.util.Arrays;

public class BookTest {
	public static void main(String[] args) {
		BookManager bookManager = new BookManager();
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bookManager.add(new Book("21426", "Java Pro3", "김하나", "jaen.kr", 35000, "Java 심화"));
		bookManager.add(new Book("21429", "Spring", "김하나", "jaen.kr", 25000, "Spring 기본 문법"));
		bookManager.add(new Magazine("21427", "분석설계", "김하나", "jaen.kr", 45000, "SW 모델링", 2021, 1));
		bookManager.add(new Magazine("21428", "월간 알고리즘", "김하나", "jaen.kr", 55000, "3월 알고리즘", 2021, 3));
		
		System.out.println("******************* 도서 목록 *******************");
		for(Book book : bookManager.getList()) {
			System.out.println(book); // toString method 호출
		}
		
		System.out.println("************** 도서 조회 ( 21424 ) **************");
		System.out.println(bookManager.searchByIsbn("21424"));
		
		System.out.println("************** 도서 삭제 ( 21424 ) **************");
		bookManager.remove("21424");
		
		System.out.println("******************* 도서 목록 *******************");
		for(Book book : bookManager.getList()) {
			System.out.println(book);
		}
		
		System.out.println("************* 도서 제목 포함 검색 : Java *************");
		System.out.println(Arrays.toString(bookManager.SearchByTitle("Java")));
		
		System.out.println("******************* 잡지 목록 *******************");
		System.out.println(Arrays.toString(bookManager.getMagazines()));
		
		System.out.println("****************** 일반 도서 목록 *****************");
		System.out.println(Arrays.toString(bookManager.getBooks()));
		
		System.out.println("도서 가격 총합:" + bookManager.getTotalPrice());
		System.out.println("도서 가격 평균:" + bookManager.getPriceAvg());
		
	}
}
