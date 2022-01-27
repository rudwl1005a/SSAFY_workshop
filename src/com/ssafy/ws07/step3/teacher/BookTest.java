package com.ssafy.ws07.step3.teacher;


/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {

	public static void main(String[] args) {
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체를 생성한다.
		IBookManager bookManager = BookManagerImpl.getInstance();
		// BookManager 객체를 이용해  도서정보를 추가한다.
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법",10));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용",20));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링",30));
		bookManager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1,40));

		System.out.println("**********************도서 전체 목록**********************");
		for (Book b : bookManager.getList()) {
			System.out.println(b);
		}
		
		System.out.println("**********************일반 도서 목록**********************");
		for (Book b : bookManager.getBooks()) {
			System.out.println(b);
		}
		System.out.println("**********************잡지 목록**********************");
		for (Book b : bookManager.getMagazines()) {
			System.out.println(b);
		}
		System.out.println("**********************도서 제목 포함검색**********************");
		for (Book b : bookManager.searchByTitle("Java")) {
			System.out.println(b);
		}
		System.out.println("도서 가격 총합 : "+bookManager.getTotalPrice());
		System.out.println("도서 가격 평균: "+bookManager.getPriceAvg());	
		try {
			// BookManager 객체를 이용해  도서를 수량만큼 판매한다.
			System.out.println("**********************도서판매:21424,11개**********************");
			bookManager.sell("21424",11);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QuantityException e) {
			System.out.println(e.getMessage());
		}
		try {
			// BookManager 객체를 이용해  도서를 수량만큼 구매한다.
			System.out.println("**********************도서구매:21424,10개**********************");
			bookManager.buy("21424",10);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(bookManager.searchByIsbn("21424"));
		try {
			// BookManager 객체를 이용해  도서를 수량만큼 판매한다.
			System.out.println("**********************도서판매:21424,11개**********************");
			bookManager.sell("21424",11);
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QuantityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(bookManager.searchByIsbn("21424"));
	}
}
