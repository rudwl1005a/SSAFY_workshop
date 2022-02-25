package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/7576 )
 */
public class BJ_07576_토마토 {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Tomato> q = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new Tomato(i, j, 0));
					visit[i][j] = true;
				}
			}
		}

		bfs();

		boolean isChange = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					isChange = false;
				}
			}
		}

		System.out.println(isChange ? ans : -1);
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			Tomato to = q.poll();

			ans = Math.max(ans, to.day);

			for (int d = 0; d < 4; d++) {
				int ny = to.y + dy[d];
				int nx = to.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == -1) {
					continue;
				}

				visit[ny][nx] = true;
				map[ny][nx] = 1;
				q.offer(new Tomato(ny, nx, to.day + 1));
			}
		}

	}

	static class Tomato {
		int y, x, day;

		public Tomato(int y, int x, int day) {
			this.y = y;
			this.x = x;
			this.day = day;
		}

	}
}
