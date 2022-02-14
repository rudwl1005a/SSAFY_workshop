package com.ssafy.hw0125.hw02;

class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException(String ISBN) {
		super(ISBN + "의 도서는 없습니다");
	}
}
