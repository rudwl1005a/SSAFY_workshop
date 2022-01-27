package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputHandleTest {
	public static void main(String[] args) throws Exception {
		{
			Scanner sc = new Scanner(System.in);
			// intput : 1 2 3 4 5
//			int N = 5;
//			int[] intArray = new int[N];
//			
//			for(int i=0; i<N; i++) {
//				intArray[i] = sc.nextInt();
//			}
//			
//			// 출력
//			for(int n:intArray) {
//				System.out.print(n + " ");
//			}
			
			// input : a b c d e
			int C = 5;
			char[] charArray = new char[C];
			
			for(int i=0;i<C;i++) {
				charArray[i] = sc.next().charAt(0);
			}
			
			for(char c : charArray) {
				System.out.print(c + " ");
			}
			
			// input : abcde
			// 입력 문자의 수가 fixed
//			int C = 5;
//			char[] charArray = new char[C];
//			String input = sc.nextLine(); // "abcde"
//			
//			for(int i=0; i<C; i++) {
//				char ch = input.charAt(i);
//				charArray[i] = ch;
//			}
//			
//			// 출력
//			for(char c : charArray) {
//				System.out.print(c + " ");
//			}
			
//			// 입력 문자의 수가 가변
//			// 가변적인 길이 문자열을 문자 배열로
////			int C = 5;
////			char[] charArray = new char[C];
//			String input = sc.nextLine(); // "abcde....."
//			char[] charArray = input.toCharArray();
////			for(int i=0; i<C; i++) {
////				char ch = input.charAt(i);
////				charArray[i] = ch;
////			}
//			
//			// 출력
//			for(char c : charArray) {
//				System.out.print(c + " ");
//			}
//			/*
//			 2
//			 abcde
//			 */
//			int n = sc.nextInt();
//			String str = sc.next();
//			System.out.println(n);
//			System.out.println(str);
			
		}
		
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
//			// 1 2 3 4 5
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int N = 5;
//			int[] intArray = new int[N];
//			
//			for(int i=0; i<N; i++) {
//				intArray[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			for(int i : intArray) {
//				System.out.println(i + " ");
//			}
			
			// abcde
			String input = br.readLine();
			char[] charArray = input.toCharArray();
			
			for(char c : charArray) {
				System.out.println(c + "   ");
			}
		}
	}
}
