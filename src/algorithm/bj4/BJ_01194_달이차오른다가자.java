package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G1 ( https://www.acmicpc.net/problem/1194 )
 */
public class BJ_01194_달이차오른다가자 {

	static int N, M, sy, sx, ans;
	static char[][] map;
	static boolean[][][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		visit = new boolean[N][M][64]; // 3차원 : a,b,c,d,e,f 열쇠 무슨 종류를 가지고 있는지 확인

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					sy = i;
					sx = j;
				}
			}
		}

		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sy, sx, 0, 0));
		visit[sy][sx][0] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (map[node.y][node.x] == '1') {
				ans = Math.min(ans, node.step);
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx][node.key] || map[ny][nx] == '#') {
					continue;
				}

				// 키일 경우
				if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
					int n = (int) (map[ny][nx] - 'a');
					int key = node.key | 1 << n;
					visit[ny][nx][node.key] = true;
					q.offer(new Node(ny, nx, key, node.step + 1));
					continue;
				}

				// 문일 경우
				if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
					int n = (int) (map[ny][nx] - 'A');
					if ((node.key & 1 << n) != 0) { // 문과 같은 key가 있을 경우
						visit[ny][nx][node.key] = true;
						q.offer(new Node(ny, nx, node.key, node.step + 1));
					}
					continue;
				}

				// 빈칸이거나 출구일 경우
				visit[ny][nx][node.key] = true;
				q.offer(new Node(ny, nx, node.key, node.step + 1));

			}
		}

	}

	static class Node {
		int y, x, key, step; // key : 열쇠 종류

		public Node(int y, int x, int key, int step) {
			this.y = y;
			this.x = x;
			this.key = key;
			this.step = step;
		}

	}
}
