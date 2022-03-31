package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1463 )
 */
public class BJ_01463_1로만들기 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[1] = 0;
		for (int i = 2; i < N + 1; i++) {
			int min = dp[i - 1] + 1;
			if (i % 2 == 0 && dp[i / 2] + 1 < min) {
				min = dp[i / 2] + 1;
			}
			if (i % 3 == 0 && dp[i / 3] + 1 < min) {
				min = dp[i / 3] + 1;
			}
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}

}
