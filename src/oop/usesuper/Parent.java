package oop.usesuper;

public class Parent {
	int i = 20;
	
//	Parent(){
//		System.out.println("Parent()");
//	}
	
//	Parent(int i){
//		this.i = i;
//		System.out.println("Parent(int i)");
//	}
	
	void m() {
		System.out.println(this.i);
		
		m2();
	}
	
	void m2() {
		System.out.println("Parent - m2()");
	}
}
