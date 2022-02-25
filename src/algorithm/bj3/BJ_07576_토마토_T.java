package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/7576 )
 */
public class BJ_07576_토마토_T {

	static int N, M, max;
	static int[][] map;
	static Queue<Node> q = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new Node(i, j, 0));
				}
			}
		}

		// BFS
		while (!q.isEmpty()) {
			Node n = q.poll();

			int y = n.y;
			int x = n.x;

			max = Math.max(max, n.d);

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
					continue;
				}

				if (map[ny][nx] == 0) {
					map[ny][nx] = map[y][x] + 1;
					q.offer(new Node(ny, nx, n.d + 1));
				}

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(max);
	}

	static class Node {
		int y, x, d; // d: depth

		public Node(int y, int x, int day) {
			this.y = y;
			this.x = x;
			this.d = day;
		}

	}
}
