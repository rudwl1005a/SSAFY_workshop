package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD )
 */
public class SW_01251_하나로_T {
	// Kruskal 알고리즘

	static int T, N;
	static long ans;
	static double E;
	static int[][] island;

	static int[] parent;
	static long[][] edges; // 간선 리스트

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			island = new int[N][2]; // 0 : x좌표, 1 : y좌표

			// 섬의 좌표 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine()); // 환경 부담 세율

			// 간선 리스트 만들기
			// 1. 간선의 비용
			// 2. 간선의 규모 size
			int size = N * (N - 1) / 2;
			edges = new long[size][3]; // 0 : 출발 섬, 1 : 도착 섬, 2 : 두 섬간의 거리

			int idx = 0;
			for (int v1 = 0; v1 < N - 1; v1++) {
				for (int v2 = v1 + 1; v2 < N; v2++) {
					edges[idx][0] = v1;
					edges[idx][1] = v2;
					edges[idx][2] = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
					idx++;
				}
			}

			// Kruskal
			Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2]));

			parent = new int[N];
			makeSet();

			ans = 0;
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				int a = findSet((int) edges[i][0]); // v1
				int b = findSet((int) edges[i][1]); // v2
				if (a == b) {
					continue;
				}

				// union
				if (a < b) {
					parent[b] = a;
				} else {
					parent[a] = b;
				}

				ans += edges[i][2];
				cnt++;

				if (cnt == N - 1) {
					break;
				}

			}

			System.out.println("#" + t + " " + Math.round(ans * E)); // round 소수점 반올림

		}

	}

	private static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = findSet(parent[a]);
	}

}
