package com.ssafy.ws08.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {
	/**
	 * 관리할 도서 리스트
	 */
	private List<Book> books; // = new ArrayList<Book>(); // 배열 대신 List유형의 컬렉션 사용
	
	/**
	 * 싱글톤 디자인패언 위해 유지하는 객체 참조값 
	 * 클래스 메로리에 로드시에 객체 1번 생성하여 참조값 유지
	 */
	private static IBookManager instance = new BookManagerImpl();
	/**
	 * 기본 생성자
	 */
	private BookManagerImpl() { // 외부에서 객체 생성을 하지 못하도록 접근 제어자를  private으로 만든 생성자
		loadData();
	}
	/**
	 * 내부에서 생성한 객체의 참조값을 반환한다.
	 * @return 생성된 객체의 참조값
	 */
	public static IBookManager getInstance() {
		return instance;
	}

	/**
	 * 도서를 도서리스트에 추가한다.
	 * @param book : 추가할 도서
	 */
	@Override
	public void add(Book book) {
		for(Book b : books) {
			if(b.getIsbn().equals(book.getIsbn())) {
				int old = b.getQuantity();
				int added = book.getQuantity();
				b.setQuantity(old+added);
				return;
			}
		}
		books.add(book);	// 리스트 마지막에 추가
	}
	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 * @param isbn : 삭제할 도서의 고유번호
	 */
	@Override
	public void remove(String isbn){
		final int size = books.size();	// 저장되어 있는 도서개수 확인
		for (int i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치를 이용하여 리스트에서 도서 삭제
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;  // 없으면 오류 발생
			}
		}
	}
	/**
	 * 등록된 도서리스트를 반환한다.
	 * @return 등록된 전체 도서리스트
	 */
	@Override
	public Book[] getList() {
		Book[] result = new Book[books.size()];	// 저장되어 있는 도서개수 만큼의 배열 생성
		return books.toArray(result);			// 컬렉션 내용을 배열로 복사 후 배열 리턴 
	}
	/**
	 * 고유번호로 해당 도서를 조회한다.
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
	 */
	@Override
	public Book searchByIsbn(String isbn) {		
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) return book;
		}
		return null;
	}
	/**
	 * 도서 제목을 포함하고 있는 도서리스트를 반환한다.
	 * @param title : 조회할 도서의 제목
	 * @return
	 */
	@Override
	public Book[] searchByTitle(String title) {
		// 제목을 포함하는 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getTitle().contains(title)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];  // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}
	/**
	 * 잡지리스트를 반환한다.
	 * @return 잡지리스트
	 */
	@Override
	public Magazine[] getMagazines() {
		// 잡지의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for (Book book : books) {
			if(book  instanceof Magazine) temp.add((Magazine)book);
		}		
		Magazine[] result = new Magazine[temp.size()];  // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 					// 컬랙션의 내용을 배열로 복사 후 리턴
	} 	
	/**
	 * 잡지가 아닌 도서리스트를 반환한다. 
	 * @return 잡지가 아닌 도서리스트
	 */
	@Override
	public Book[] getBooks() {
		// 일반 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(!(book  instanceof Magazine)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];	// 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}
	/**
	 * 도서리스트의 가격의 총합을 반환한다.
	 * @return 모든 도서 가격의 총합
	 */
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	/**
	 * 도서가격의 평균을 반환한다.
	 * @return 모든 도서 가격의 평균
	 */
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ books.size();
	}
	/**
	 * 고유번호에 해당하는 도서를 수량만큼 판매 처리하여 재고를 감소시킨다.
	 * @param isbn : 도서 고유번호
	 * @param quantity : 판매 수량
	 * @throws QuantityException : 재고 수량 부족의 예외 상황
	 * @throws ISBNNotFoundException : 고유번호에 해당하는 도서가 존재하지 않는 예외상황 
	 */
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book book = searchByIsbn(isbn);				// 고유번호 도서 조회
		if(book == null) throw new ISBNNotFoundException(isbn); // 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		
		int res = book.getQuantity() - quantity;	// 판매 후 새로운 재고 수량 계산
		if(res < 0) throw new QuantityException();	// 재고수량 부족시 QuantityException 사용자 정의 예외 발생시킴
		
		book.setQuantity(res); 						// 판매후 남은 재고수량으로 재고 수량 변경
	}
	/**
	 * 고유번호에 해당하는 도서를 수량만큼 구매 처리하여 재고를 증가시킨다.
	 * @param isbn : 도서 고유번호
	 * @param quantity : 구매 수량
	 * @throws ISBNNotFoundException : 고유번호에 해당하는 도서가 존재하지 않는 예외상황 
	 */
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = searchByIsbn(isbn);						// 고유번호 도서 조회
		if(book == null) throw new ISBNNotFoundException(isbn); // 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		
		book.setQuantity(book.getQuantity() + quantity);	// 구매 후의 새로운 재고 수량 계산하여 재고 수량 변경 
	}
	
	// loadData() <= 자기 자신이 호출 : 생성자에서 호출, File이 있으면 readObject, 없으면 ArrayList 생성
	// saveDate() <= BookTest에서 호출 : writeObject() 

	
	@Override
	public void saveData() {
		try(ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("book.dat"))) {
			out.writeObject(books);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadData() {
		File f = new File("book.dat");
		if(f.exists()) {
			try(ObjectInputStream in = new ObjectInputStream( new FileInputStream(f))) {
				books = (ArrayList<Book>) in.readObject(); // warning 무시해도 됨
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			books = new ArrayList<Book>();
		}
	}
	
//	public List<Book> loadData(){
//		try {
//			String dirName = "c:" + File.separator + "SSAFY" + File.separator + "BookManager";
//			FileInputStream file = new FileInputStream(dirName + File.separator + "book.dat");
//
//			ObjectInputStream ois = new ObjectInputStream(file);
//			books = (List<Book>) ois.readObject();
//			return books;		
//		} catch (Exception e) {
//			books = new ArrayList<Book>();
//			return books;
//		}
//	}
	
//	@Override
//	public void saveData(List<Book> books) {
//		// 폴더 생성
//		String dirName = "c:" + File.separator + "SSAFY" + File.separator + "BookManager";
//		File file1 = new File(dirName);
//		if(file1.exists()) {
//			System.out.println("폴더가 존재합니다.");
//		} else {
//			boolean success = file1.mkdir();
//			if( success ) {
//				System.out.println("폴더를 생성했습니다.");
//			}
//		}
//		
//		File file2 = new File(dirName, "book.dat");
//		
//		// 파일 생성
//		try {
//			FileOutputStream file = new FileOutputStream(file2);
//			ObjectOutputStream oos = new ObjectOutputStream(file);
//			oos.writeObject(books);
//			
//			oos.close();			
//		} catch (Exception e) {
//			System.out.println("exception");
//		}
//	}
}
