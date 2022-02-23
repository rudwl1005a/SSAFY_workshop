package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU )
 */
public class SW_07465_창용마을무리의개수 {

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
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			int ans = 0;
			ArrayList<Integer> group = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if(group.contains(parent[i])) {
					continue;
				}
				ans++;
				group.add(parent[i]);
			}

			System.out.println("#" + t + " " + ans);
		}

	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findSet(parent[a]);
	}

	private static void union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return;
		}
		// 한 무리로 바꿔주기
		for (int i = 1; i <= N; i++) {
			if(parent[i] == br) {
				parent[i] = ar;
			}
		}
	}

}
