package com.ssafy.hw0126.hw02;

public interface IBookManager {
	public void add(Book book);
	public Book[] getList();
	public Book searchByIsbn(String isbn);
	public void SearchByTitle(String title);
	public void priceSorted();
	public void titleSorted();
}
