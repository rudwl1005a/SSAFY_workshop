package basic;

public class PrintfTest {
	public static void main(String[] args) {
		String s1 = "Hello"; // 리터럴 최초 생성
		String s2 = "Hello"; // 리터럴 재사용
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		// 주소비교
		if(s1==s2) System.out.println("s1==s2");
		if(s3==s4) System.out.println("s3==s4");
		
		// 내용비교
		if(s1.equals(s2)) System.out.println("s1 equals s2");
		if(s3.equals(s4)) System.out.println("s3 equals s4");
		if(s1.equals(s3)) System.out.println("s1 equals s3");
		if(s4.equals(s2)) System.out.println("s4 equals s2");
		
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		if(mc1 == mc2) System.out.println("mc1 == mc2");
		if(mc1.equals(mc2)) System.out.println("mc1 equals mc2");
		
	}
	
	static class MyClass {
		String s = "Hello";
	}
}
