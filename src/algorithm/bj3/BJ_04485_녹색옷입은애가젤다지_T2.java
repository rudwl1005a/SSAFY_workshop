package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/4485 )
 */
public class BJ_04485_녹색옷입은애가젤다지_T2 {

	static int N;
	static int[][] map;
//	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	static int[][] cost; // 핵심!
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			map = new int[N][N];
			cost = new int[N][N];
//			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}

			dijkstra();

			System.out.println("Problem " + t + ": " + cost[N - 1][N - 1]);
			t++;
		}
	}

	private static void dijkstra() {
		cost[0][0] = map[0][0]; // 시작 정점 비용
		pqueue.offer(new Edge(0, 0, cost[0][0]));

		while (!pqueue.isEmpty()) {
			Edge e = pqueue.poll();

//			if (visit[e.y][e.x]) {
//				continue;
//			}
//			visit[e.y][e.x] = true;

			// 해당 e로부터 갈 수 있는 정점은 사방 탐색으로 처리
			for (int d = 0; d < 4; d++) {
				int ny = e.y + dy[d];
				int nx = e.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					continue;
				}
				// cost 갱신 가능?
				if (e.c + map[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = e.c + map[ny][nx];
					pqueue.offer(new Edge(ny, nx, cost[ny][nx]));
				}
			}
		}
	}

	static class Edge {
		int y, x, c;

		public Edge(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
}
