package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1600 )
 */
public class BJ_01600_말이되고픈원숭이 {

	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visit;

	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2, 1, 0, -1, 0, }; // 말 이동, 오른쪽위부터 시계방향 + 하 우 상 좌
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1, 0, 1, 0, -1, };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 세로
		map = new int[H][W];
		visit = new boolean[K + 1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = -1;
		bfs();

		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		visit[K][0][0] = true;
		q.offer(new Node(0, 0, 0, K));

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.y == H - 1 && n.x == W - 1) {
				ans = n.level;
				return;
			}

			for (int d = 0; d < dy.length; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];

				if (d < 8 && n.k < 1) { // 말처럼 이동 못함
					continue;
				}

				// 말 처럼 이동 할 수 있는 경우
				if (d < 8) {
					if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[n.k - 1][ny][nx]) {
						continue;
					}
					visit[n.k - 1][ny][nx] = true;
					q.offer(new Node(ny, nx, n.level + 1, n.k - 1));
					continue;
				} else { // 원숭이 이동
					if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[n.k][ny][nx]) {
						continue;
					}

					visit[n.k][ny][nx] = true;
					q.offer(new Node(ny, nx, n.level + 1, n.k));
				}
			}
		}

	}

	static class Node {
		int y, x, level, k; // level : 깊이, k : 말 이동수

		public Node(int y, int x, int level, int k) {
			this.y = y;
			this.x = x;
			this.level = level;
			this.k = k;
		}
	}
}
