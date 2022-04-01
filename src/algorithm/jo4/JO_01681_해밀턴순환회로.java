package algorithm.jo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954 )
 */
public class JO_01681_해밀턴순환회로 {

	static int N, ans;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;
		dfs(0, 0, 1);
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}

	private static void dfs(int loc, int dis, int visit) {

		if (dis > ans) {
			return;
		}

		boolean isFoundAll = true;
		for (int i = 0; i < N; i++) {
			if ((visit & 1 << i) == 0) {
				isFoundAll = false;
			}
		}
		if (isFoundAll) {
			if (map[loc][0] != 0) {
				dis += map[loc][0];
				ans = Math.min(ans, dis);
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if ((visit & 1 << i) != 0 || map[loc][i] == 0) {
				continue;
			}

			dfs(i, dis + map[loc][i], visit | 1 << i);
		}
	}

}
