package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb )
 */
public class SW_03124_최소스패닝트리 {

	static int T, V, E;
	static int[] parent;
	static Edge[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			// make-set
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}

			// 간선 리스트 만들기
			edge = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edge);
			
			long ans = 0;
			int cnt = 0;
			for(Edge e : edge) {
				if(union(e.from, e.to)) {
					ans += e.weight;
					cnt++;
					if(cnt == V-1) {
						break;
					}
				}
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

	private static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}
		
		parent[br] = ar;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 가중치를 기준으로 오름차순으로 정렬
			return this.weight - o.weight;
		}

	}

}
