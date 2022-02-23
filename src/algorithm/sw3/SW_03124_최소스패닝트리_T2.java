package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb )
 */
public class SW_03124_최소스패닝트리_T2 {
	// Prim 알고리즘

	static int T, V, E;
	static long sum;
	static ArrayList<ArrayList<Edge>> vertex; // 0 index 더미, 1 index == 1번 정점 / vertex(3) == ArrayList<Edge>
	static boolean[] visit;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c); // 인접리스트

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			// 초기화
			visit = new boolean[V + 1];
			pqueue.clear();

			// 인접 리스트 만들기
			vertex = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i <= V; i++) { // List의 1차구조 (2차원배열의 1차원)
				vertex.add(new ArrayList<Edge>());
			}
			for (int i = 0; i < E; i++) { // List의 2차구조
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				vertex.get(v1).add(new Edge(v2, c));
				vertex.get(v2).add(new Edge(v1, c));
			}

			// Prim
			sum = 0;
			int cnt = 1; // 시작 정점 선택 cnt == V
			visit[1] = true;
			
			// pqueue 시작 정점 => 갈 수 있는 정점 pqueue에 담는다 => 하나를 꺼내면 가장 작은 비용의 정점 => ...
			pqueue.addAll(vertex.get(1)); // 1->3, 5, 4, 7
			while (!pqueue.isEmpty()) {
				Edge edge = pqueue.poll(); // 비용이 가장 작은 정점 선택
				if(visit[edge.v]) continue;
				
				visit[edge.v] = true;
				sum += edge.c;
				cnt++;
				
				if(cnt == V) {
					break;
				}
				
				pqueue.addAll(vertex.get(edge.v));
			}

			System.out.println("#" + t + " " + sum);
		}

	}

	static class Edge {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}

	}

}
