package com.ssafy.hw0125.hw02;

public class Magazine extends Book {
	// year, month 멤버변수 getter, setter
	// toString()
	private int year;
	private int month;
	
	// Encapsulation
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	// toString
	@Override
	public String toString() {
		return "Magazine [getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle()
				+ ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice()
				+ ", getDesc()=" + getDesc() + ", getQuantity()=" + getQuantity() + ", year= " + year + ", month=" + month + "]";
	}
	
	// 생성자
	public Magazine() {
		super();
	}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity, int year, int month) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}
	
	
}
