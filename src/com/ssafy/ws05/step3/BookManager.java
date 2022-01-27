package com.ssafy.ws05.step3;

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
		for(int i=0; i<this.size; i++) {
			if(this.books[i].getIsbn().equals(isbn)) {
				return this.books[i];
			}
		}
		return null;
	}
	
	/* 추가 */
	public Book[] SearchByTitle(String title) {
		// for
		// 각 Book[i]의 title과 검색어 title 포함되면 리턴 대상
		// String class - contains() api확인
		// 배열을 만들어서 리턴 <= count <= for문 2번(몇개 포함?, 넣어주기)
		
		// 몇개 있는지 확인
		int count = 0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) count++;
		}
		
		// 새로운 배열에 넣어주기
		Book[] booksByTitle = new Book[count];
		int index = 0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				booksByTitle[index++] = books[i];
			}
		}
		return booksByTitle;
	}
	
	public Magazine[] getMagazines() {
		// for
		// Book 제외, Magazine만 리턴
		// Magazine 갯수 구하는 for문 한개, 저장해줄 for문 한개
		// instanceOf 사용
		int count = 0;
		for( Book book : this.books) {
			if(book instanceof Magazine) count++;
		}
		
		int index = 0;
		Magazine[] newMg = new Magazine[count];
		for( Book book : this.books ) {
			if(book instanceof Magazine) newMg[index++] = (Magazine) book;
		}
		
		return newMg;
	}
	
	public Book[] getBooks() {
		// for
		// Book만 리턴, Magazine제외
		// Book 갯수 구하는 for문 한개, 저장해줄 for문 한개
		// instanceOf 사용 -> 생각해볼 문제
		int count = 0;
		for( Book book : this.books) {
			if(book instanceof Book) {
				if(!(book instanceof Magazine)) count++;
			}
		}
		
		int index = 0;
		Book[] newBooks = new Book[count];
		for( Book book : this.books ) {
			if(book instanceof Book) {
				if(!(book instanceof Magazine)) newBooks[index++] = book;
			}
		}
		return newBooks;
	}
	
	public int getTotalPrice() {
		// for
		// sum return
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum = sum + this.books[i].getPrice();
		}
		return sum;
	}
	
	public double getPriceAvg() {
		// for
		// sum/size return
		double ave = (double) this.getTotalPrice()/size;
		return ave;
	}
}
