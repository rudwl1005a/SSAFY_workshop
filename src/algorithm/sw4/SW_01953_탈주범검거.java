package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq )
 */
public class SW_01953_탈주범검거 {

	static int T, N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로
			M = Integer.parseInt(st.nextToken()); // 세로
			R = Integer.parseInt(st.nextToken()); // 맨홀 y좌표
			C = Integer.parseInt(st.nextToken()); // 맨홀 x좌표
			L = Integer.parseInt(st.nextToken()); // 도주시간

			map = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			bfs();
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(R, C, L));
		visit[R][C] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.t == 0) {
				break;
			}

			ans++;

			// 1: 상하좌우, 2: 상하, 3: 좌우, 4: 상우, 5: 하우, 6: 하좌, 7: 상좌
			//    0123        01      23      03      13      12     02
			int type = map[node.y][node.x];
			switch (type) {
			case 1:
				for (int d = 0; d < 4; d++) { // 0123
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			case 2:
				for (int d = 0; d < 2; d++) { // 01
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			case 3:
				for (int d = 2; d < 4; d++) {// 23
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			case 4:
				for (int d = 0; d < 4; d += 3) { // 03
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			case 5:
				for (int d = 1; d < 4; d += 2) { // 13
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			case 6:
				for (int d = 1; d < 3; d++) { // 12
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					
					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			case 7:
				for (int d = 0; d < 4; d += 2) { // 02
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (able(ny, nx, d)) {
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx, node.t - 1));
					}
				}
				break;
			}
		}
	}

	private static boolean able(int ny, int nx, int d) {
		if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) {
			return false;
		}
		// 상 : 1,2,5,6 / 하 : 1,2,4,7 / 좌 : 1,3,4,5 / 우 : 1,3,6,7
		if(d == 0) {
			if(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7) {
				return false;
			}
		} else if(d == 1) {
			if(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6) {
				return false;
			}
		} else if(d == 2) {
			if(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7) {
				return false;
			}
		} else if(d == 3) {
			if(map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5) {
				return false;
			}
		}
		return true;
	}

	static class Node {
		int y, x, t;

		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
}
