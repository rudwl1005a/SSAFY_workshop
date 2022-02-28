package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/4485 )
 */
public class BJ_04485_녹색입은애가젤다지 {

	static int N;
	static int[][] map;
	static int[][] minRupy; // 잃는 최소 루피
	static boolean[][] visit; // 방문 여부

	static PriorityQueue<Cave> pq = new PriorityQueue<Cave>((c1, c2) -> c1.rupy - c2.rupy);

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) { // 0이면 프로그램 종료
				break;
			}

			// 초기화
			map = new int[N][N];
			minRupy = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					minRupy[i][j] = Integer.MAX_VALUE;
				}
			}

			// Dijkstra
			pq.offer(new Cave(0, 0, map[0][0])); // 출발은 항상 0,0부터

			while (!pq.isEmpty()) {
				Cave cave = pq.poll();

				if (visit[cave.y][cave.x]) {
					continue;
				}

				visit[cave.y][cave.x] = true;

				for (int d = 0; d < 4; d++) {
					int ny = cave.y + dy[d];
					int nx = cave.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
						continue;
					}

					if (cave.rupy + map[ny][nx] < minRupy[ny][nx]) {
						minRupy[ny][nx] = cave.rupy + map[ny][nx];
						pq.offer(new Cave(ny, nx, minRupy[ny][nx]));
					}
				}
			}

			System.out.println("Problem " + (t++) + ": " + minRupy[N - 1][N - 1]);
		}
	}

	static class Cave {
		int y, x, rupy;

		public Cave(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.rupy = dist;
		}

	}

}
