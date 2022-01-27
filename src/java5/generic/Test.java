package java5.generic;

public class Test {
	public static void main(String[] args) {
		// String
		StringContainer sc = new StringContainer();
		sc.setElement("String");
		
		// A type
		// AContainer.. 담고자하는 type별로 컨테이너를 만들어야한다.. => object타입을 이용 => casting이슈.. 
		
		GenericContainer<String> gc = new GenericContainer<String>();
		gc.setElement("String");
		
		GenericContainer<MyClass> gc2 = new GenericContainer<Test.MyClass>();
	}
	
	static class MyClass{
		String name;
		int age;
	}
}
