package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw )
 */
public class SW_03234_준환이의양팔저울2 {

	static int ans, left;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] chu = new int[N];
			boolean[] select = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(chu);

			ans = 0;

			do { // 각각의 순열에서 체크
				for (int i = 1; i < N; i++) { // 왼쪽으로 i개 올리기, 0개 올리는 것은 항상 안된다
					left = i;
					divide(chu, select, 0, 0, 0, 0);
				}
				ans++; // 왼쪽으로 N개 올리는 경우의 수는 1개이다. -> 항상가능
			} while (np(chu));

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void divide(int[] chu, boolean[] select, int cnt, int lSum, int rSum, int leftCnt) {

		// 가지치기
		if (rSum > lSum) {
			return;
		}

		// 왼쪽으로 더 올리지 않을거라면 오른쪽 무게와 비교
		if (leftCnt == left) {
			int sum = 0; // 오른쪽 무게
			for (int i = 0; i < chu.length; i++) {
				if (select[i])
					continue;
				sum += chu[i];
			}
			if (lSum >= sum) {
				ans++;
			}
			return;
		}

		if (cnt == chu.length) {
			return;
		}

		// 왼쪽에 올릴거야
		select[cnt] = true;
		divide(chu, select, cnt + 1, lSum + chu[cnt], rSum, leftCnt + 1);

		// 오른쪽으로 올릴거야
		select[cnt] = false;
		divide(chu, select, cnt + 1, lSum, rSum + chu[cnt], leftCnt);

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
