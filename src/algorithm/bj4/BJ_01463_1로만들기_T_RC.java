package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1463 )
 */
public class BJ_01463_1로만들기_T_RC {
	// 시간초과지만 재귀 형태로 풀어보기

	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1]; // 0으로 초기화

		System.out.println(dp(N));
	}

	static int dp(int n) {

		// 기저조건
		if (n == 1) {
			return 0;
		}

		if (dp[n] > 0) { // 이미 최소값으로 계산되어 있으면 다시 계산하지 않는다
			return dp[n];
		}

		dp[n] = dp(n - 1) + 1;

		if (n % 2 == 0) {
			dp[n] = Math.min(dp[n], dp[n / 2] + 1);
		}
		if (n % 3 == 0) {
			dp[n] = Math.min(dp[n], dp[n / 3] + 1);
		}

		return dp[n];
	}

}
