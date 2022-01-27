package oop.override.equalshash;

public class Test {
	public static void main(String[] args) {
		Item item1 = new Item(7, "ssafy");
		Object item2 = new Object();
		// if item2 -> null 처리방법
					
		System.out.println( item1 == item2 );
		System.out.println( item1.equals(item2) );
	}
}
