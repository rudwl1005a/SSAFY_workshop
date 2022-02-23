package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb )
 */
public class SW_03124_최소스패닝트리_T {
	// Kruskal 알고리즘

	static int T, V, E;
	static long sum;
	static int[] parent;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			parent = new int[V + 1];

			// 간선 리스트 만들기
			edges = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(v1, v2, c);
			}

			// Kruskal
			sum = 0;
			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
			makeSet();
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				Edge edge = edges[i];
				// 사이클 체크
				// 기본적인 findSet, union 활용
//				if (findSet(edge.v1) == findSet(edge.v2)) {
//					continue;
//				}
//				union(edge.v1, edge.v2);
				// boolean union활용
				if(union(edge.v1, edge.v2)) {
					// 선택
					sum += edge.c;
					cnt++;
				}
				
				// 선택한 간선수 V-1개인지 확인 - 종료
				if (cnt == V - 1) {
					break;
				}
				
			}

			System.out.println("#" + t + " " + sum);
		}

	}

	private static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
	}

	private static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px == py) {
			return false;
		}
		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}
		return true;
	}
	
//	private static void union(int x, int y) {
//		int px = findSet(x);
//		int py = findSet(y);
//		if (px < py) {
//			parent[py] = px;
//		} else {
//			parent[px] = py;
//		}
//	}

	static class Edge {
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}

	}

}
