package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 실버5 (https://www.acmicpc.net/problem/1158)
 */
// ArrayList로도 풀어보기 -> 실행시간 낮아짐
public class BJ_01158_요세푸스문제 {
	
	static int N, K, count;
	static boolean[] num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new boolean[N+1];
		sb.append("<");
		int i = 1; // 제거된사람, 제거 안된사람 만났을 때 증가
		int j = 1; // 제거되지 않은 사람 만났을 때만 증가
		while(count != N) {
			if(!num[i%N]) { // 제거되지 않았으면
				if(j%K == 0) { // 제거되지 않은 사람중 K번째 일때
					num[i%N] = true;
					count++;
					if(i%N == 0) sb.append(N).append(", ");
					else sb.append(i%N).append(", ");
				}
				j++;
			}
			i++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
