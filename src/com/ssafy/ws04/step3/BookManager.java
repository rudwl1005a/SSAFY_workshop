package com.ssafy.ws04.step3;

import java.util.Arrays;

public class BookManager {
	// 자료구조
	// Book 최대 100개 관리
	private static int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size; // 현재 관리되는 Book 수
	
	// add
	public void add(Book book) {
		// size, MAX_SIZE 확인
		// 배열 books0에 추가, size도 증가
		if(this.size >= MAX_SIZE) {
			System.out.println("도서를 추가할 수 없습니다.");
			return;
		}
		this.books[this.size] = book;
		this.size++;
	}
	
	// remove
	public void remove(String isbn) {
		// for문을 이용해서 배열을 순회, isbn이 같은 Book을 찾으면 그 자리에 맨 뒤에 Book으로 대체
		// 맨 뒤에 자리를 null, size도 감소
		for(int i=0; i< this.size; i++) {
			if(this.books[i].getIsbn().equals(isbn)) {
				this.books[i] = this.books[this.size-1];
				this.books[this.size-1] = null;
				this.size--;
				System.out.println("[" + isbn + "] 도서를 삭제하였습니다.");
				return;
			}
		}
		System.out.println("[" + isbn + "] 도서를 찾지 못했습니다.");
	}
	
	// getList
	public Book[] getList() {
		// Arrays.copyOfRange() api doc 참조 1줄이면 됨 
		return Arrays.copyOfRange(this.books, 0, this.size);
	}
	
	// search by isbn
	public Book searchByIsbn(String isbn) {
		// for문을 이용하여 배열을 순회하고 isbn이 같은 Book을 리턴
//		boolean isFound = false;
//		Book book = new Book();
//		for(int i=0; i<this.size; i++) {
//			if(this.books[i].getIsbn().equals(isbn)) {
//				book = this.books[i];
//				isFound = true;
//			}
//		}
//		if(!isFound) {
//			System.out.println("[" + isbn + "] 도서를 찾지 못했습니다.");
//		}
//		return book;
		for(int i=0; i<this.size; i++) {
			if(this.books[i].getIsbn().equals(isbn)) {
				return this.books[i];
			}
		}
		return null;
	}
}
