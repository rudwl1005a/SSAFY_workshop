package com.ssafy.hw0126.hw02;

import java.util.Arrays;
import java.util.stream.Stream;

public class BookManagerImpl implements IBookManager {
	
	// singleton
	private BookManagerImpl() {}
	private static BookManagerImpl bookManager;
	public static IBookManager getInstance() {
		if(bookManager == null) {
			bookManager = new BookManagerImpl();
		}
		return bookManager;
	}
	
	static void print(Stream<?> stream) {
		// ★☆★☆★☆★☆ lambda 수정 ★☆★☆★☆★☆★☆★☆
		stream.forEach(a -> System.out.println(a));
	}
	
	// 자료구조
	// Book 최대 100개 관리
	private static int MAX_SIZE = 100;
	private Book[] books = new Book[4];
	private int size = 0; // 현재 관리되는 Book 수
	
	// add
	public void add(Book book) {
		// size, MAX_SIZE 확인
		// 배열 books0에 추가, size도 증가
		if(size >= MAX_SIZE) {
			System.out.println("도서를 추가할 수 없습니다.");
			return;
		}
		books[size] = book;
		size++;
	}
	
	// getList
	public Book[] getList() {
		// Arrays.copyOfRange() api doc 참조 1줄이면 됨 
		return Arrays.copyOfRange(books, 0, size);
	}
	
	// search by isbn
	public Book searchByIsbn(String isbn) {
		// for문을 이용하여 배열을 순회하고 isbn이 같은 Book을 리턴
		Stream<Book> book = Arrays.stream(books);
		if(book.anyMatch( o -> o.getIsbn() == isbn)) {  // ★☆★☆★☆★☆ lambda 수정 ★☆★☆★☆★☆★☆★☆
			for(int i=0; i<size; i++) {
				if(books[i].getIsbn().equals(isbn)) return books[i];
			}
		}
		return null;
	}
	
	public void SearchByTitle(String title) {
		// ★☆★☆★☆★☆ lambda 수정 ★☆★☆★☆★☆★☆★☆
		Stream<Book> book = Arrays.stream(books).filter( o -> o.getTitle().contains(title) );
		print(book);
	}
	
	// ★☆★☆★☆★☆ lambda 추가 ★☆★☆★☆★☆★☆★☆
	@Override
	public void priceSorted() {
		Stream<Book> book = Arrays.stream(books).sorted( (o1, o2) -> o1.getPrice() - o2.getPrice() );
		print(book);
	}
	
	// ★☆★☆★☆★☆ lambda 추가 ★☆★☆★☆★☆★☆★☆
	@Override
	public void titleSorted() {
		Stream<Book> book = Arrays.stream(books).sorted( (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
		print(book);
	}
	
	
}
