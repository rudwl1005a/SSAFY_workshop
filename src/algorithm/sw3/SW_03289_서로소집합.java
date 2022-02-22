package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr )
 * 메모리 : 102,320kb / 실행시간 : 476ms
 */
public class SW_03289_서로소집합 {

	static int T, N, M;
	static int[] set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			sb.setLength(0);
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 원소의 개수
			M = Integer.parseInt(st.nextToken()); // 연산의 개수

			// make-set
			set = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				set[i] = i;
			}

			for (int i = 0; i < M; i++) { // 연산 계산
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) { // 합집합 만들기
					union(a, b);
				} else { // a와 b가 같은 집합 안에 있는가?
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}

			System.out.println(sb);
		}
	}

	private static int findSet(int a) {
		if (set[a] == a) {
			return a;
		}

		return set[a] = findSet(set[a]);
	}

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return;
		}

		set[bRoot] = aRoot;
	}

}
