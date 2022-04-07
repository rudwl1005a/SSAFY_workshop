package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD )
 */
public class SW_01249_보급로 {

	static int T, N, ans;
	static int[][] map;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			bfs();

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void bfs() {
		visit = new boolean[N][N];
		PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
		ans = Integer.MAX_VALUE;

		q.offer(new Node(0, 0, 0));
		visit[0][0] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			visit[node.y][node.x] = true;

			if (node.y == N - 1 && node.x == N - 1) {
				ans = node.c;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || node.c + map[ny][nx] > ans) {
					continue;
				}

				visit[ny][nx] = true;
				q.offer(new Node(ny, nx, node.c + map[ny][nx]));
				visit[ny][nx] = false;
			}
		}

	}

	static class Node {
		int y, x, c;

		public Node(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}

	}

}
