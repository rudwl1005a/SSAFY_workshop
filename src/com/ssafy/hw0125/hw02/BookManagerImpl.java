package com.ssafy.hw0125.hw02;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	// 자료구조
	// Book 최대 100개 관리
	private static int MAX_SIZE = 100;
	private ArrayList<Book> books = new ArrayList<Book>(MAX_SIZE);
//	private Book[] books = new Book[MAX_SIZE];
	private int size = 0; // 현재 관리되는 Book 수
	
	// add
	public void add(Book book) {
		// size, MAX_SIZE 확인
		// 배열 books0에 추가, size도 증가
		if(size >= MAX_SIZE) {
			System.out.println("도서를 추가할 수 없습니다.");
			return;
		}
		books.add(book);
//		books[size] = book;
		size++;
	}
	
	// remove
	public void remove(String isbn) {
		// for문을 이용해서 배열을 순회, isbn이 같은 Book을 찾으면 그 자리에 맨 뒤에 Book으로 대체
		// 맨 뒤에 자리를 null, size도 감소
		for(int i=0; i< size; i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
//				books[i] = books[size-1];
//				books[size-1] = null;
				books.remove(i);
				size--;
				System.out.println("[" + isbn + "] 도서를 삭제하였습니다.");
				return;
			}
		}
		System.out.println("[" + isbn + "] 도서를 찾지 못했습니다.");
	}
	
	// getList
	public ArrayList<Book> getList() {
		// Arrays.copyOfRange() api doc 참조 1줄이면 됨
		return books;
//		return Arrays.copyOfRange(books, 0, size);
	}
	
	// search by isbn
	public Book searchByIsbn(String isbn) {
		// for문을 이용하여 배열을 순회하고 isbn이 같은 Book을 리턴
		for(int i=0; i<size; i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		return null;
	}
	
	/* 추가 */
	public ArrayList<Book> SearchByTitle(String title) {
		// for
		// 각 Book[i]의 title과 검색어 title 포함되면 리턴 대상
		// String class - contains() api확인
		// 배열을 만들어서 리턴 <= count <= for문 2번(몇개 포함?, 넣어주기)
		
		// 몇개 있는지 확인
		int count = 0;
		for(int i=0; i<size; i++) {
			if(books.get(i).getTitle().contains(title)) count++;
		}
		
		// 새로운 배열에 넣어주기
		ArrayList<Book> booksByTitle = new ArrayList<Book>(count);
//		int index = 0;
		for(int i=0; i<size; i++) {
			if(books.get(i).getTitle().contains(title)) {
//				booksByTitle[index++] = books[i];
				booksByTitle.add(books.get(i));
			}
		}
		return booksByTitle;
	}
	
	public ArrayList<Book> getMagazines() {
		// for
		// Book 제외, Magazine만 리턴
		// Magazine 갯수 구하는 for문 한개, 저장해줄 for문 한개
		// instanceOf 사용
		int count = 0;
		for( Book book : books) {
			if(book instanceof Magazine) count++;
		}
		
		int index = 0;
//		Magazine[] newMg = new Magazine[count];
		ArrayList<Book> newMg = new ArrayList<Book>(count);
		for( Book book : books ) {
//			if(book instanceof Magazine) newMg[index++] = (Magazine) book;
			if(book instanceof Magazine) newMg.add(book);
		}
		
		return newMg;
	}
	
	public ArrayList<Book> getBooks() {
		// for
		// Book만 리턴, Magazine제외
		// Book 갯수 구하는 for문 한개, 저장해줄 for문 한개
		// instanceOf 사용 -> 생각해볼 문제
		int count = 0;
		for( Book book : books) {
			if(book instanceof Book) {
				if(!(book instanceof Magazine)) count++;
			}
		}
		
		ArrayList<Book> newBooks = new ArrayList<Book>(count);
		for( Book book : books ) {
			if(book instanceof Book) {
				if(!(book instanceof Magazine)) newBooks.add(book);
			}
		}
		return newBooks;
	}
	
	public int getTotalPrice() {
		// for
		// sum return
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum = sum + books.get(i).getPrice();
		}
		return sum;
	}
	
	public double getPriceAvg() {
		// for
		// sum/size return
		double ave = (double) getTotalPrice()/size;
		return ave;
	}
	
	public Book sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		for(int i=0; i<size; i++) {
			if(books.get(i).getIsbn().equals(isbn) && books.get(i).getQuantity() >= quantity) {
				int remain = books.get(i).getQuantity() - quantity;
				books.get(i).setQuantity(remain);
				return books.get(i); 
			}
			else if(books.get(i).getIsbn().equals(isbn) && books.get(i).getQuantity() < quantity) {
				throw new QuantityException(isbn);
			}
		}
		throw new ISBNNotFoundException(isbn);
		
	}
	
	public Book buy(String isbn, int quantity) throws ISBNNotFoundException {
		for(int i=0; i<size; i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				int add = books.get(i).getQuantity() + quantity;
				books.get(i).setQuantity(add);
				return books.get(i);
			}
		}
		
		throw new ISBNNotFoundException(isbn);
	}
}
