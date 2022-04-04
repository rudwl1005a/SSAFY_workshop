package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * SWEA SW test ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf )
 */
public class SW_01767_프로세서연결하기 {

	static int T, N, cnt, ans;
	static int[][] map;

	static List<Node> list = new ArrayList<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list.clear();
			ans = Integer.MAX_VALUE; // 전선 개수
			cnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							continue;
						}
						list.add(new Node(i, j));
					}
				}
			}

			dfs(0, 0, 0);

			System.out.println("#" + t + " " + ans);
		}

	}

	// index : 코어 번호, count : 전선 개수, core : 코어 개수
	private static void dfs(int index, int count, int core) {

		// 기저조건
		if (index == list.size()) {
			if (cnt < core) {
				cnt = core;
				ans = count;
			} else if (cnt == core) {
				ans = Math.min(ans, count);
			}
			return;
		}

		int y = list.get(index).y;
		int x = list.get(index).x;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			int tempCount = 0;
			while (true) {
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					break;
				}

				if (map[ny][nx] == 1) {
					tempCount = 0;
					break;
				}

				tempCount++;
				ny += dy[d];
				nx += dx[d];
			}

			if (tempCount == 0) { // 연결 못할 경우
				dfs(index + 1, count, core);
			} else { // 연결 가능한 경우
				draw(y, x, d, tempCount, 1); // 전선 깔기
				dfs(index + 1, count + tempCount, core + 1);
				draw(y, x, d, tempCount, 0); // 되돌리기
			}
		}
	}

	private static void draw(int y, int x, int d, int tempCount, int num) {
		for (int i = 0; i < tempCount; i++) {
			y += dy[d];
			x += dx[d];

			map[y][x] = num;
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
