package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU )
 */
public class SW_07465_창용마을무리의개수_T {

	static int T, N, M;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 사람 수
			M = Integer.parseInt(st.nextToken()); // 관계 수

			// make-set
			parent = new int[N + 1];
			makeSet();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if(parent[i] == i) {
					ans++;
				}
			}

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
	}

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}
	}

}
