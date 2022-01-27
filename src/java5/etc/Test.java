package java5.etc;

public class Test {
	public static void main(String[] args) {
		
		// 1. for each
		int[] intArray = {1,2,3,4,5};
		
		for(int i : intArray) {
			
		}
		
		// 2. autoboxing unboxing
		// int a;
		// a ==> Integer (wrapper class)
		// Integer ai = new Integer(a); // 이 작업을 자동으로 해준다
		
		Integer i = new Integer(10); // i는 객체
		int u = i; // unboxing
		i = 20; // autoboxing
		
		mAuto('A'); // autoboxing
		Character c = new Character('B');
		uAuto(c); // unboxing
	}
	
	static void mAuto(Character c) {
		System.out.println(c);
	}
	
	static void uAuto(char c) {
		System.out.println(c);
	}
}
