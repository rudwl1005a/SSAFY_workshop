package com.ssafy.hw0125.hw02;

public class QuantityException extends Exception {
	public QuantityException(String ISBN) {
		super(ISBN + "의 수량이 부족합니다.");
	}
}
