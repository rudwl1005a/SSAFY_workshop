package com.ssafy.hw0125.hw02;

import java.util.ArrayList;

public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public ArrayList<Book> getList();
	public Book searchByIsbn(String isbn);
	public ArrayList<Book> SearchByTitle(String title);
	public ArrayList<Book> getMagazines();
	public ArrayList<Book> getBooks();
	public int getTotalPrice();
	public double getPriceAvg();
	public Book sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	public Book buy(String isbn, int quantity) throws ISBNNotFoundException;
}
