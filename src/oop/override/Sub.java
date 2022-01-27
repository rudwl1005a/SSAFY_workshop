package oop.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Sub extends Super {
	
	//@Override
	int m() {
		System.out.println("Sub - m");
		return 1;
	}
	
	// 상위 클래스만 안됨
	C m2() {
		System.out.println("Sub - m2");
		return new C();
	}
	
	// 접근 제한자 제한이 많은 것들은 가능
	protected void m3() {
		System.out.println("Sup - m3");
	}
	
	// 상위 클래스는 안되고, 하위 클래스는 가능
	void m4() throws FileNotFoundException {
		System.out.println("Sub - m4");
	}
}
