package oop.inter;

public class Test {
	public static void main(String[] args) {
		{
//			Animal bird = new Bird(); // 부모클래스 타입
//			bird.howToFly() // 오류
//			bird.eyeCount // 가능
		}
		{
//			Fly bird = new Bird(); // 인터페이스 타입
//			bird.eyeCount; // 오류
//			bird.howToFly(); // 가능
			
			Fly flyobj = getInstance();
			flyobj.howFastFly();
		}
	}
	
	// 다른 팀에서 작성한 코드
	static Fly getInstance() {
//		return new AirPlane();
		return new Dove();
	}
}
