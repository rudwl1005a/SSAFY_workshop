package oop.basic.classobject;

public class Test {
	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.n = 3;
		mc.str = "hello";
		
		System.out.println(mc.n);
		System.out.println(mc.str);
		
		mc.setN(5);
		System.out.println(mc.n);
		System.out.println(mc.getN());
		
		AnotherClass ac = new AnotherClass();
		System.out.println(ac.n);
		
		MoreClass more = new MoreClass();
//		more.ac = new AnotherClass();
//		System.out.println(more.ac); // 객체의 주소
//		System.out.println(more.ac.n); // 객체의 값

		more.mc = new MyClass();
		more.mc.setN(100);
		System.out.println(more.mc.getN());
	}
}
