package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1260 )
 */
public class BJ_01260_DFS와BFS2 {

	static int N, M, V;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점

		map = new boolean[N + 1][N + 1]; // index 0은 더미 이므로 visit으로 활용한다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = map[y][x] = true;
		}

		dfs(V);
		sb.append("\n");

		for (int i = 1; i <= N; i++) {
			map[i][0] = false;
		}
		
		bfs(V);
		sb.append("\n");

		System.out.println(sb);
	}

	private static void bfs(int cur) {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(cur);
		map[cur][0] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();

			sb.append(temp).append(" ");

			for (int i = 1; i <= N; i++) {
				if (map[i][0] || !map[temp][i]) {
					continue;
				}

				q.offer(i);
				map[i][0] = true;
			}
		}

	}

	private static void dfs(int cur) {

		map[cur][0] = true;
		sb.append(cur).append(" ");

		for (int i = 1; i <= N; i++) {
			if (map[i][0] || !map[cur][i]) {
				continue;
			}

			dfs(i);
		}
	}

}
