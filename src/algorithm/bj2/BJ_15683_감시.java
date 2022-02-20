package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/15683 )
 */
public class BJ_15683_감시 {

	static int N, M, min;
	static int[][] map;
	static ArrayList<Cctv> cctv = new ArrayList<>();

	static class Cctv {
		int y, x, num; // 좌표, cctv번호

		public Cctv(int y, int x, int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) { // cctv라면 정보 저장
					cctv.add(new Cctv(i, j, map[i][j]));
				}
			}
		}

		dfs(0, map);

		System.out.println(min);

	}

	private static void dfs(int cnt, int[][] temp) {

		if (cnt == cctv.size()) {
			int ans = 0;

			// 사각지대(0) 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0)
						ans++;
				}
			}

			min = Math.min(min, ans);

			return;
		}

		Cctv c = cctv.get(cnt);

		if (c.num == 1) {
			for (int d = 0; d < 4; d++) { // d 0,1,2,3
				int[][] copy = copyMap(temp);
				makePath(c.y, c.x, d, copy);
				dfs(cnt + 1, copy);
			}
		} else if (c.num == 2) {
			for (int d = 0; d < 2; d++) { // d 02, 13
				int[][] copy = copyMap(temp);
				makePath(c.y, c.x, d, copy);
				makePath(c.y, c.x, d + 2, copy);
				dfs(cnt + 1, copy);
			}
		} else if (c.num == 3) {
			for (int d = 0; d < 4; d++) { // d 01, 12, 23, 30
				int[][] copy = copyMap(temp);
				makePath(c.y, c.x, d, copy);
				makePath(c.y, c.x, (d + 1) % 4, copy);
				dfs(cnt + 1, copy);
			}
		} else if (c.num == 4) {
			for (int d = 0; d < 4; d++) { // d 012, 123, 230, 301
				int[][] copy = copyMap(temp);
				makePath(c.y, c.x, d, copy);
				makePath(c.y, c.x, (d + 1) % 4, copy);
				makePath(c.y, c.x, (d + 2) % 4, copy);
				dfs(cnt + 1, copy);
			}
		} else if (c.num == 5) { // d 0123
			int[][] copy = copyMap(temp);
			for (int d = 0; d < 4; d++) {
				makePath(c.y, c.x, d, copy);
			}
			dfs(cnt + 1, copy);
		}

	}

	private static void makePath(int y, int x, int d, int[][] copy) {

		if (d == 0) { // 상
			for (int i = y; i >= 0; i--) {
				if (copy[i][x] == 6) {
					break;
				}
				copy[i][x] = 7;
			}
		} else if (d == 1) { // 우
			for (int i = x; i < M; i++) {
				if (copy[y][i] == 6) {
					break;
				}
				copy[y][i] = 7;
			}
		} else if (d == 2) { // 하
			for (int i = y; i < N; i++) {
				if (copy[i][x] == 6) {
					break;
				}
				copy[i][x] = 7;
			}
		} else if (d == 3) { // 좌
			for (int i = x; i >= 0; i--) {
				if (copy[y][i] == 6) {
					break;
				}
				copy[y][i] = 7;
			}
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

}
