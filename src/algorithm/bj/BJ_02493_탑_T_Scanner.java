package algorithm.bj;

import java.util.Scanner;
import java.util.Stack;

// Scanner 사용하면 메모리 초과
public class BJ_02493_탑_T_Scanner {
	
	static int N;
	static Stack<int[]> stack = new Stack<>(); // int[0]:번호, int[1]:높이
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 탑 1개씩 처리, index=1부터
		for(int i=1; i<=N; i++) {
			int height = sc.nextInt();
			
			// 탑 1개 기준 이전에 담긴 탑들을 고려
			// 현재 탑보다 이전의 탑이 더 크다 -> 그 탑의 번호를 출력
			while(!stack.isEmpty()) {
				
				// 스택의 최근 탑이 나보다 크거나 같다.
				if(stack.peek()[1] >= height) {
					System.out.print(stack.peek()[0]+ " ");
					break;
				}
				
				// 나보다 작은 경우는 제거
				stack.pop();
				
			}
			
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			
			stack.push(new int[] {i, height});
		}
		
		sc.close();
	}
	
}
