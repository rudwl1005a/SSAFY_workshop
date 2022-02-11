package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 실버5 (https://www.acmicpc.net/problem/1158)
 */
public class BJ_01158_요세푸스문제_T {
	
	static int N, K;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		int count = 0; // 죽은 사람이 생기면 하나씩 증가 => N이 되면 종료
		int idx = 0; // 배열의 인덱스
		int step = 1; // 살아있는 사람 만나면 증가
		
		// 죽으면 그 자리를 0으로 바꿈
		sb.append("<");
		while(true) {
			if(count == N) break;
			
			if(input[idx%N] != 0) { // 살아있으면
				if((step%K) == 0) { // 죽을 대상
					sb.append(input[idx%N]).append(", ");
					input[idx%N] = 0;
					count++;
				}
				step++;
			}
			idx++;
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
