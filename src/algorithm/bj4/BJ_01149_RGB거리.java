package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1149 )
 */
public class BJ_01149_RGB거리 {

	static int N, ans;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][3];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // red
			map[i][1] = Integer.parseInt(st.nextToken()); // green
			map[i][2] = Integer.parseInt(st.nextToken()); // blue
		}

		dp = new int[N + 1][3];
		dp[1][0] = map[1][0];
		dp[1][1] = map[1][1];
		dp[1][2] = map[1][2];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
		}

		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));

	}

}
