package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2961 )
 */
public class BJ_02961_도영이가만든맛있는음식_T_Subset {
	// 부분집합

	static int N, min;
	static int[][] src;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		select = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;

		subset(0);

		System.out.println(min);

	}

	private static void subset(int srcIdx) {
		
		if(srcIdx == N) {
			//complete code
			int sin = 1;
			int ssn = 0;
			int cnt = 0; // 재료 사용 개수
			
			for (int i = 0; i < N; i++) {
				if(select[i]) {
					sin *= src[i][0];
					ssn += src[i][1];
					cnt++;
				}
			}
			
			if(cnt > 0) { // 재료 1개이상 쓴 경우만
				min = Math.min(min, Math.abs(sin - ssn));				
			}
			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
		
	}

}
