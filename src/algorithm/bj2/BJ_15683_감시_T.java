package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/15683 )
 */
public class BJ_15683_감시_T {

	static int N, M, min, ans;
	static int[][] map;
	static ArrayList<Cam> list = new ArrayList<>();

	static int[] dy = { -1, 0, 1, 0 }; // 상 좌 하 우
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n >= 1 && n <= 5) {
					list.add(new Cam(i, j, n));
				}
			}
		}

		min = Integer.MAX_VALUE;

		dfs(0, map); // 첫번째 Cam사용, 최초의 map 전달
		
		System.out.println(min);

	}

	private static void dfs(int idx, int[][] parent) {

		// 기저조건 : 모든 캠의 비추는 상태를 반영한 parent
		if (idx == list.size()) {
			// complete code
			// parent에서 사각지대(0) 계산 -> min 비교 처리
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(parent[i][j] == 0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		}

		Cam c = list.get(idx);

		switch (c.n) {
		case 1: // 캠의 현재 y,x 에서 한 방향 x 4
			for (int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				dfs(idx + 1, child);
			}
			break;
		case 2: // 캠의 현재 y,x 에서 두 방향으로 x 2 (수평)
			for (int d = 0; d < 2; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				watch(c.y, c.x, d + 2, child);
				dfs(idx + 1, child);
			}
			break;
		case 3: // 캠의 현재 y,x 에서 두 방향으로 x 4 (직각)
			for (int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				watch(c.y, c.x, (d + 1) % 4, child);
				dfs(idx + 1, child);
			}
			break;
		case 4: // 캠의 현재 y,x 에서 세 방향으로 x 4
			for (int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				watch(c.y, c.x, (d + 1) % 4, child);
				watch(c.y, c.x, (d + 2) % 4, child);
				dfs(idx + 1, child);
			}
			break;
		case 5: // 캠의 현재 y,x 에서 네 방향으로 x 1
			int[][] child = copyMap(parent);
			// 비추는 작업
			watch(c.y, c.x, 0, child);
			watch(c.y, c.x, 1, child);
			watch(c.y, c.x, 2, child);
			watch(c.y, c.x, 3, child);
			dfs(idx + 1, child);
			break;
		}
	}

	static void watch(int y, int x, int dir, int[][] array) {
		// 좌 - 상 - 우 - 하
		switch (dir) {
		case 0: // 좌
			for (int i = x; i >= 0; i--) {
				if (array[y][i] == 6) {
					break;
				}
				array[y][i] = 9;
			}
			break;
		case 1: // 상
			for (int i = y; i >= 0; i--) {
				if (array[i][x] == 6) {
					break;
				}
				array[i][x] = 9;
			}
			break;
		case 2: // 우
			for (int i = x; i < N; i++) {
				if (array[y][i] == 6) {
					break;
				}
				array[y][i] = 9;
			}
			break;
		case 3: // 하
			for (int i = y; i < N; i++) {
				if (array[i][x] == 6) {
					break;
				}
				array[i][x] = 9;
			}
			break;
		}
	}

	static int[][] copyMap(int[][] origin) {

		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = origin[i][j];
			}
		}

		return copy;

	}

	static class Cam {
		int y, x, n;

		public Cam(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}

	}
}
