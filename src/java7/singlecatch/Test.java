package java7.singlecatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static void main(String[] args) /* 알고리즘 풀때는 : throws Exception */ {
		{ // before
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(System.in));			
				String s = br.readLine(); // Unhandled exception type IOException
				Class.forName("MyClass.class"); // 클래스를 메모리에 로드 // Unhandled exception type ClassNotFoundException
			} catch(IOException ie){
				ie.printStackTrace();
			} catch(ClassNotFoundException ce) {
				ce.printStackTrace();
			}			
		}
		
		{ // after : singlecatch
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(System.in));			
				String s = br.readLine(); // Unhandled exception type IOException
				Class.forName("MyClass.class"); // 클래스를 메모리에 로드 // Unhandled exception type ClassNotFoundException
			} catch(IOException | ClassNotFoundException e){ // 주의해야 할 부분 : 상속관계인 예외 같이 쓰면 컴파일 오류 ex) (Exception | ClassNotFoundException e)
				e.printStackTrace();
			}	
		}
		
		
	}
	
}
