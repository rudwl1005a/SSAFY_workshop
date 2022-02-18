package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw )
 */
public class SW_03234_준환이의양팔저울_T {

	static int T, N, ans;
	static int[] choo;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			choo = new int[N];
			select = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			perm(0, 0, 0);

			System.out.println("#" + t + " " + ans);
		}

	}
	
	// 파라미터 leftSum, rightSum 추가하자 -> 가지치기 위해
	static void perm(int tgtIdx, int leftSum, int rightSum) {
		
		if (leftSum < rightSum) {
			return;
		}
		
		if (tgtIdx == N) {
			ans++;
			return;
		}
		

		for (int i = 0; i < N; i++) {
			if (select[i]) {
				continue;
			}

			select[i] = true;
			perm(tgtIdx + 1, leftSum + choo[i], rightSum); // i번째 추 왼쪽에 담기
			perm(tgtIdx + 1, leftSum, rightSum + choo[i]); // i번째 추 오른쪽에 담기
			select[i] = false;
		}
	}

}
