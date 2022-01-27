package exception;

import java.io.FileNotFoundException;

public class A {
	public void m() {		
		B b = new B();
//		try {
			b.m2();
//		} catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
			
		// 이 밑에 코드는 실행하지 않는다
	}
}
