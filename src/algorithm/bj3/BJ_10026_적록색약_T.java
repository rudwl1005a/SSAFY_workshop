package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/10026 )
 */
public class BJ_10026_적록색약_T {
	// DFS로 풀기

	static int N, cnt1, cnt2;
	static char[][] map;
	static boolean[][] visit, visit2;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		visit = new boolean[N][N];
		visit2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					cnt1++;
				}
				if (!visit2[i][j]) {
					dfs2(i, j);
					cnt2++;
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);

	}

	private static void dfs(int y, int x) {

		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != map[y][x]) {
				continue;
			}

			dfs(ny, nx);
		}
	}

	private static void dfs2(int y, int x) {

		visit2[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit2[ny][nx]) {
				continue;
			}

			// R, G 묶음 B 별도
			if((map[ny][nx] == 'R' || map[ny][nx] == 'G') && (map[y][x] == 'R' || map[y][x] == 'G')) {
				dfs2(ny, nx);
			} else if(map[ny][nx] == map[y][x]) {
				dfs2(ny, nx);
			}


		}

	}

}
