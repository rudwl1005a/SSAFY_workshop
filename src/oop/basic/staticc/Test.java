package oop.basic.staticc;

public class Test {
	public static void main(String[] args) {
		// static은 바로 사용 가능
		System.out.println(MyClass.COUNT);
		MyClass.staticMethod();
		
		MyClass mc = new MyClass();
		System.out.println(mc.num);
		System.out.println(mc.COUNT); // static warning
		mc.method();
	}
	
	static {
		System.out.println("main static block!!");
	}
}
