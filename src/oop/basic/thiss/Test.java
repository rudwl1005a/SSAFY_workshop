package oop.basic.thiss;

public class Test {
	public static void main(String[] args) {
		MyClass mc1 = new MyClass(5, "hello");
		MyClass mc2 = new MyClass(10, "world");
		
		mc1.m();
		mc2.m();
	}
}
