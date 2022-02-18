package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw )
 */
public class SW_03234_준환이의양팔저울_T2 {

	static int T, N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] choo = new int[N];
			boolean[] select = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			perm(0, 0, 0, choo, select);

			System.out.println("#" + t + " " + ans);
		}

	}
	
	// 파라미터 leftSum, rightSum 추가하자 -> 가지치기 위해
	static void perm(int tgtIdx, int leftSum, int rightSum, int[] choo, boolean[] select) {
		
		if (leftSum < rightSum) {
			return;
		}
		
		if (tgtIdx == choo.length) {
			ans++;
			return;
		}
		

		for (int i = 0; i < choo.length; i++) {
			if (select[i]) {
				continue;
			}

			select[i] = true;
			perm(tgtIdx + 1, leftSum + choo[i], rightSum, choo, select); // i번째 추 왼쪽에 담기
			perm(tgtIdx + 1, leftSum, rightSum + choo[i], choo, select); // i번째 추 오른쪽에 담기
			select[i] = false;
		}
	}

}
