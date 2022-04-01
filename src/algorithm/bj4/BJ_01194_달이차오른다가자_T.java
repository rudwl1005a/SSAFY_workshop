package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G1 ( https://www.acmicpc.net/problem/1194 )
 */
public class BJ_01194_달이차오른다가자_T {

	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visit;
	static Queue<Node> q = new LinkedList<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		visit = new boolean[N][M][1 << 6];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					q.offer(new Node(i, j, 0, 0));
					visit[i][j][0] = true;
				}
			}
		}

		bfs();
		
		System.out.println(ans);
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (map[node.y][node.x] == '1') {
				ans = node.d;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				int key = node.key;

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == '#') {
					continue;
				}

				if ('a' <= map[ny][nx] && map[ny][nx] <= 'f') {
					key |= (1 << (map[ny][nx] - 'a'));
				}

				if ('A' <= map[ny][nx] && map[ny][nx] <= 'F') {
					if ((key & 1 << (map[ny][nx] - 'A')) == 0) {
						continue;
					}
				}
				
				if(visit[ny][nx][key]) {
					continue;
				}

				visit[ny][nx][key] = true;
				q.offer(new Node(ny, nx, key, node.d + 1));

			}
		}
		
		ans = -1;

	}

	static class Node {
		int y, x, key, d;

		public Node(int y, int x, int key, int step) {
			this.y = y;
			this.x = x;
			this.key = key;
			this.d = step;
		}

	}
}
