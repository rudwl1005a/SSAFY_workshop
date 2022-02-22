package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr )
 */
public class SW_03289_서로소집합_T {

	static int T, n, m;
	static int[] parent;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 원소의 개수
			m = Integer.parseInt(st.nextToken()); // 연산의 개수

			parent = new int[n + 1];
			makeSet();

			sb = new StringBuilder("#").append(t).append(" ");
			for (int i = 0; i < m; i++) { // 연산 계산
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (op == 0) { // 합집합 만들기
					union(x, y);
				} else { // a와 b가 같은 집합 안에 있는가?
					if (findSet(x) == findSet(y)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}

			System.out.println(sb);
		}
	}

	private static void makeSet() {
		for (int i = 1; i <= n; i++) {
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

		if (px < py) { // 작은 수 쪽으로 붙기
			parent[py] = px;
		} else {
			parent[px] = py;
		}

	}

}
