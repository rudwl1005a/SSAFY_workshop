package oop.basic.overload;

public class MyClass {
	//method
	void method() {
		System.out.println("method()");
	}
	
	void method(int n) {
		System.out.println("method(int n)");
	}
	
	void method(int n, String str) {
		System.out.println("method(int n, String str)");
	}
	// return type은 overloading 안된다.
	// method 이름 + parameter = method signature
	
	// three dot
	void method(int... args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}
	
	void method2(String... args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		if(args[2] != null) {
			System.out.println(args[2]);			
		}
	}
}
