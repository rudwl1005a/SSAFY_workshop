package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// ArrayDeque, StringBuilder로 develop
// 메모리: 85,428KB, 속도: 692ms
public class BJ_02493_탑_T_ArrayDeque {
	
	static int N;
	static ArrayDeque<int[]> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		// 탑 1개씩 처리, index=1부터
		for(int i=1; i<=N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			// 탑 1개 기준 이전에 담긴 탑들을 고려
			// 현재 탑보다 이전의 탑이 더 크다 -> 그 탑의 번호를 출력
			while(!stack.isEmpty()) {
				
				// 스택의 최근 탑이 나보다 크거나 같다.
				if(stack.peek()[1] >= height) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				
				// 나보다 작은 경우는 제거
				stack.pop();
				
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i, height});
		}
		
		System.out.println(sb);
		
	}
	
}
