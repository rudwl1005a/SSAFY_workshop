package java7.objects;

import java.util.Objects;

public class Test {
	public static void main(String[] args) {
		B b1 = new B();
		B b2 = null;
		
		m1(b1);
		m1(b2);
	}
	
	static void m1(B b) {
//		System.out.println(b.toString());
//		System.out.println(b == null ? "null" : b.toString());
		System.out.println(Objects.toString(b)); // 윗줄과 같은 효과 .toString(object, "null message")
	}
}
