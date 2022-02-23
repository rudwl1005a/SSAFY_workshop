package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/10026 )
 */
public class BJ_10026_적록색약2 {
	// DFS로 풀기

	static int N, ans1, ans2;
	static char[][] map;
	static boolean[][] visit;

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

		// 정상인 사람
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					continue;
				}
				dfsNormal(i, j);
				ans1++;
			}
		}

		// 색약인 사람
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					continue;
				}
				dfsCB(i, j, map[i][j]);
				ans2++;
			}
		}

		System.out.println(ans1 + " " + ans2);

	}

	private static void dfsCB(int y, int x, char c) {

		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
				continue;
			}

			if (c == 'B') {
				if (map[y][x] != map[ny][nx]) {
					continue;
				}
			} else {
				if (map[ny][nx] == 'B') {
					continue;
				}
			}

			dfsCB(ny, nx, c);

		}

	}

	private static void dfsNormal(int y, int x) {

		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != map[y][x]) {
				continue;
			}

			dfsNormal(ny, nx);
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
