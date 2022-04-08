package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/14502 )
 */
public class BJ_14502_연구소_T {

	static int N, M, max;
	static int[][] map, virusMap;
	static boolean[][] visit;
	static ArrayList<Node> zero = new ArrayList<Node>(); // 벽을 세울 수 있는 곳
	static int zeroSize;
	static int[][] wall = new int[3][2]; // 벽울 세울 자리

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 0)
					zero.add(new Node(i, j));
			}
		}

		zeroSize = zero.size();
		max = Integer.MIN_VALUE;

		comb(0, 0);
		System.out.println(max);
	}

	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		if (tgtIdx == 3) {
			// complete code
			// 벽을 3개 다 세웠으니, virus 를 퍼지게 한다.
			virus();
			return;
		}

		if (srcIdx == zeroSize)
			return;
		// 벽을 세울 좌표 저장
		wall[tgtIdx][0] = zero.get(srcIdx).y;
		wall[tgtIdx][1] = zero.get(srcIdx).x;

		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}

	static void virus() {
		// 초기화
		visit = new boolean[N][M];
		virusMap = new int[N][M];

		// map 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
			}
		}

		// wall 복사 넣기
		for (int i = 0; i < 3; i++) {
			int y = wall[i][0];
			int x = wall[i][1];
			virusMap[y][x] = 1;
		}

		// virus 가 퍼지게
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 2) {
					visit[i][j] = true;
					queue.offer(new Node(i, j));
				}
			}
		}

		// bfs 로
		while (!queue.isEmpty()) {
			Node n = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])
					continue;
				if (virusMap[ny][nx] == 0) {
					virusMap[ny][nx] = 2;
					visit[ny][nx] = true;
					queue.offer(new Node(ny, nx));
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 0)
					sum++;
			}
		}

		max = Math.max(max, sum);
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
