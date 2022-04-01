package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G1 ( https://www.acmicpc.net/problem/2098 )
 */
public class BJ_02098_외판원순회 {

	static int N, ans;
	static int[][] map;
	static int[][] dp;
	static final int INF = 16000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}

		ans = dfs(0, 1);
		System.out.println(ans);
	}

	private static int dfs(int loc, int visit) {

		// 끝까지 찾아 갔을 때
		if (visit == (1 << N) - 1) {
			if (map[loc][0] == 0) {
				return INF;
			}
			return map[loc][0];
		}

		// 최소값 있을때
		if (dp[loc][visit] != INF) {
			return dp[loc][visit];
		}

		// 최소값 없다면
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) != 0 || map[loc][i] == 0) {
				continue;
			}

			dp[loc][visit] = Math.min(dp[loc][visit], map[loc][i] + dfs(i, visit | (1 << i)));
		}

		return dp[loc][visit];
	}

}
