package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw )
 */
public class SW_03234_준환이의양팔저울 {

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] chu = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(chu);
			
			ans = 0;

			do { // 각각의 순열에서 체크
				divide(chu, 0, 0, 0);
			} while (np(chu));

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void divide(int[] chu, int cnt, int lSum, int rSum) {

		// 가지치기
		if (rSum > lSum) {
			return;
		}

		if (cnt == chu.length) {
			// 계산
			if(lSum >= rSum) {
				ans++;
			}
			return;
		}

		divide(chu, cnt + 1, lSum + chu[cnt], rSum);
		divide(chu, cnt + 1, lSum, rSum + chu[cnt]);

	}

	private static boolean np(int[] chu) {

		int i = chu.length - 1;
		while (i > 0 && chu[i - 1] >= chu[i]) {
			--i;
		}

		if (i == 0) {
			return false; // 더이상 순열을 만들 수 없다
		}

		int j = chu.length - 1;
		while (chu[i - 1] >= chu[j]) {
			--j;
		}

		swap(i - 1, j, chu);

		int k = chu.length - 1;
		while (i < k) {
			swap(i++, k--, chu);
		}

		// 순열 생성
		return true;
	}

	private static void swap(int i, int j, int[] chu) {
		int temp = chu[i];
		chu[i] = chu[j];
		chu[j] = temp;
	}

}
