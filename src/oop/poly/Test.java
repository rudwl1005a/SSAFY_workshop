package oop.poly;

public class Test {
	public static void main(String[] args) {
		C a = new C();
		m(a);
		
		B b = new B();
		m(b);
		
		D d = new D();
		m(d);
		
		B bd = new D();
		m(bd);
	}
	
	static void m(A a) {
		System.out.println("A - m()");
	}
	
	static void m(C c) {
		System.out.println("C - m()");
	}
	
	static void m2(A a) {
		if( a instanceof C ) System.out.println("C 객체");
		else if( a instanceof B ) System.out.println("B 객체");
		else if( a instanceof A) System.out.println("A 객체");
	}
}
