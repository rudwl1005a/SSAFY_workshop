package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1600 )
 */
public class BJ_01600_말이되고픈원숭이_T {

	static int K, W, H;
	static int[][] map;

	static boolean[][][] visit; // y, x, k(말이동회수)

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int[] hdy = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hdx = { 1, -1, 2, -2, 2, -2, 1, -1 };

	static Queue<Node> queue = new ArrayDeque<Node>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visit = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue.offer(new Node(0, 0, 0, K));
		bfs();
	}

	static void bfs() {

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			// 목표 도달
			if (node.y == H - 1 && node.x == W - 1) {
				System.out.println(node.d);
				return;
			}

			// 탐색 #1 - 상하좌우
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k])
					continue;
				visit[ny][nx][node.k] = true;
				queue.offer(new Node(ny, nx, node.d + 1, node.k)); // k는 그대로, d는 1 증가
			}

			if (node.k == 0)
				continue;

			// 탐색 #2 - 말 8방
			for (int d = 0; d < 8; d++) {
				int ny = node.y + hdy[d];
				int nx = node.x + hdx[d];
				// k를 1회 사용했다.
				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1])
					continue;
				visit[ny][nx][node.k - 1] = true;
				queue.offer(new Node(ny, nx, node.d + 1, node.k - 1)); // k는 -1, d는 1 증가
			}
		}

		System.out.println("-1");
	}

	static class Node {
		int y, x, d, k;

		public Node(int y, int x, int d, int k) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}
}
