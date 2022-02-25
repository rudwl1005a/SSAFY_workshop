package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/16236 )
 */
public class BJ_16236_아기상어_T {

	static int N, sy, sx, sSize = 2, sEatCnt, ans; // sSize = 아기 상어 크기, sEatCnt = 아기 상어가 먹은 수
	static int[][] map;
	static boolean[][] visit;

	static Queue<Node> queue = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 9) { // 아기상어 초기 위치
					sy = i;
					sx = j;
				}
				map[i][j] = n;
			}
		}

		// 풀이
		sSize = 2;

		// 시뮬레이션 - 반복(횟수 정해져 있지 않음)
		while (true) {
			// 상어 먹이 찾으러감, 찾으면 먹음. 못찾으면 종료
			int cnt = bfs(); // 먹었으면 먹은 고기까지의 거리
			if (cnt == 0) {
				break;
			}
			ans += cnt;
		}
		
		System.out.println(ans);

	}

	private static int bfs() {
		// 먹이 후보
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minDis = Integer.MAX_VALUE;

		// visit 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}

		visit[sy][sx] = true;
		queue.offer(new Node(sy, sx, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// 먹을 수 있는 물고기 발견하면
			if (map[node.y][node.x] < sSize && map[node.y][node.x] != 0) {
				if (node.d < minDis) { // 거리가 작으면
					minDis = node.d;
					minY = node.y;
					minX = node.x;
				} else if (node.d == minDis) { // 거리가 같으면
					if (node.y < minY) { // 위쪽이면
						minDis = node.d;
						minY = node.y;
						minX = node.x;
					} else if (node.y == minY) { // 높이가 같으면
						if (node.x < minX) { // 왼쪽이면
							minDis = node.d;
							minY = node.y;
							minX = node.x;
						}
					}
				}
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > sSize) {
					continue;
				}
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx, node.d + 1));
			}
		}

		if (minDis == Integer.MAX_VALUE) { // 먹이 찾지 못함
			return 0;
		} else {
			sEatCnt++;
			if (sEatCnt == sSize) {
				sSize++;
				sEatCnt = 0;
			}

			map[minY][minX] = 0; // 먹은 물고기 자리
			map[sy][sx] = 0; // 원래 상어 자리

			sy = minY;
			sx = minX;
		}

		return minDis;
	}

	static class Node {
		int y, x, d;

		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}

	}

}
