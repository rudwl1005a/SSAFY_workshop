package java7.etc;

public class Test {
	public static void main(String[] args) {
		// string with Switch
		String str ="가나다";
		switch(str) {
		case "ABC" : System.out.println("영문"); break;
		case "가나다" : System.out.println("한글"); break;
		}
		
		// 숫자 인식
		int koreaMoney = 100_000_000;
		long cardNo = 1124_2342_3123_4568L;
	}
}
