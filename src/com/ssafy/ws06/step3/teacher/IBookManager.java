package com.ssafy.ws06.step3.teacher;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	/**
	 * 도서를 도서리스트에 추가한다.
	 * @param book : 추가할 도서
	 */
	void add(Book book);
	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 * @param isbn : 삭제할 도서의 고유번호
	 */
	void remove(String isbn);
	/**
	 * 등록된 도서리스트를 반환한다.
	 * @return 등록된 전체 도서리스트
	 */
	Book[] getList();
	/**
	 * 고유번호로 해당 도서를 조회한다.
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
	 */
	Book searchByIsbn(String isbn);
	/**
	 * 도서 제목을 포함하고 있는 도서리스트를 반환한다.
	 * @param title : 조회할 도서의 제목
	 * @return
	 */
	Book[] searchByTitle(String title);
	/**
	 * 잡지리스트를 반환한다.
	 * @return 잡지리스트
	 */
	Magazine[] getMagazines();
	/**
	 * 잡지가 아닌 도서리스트를 반환한다. 
	 * @return 잡지가 아닌 도서리스트
	 */
	Book[] getBooks();
	/**
	 * 도서리스트의 가격의 총합을 반환한다.
	 * @return 모든 도서 가격의 총합
	 */
	int getTotalPrice();
	/**
	 * 도서가격의 평균을 반환한다.
	 * @return 모든 도서 가격의 평균
	 */
	double getPriceAvg();
}