package oop.basic.staticc;

public class MyClass {
	static int COUNT = 10;
	int num = 20;
	
	void method() {
		System.out.println("method()");
	}
	
	static void staticMethod() {
		System.out.println("staticMethod()");
	}
	
	// static block
	static {
		System.out.println("static block!!");
	}
}
