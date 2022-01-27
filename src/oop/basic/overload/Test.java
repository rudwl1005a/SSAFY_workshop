package oop.basic.overload;

public class Test {
	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.method();
		mc.method(5);
		mc.method(3, "hello");
		
		mc.method(1,2,3,4);
		mc.method2("hello","world","ssafy");
	}
}
