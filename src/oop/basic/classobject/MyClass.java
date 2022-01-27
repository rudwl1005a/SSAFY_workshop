package oop.basic.classobject;

public class MyClass {
	
	// member variable
	int n;
	String str;
	
	// method
	void m1() {
		System.out.println("m1()호출");
	}
	
	// method - setter & getter
	int getN() {
		return this.n;
	}
	
	String getStr() {
		return this.str;
	}
	
	void setN(int n) {
		this.n = n;
	}
	void setStr(String tr) {
		this.str = tr;
	}
}

// public class는 파일당 한개
/* public */ class AnotherClass {
	int n;
}

class MoreClass extends AnotherClass {
//	AnotherClass ac; // isA 관계
	MyClass mc; // hasA 관계
	
}
