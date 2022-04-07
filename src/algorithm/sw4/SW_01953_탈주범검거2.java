package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq )
 */
/* 박영준_0748815님 코드 ( https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do ) */
public class SW_01953_탈주범검거2 {

	static int T, N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int[] pipes = { 0, 15, 5, 10, 3, 6, 12, 9 };

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visited = new boolean[N][M];
			Queue<int[]> currPipes = new LinkedList<>();
			Queue<int[]> nextPipes = new LinkedList<>();

			currPipes.offer(new int[] { R, C });
			visited[R][C] = true;
			int answer = 1;

			for (int i = 1; i < L; i++) {
				while (!currPipes.isEmpty()) {
					int[] curr = currPipes.poll();
					int row = curr[0];
					int col = curr[1];
					int pipeType = map[row][col];

					for (int j = 0; j < 4; j++) {
						if ((pipes[pipeType] & 1 << j) != 0) {
							int nr = row + delta[j][0];
							int nc = col + delta[j][1];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && (pipes[map[nr][nc]] & 1 << ((j + 2) % 4)) != 0 && !visited[nr][nc]) {
								nextPipes.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
								answer++;
							}
						}
					}
				}

				while (!nextPipes.isEmpty()) {
					currPipes.offer(nextPipes.poll());
				}
			}

			System.out.printf("#%d %d\n", t, answer);
		}
	}
}
