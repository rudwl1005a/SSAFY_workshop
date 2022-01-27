package oop.basic.thiss;

public class MyClass {
	int n;
	String str;
	
//	MyClass(int n, String str){
//		this.n = n;
//		this.str = str;
//	}
	
	void m(){
		System.out.println(this.n);
	}
	
	// this() this생성자
	MyClass(int n){
		this.n = n;
	}
	
	MyClass(int n, String str){
		this(n);
		this.str = str;
	}
}
