package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D5 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD )
 */
public class SW_01247_최적경로_TSP {

	static int T, N, homeX, homeY, min;
	static int[][] node, dp;
	static int INF = 2001; // 최대거리*고객의수보다 1큰 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 초기화
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());

			node = new int[N + 1][2]; // 맨앞 회사

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 회사 좌표
			node[0][0] = Integer.parseInt(st.nextToken());
			node[0][1] = Integer.parseInt(st.nextToken());
			// 집 좌표
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				node[i][0] = Integer.parseInt(st.nextToken());
				node[i][1] = Integer.parseInt(st.nextToken());
			}

			dp = new int[N + 1][(1 << N + 1) - 1];
			for (int i = 0; i < N + 1; i++) {
				Arrays.fill(dp[i], INF);
			}

			min = dfs(0, 1);

			System.out.println("#" + t + " " + min);
		}
	}

	private static int dfs(int c, int mask) {

		// 기저조건
		if (mask == (1 << N + 1) - 1) {
			// 못가는 경우는 없다.
			return distance(homeY, homeX, node[c][0], node[c][1]);
		}

		if (dp[c][mask] != INF) {
			return dp[c][mask];
		}

		for (int i = 1; i <= N; i++) {
			if ((mask & 1 << i) != 0) {
				continue;
			}

			dp[c][mask] = Math.min(dp[c][mask], distance(node[c][0], node[c][1], node[i][0], node[i][1]) + dfs(i, mask | 1 << i));
		}
		
		return dp[c][mask];
	}

	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}

}
