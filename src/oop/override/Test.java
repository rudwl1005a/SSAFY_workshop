package oop.override;

public class Test {
	public static void main(String[] args) throws Exception {
//		Super s = new Sub(); // 반대로는 안됨 - 오류!
//		s.m();
//		s.m2();
//		s.m3();
//		s.m4();
		{
//			A a = new B();
//			a.a();	// A - a()
			// a.a(3) - 오류! why? A에는 파라미터를 가진 a(int i)가 없어서
		}
		{
//			B b = new C();
//			b.a(); // C - a()
//			b.a(5); // B - a(int i) 
		}
		{
//			A a = new C();
//			a.c(); // 오류
		}
		{
			B b = new D();
			b.a(); // C - a()
			b.a(5); // D - a(int i)
			b.b(); // D - b()
		}
		
	}
}
