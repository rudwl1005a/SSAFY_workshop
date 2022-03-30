package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2636 )
 */
public class BJ_02636_치즈 {

	static int N, M, count, time, prev;
	static int[][] map;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					count++;
				}
			}
		}

		do {
			visit = new boolean[N][M];
			air(0, 0);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 || visit[i][j]) {
						continue;
					}
					dfs(i, j);
				}
			}
			time++;
		} while (melt());

		System.out.println(time);
		System.out.println(prev);

	}

	private static void air(int y, int x) {
		visit[y][x] = true;
		map[y][x] = 2;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || visit[ny][nx]) {
				continue;
			}

			visit[ny][nx] = true;
			map[ny][nx] = 2;
			air(ny, nx);
		}
	}

	private static void dfs(int y, int x) {

		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx]) {
				continue;
			}

			visit[ny][nx] = true;
			dfs(ny, nx);
		}

	}

	private static boolean melt() {

		int[][] temp = new int[N][M];
		copyMap(map, temp);
		prev = count;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (temp[y][x] != 1) {
					continue;
				}
				boolean isMelt = false;
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M || temp[ny][nx] != 2) {
						continue;
					}
					isMelt = true;
				}
				if (isMelt) {
					map[y][x] = 2;
					count--;
				}
			}
		}

		if (count == 0) {
			return false;
		}

		return true;
	}

	private static void copyMap(int[][] origin, int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = origin[i][j];
			}
		}
	}

}
