package oop.usesuper;

public class Test {
	public static void main(String[] args) {
		Parent p = new Child();
		
		p.m();
		
		// super로 불러온 메서드는 오버라이드 안된다.
	}
}
