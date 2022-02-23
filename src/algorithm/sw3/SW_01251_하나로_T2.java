package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD )
 * 메모리 : 109,564 kb, 실행시간 : 641 ms
 */
public class SW_01251_하나로_T2 {
	// Prim 알고리즘 + PrioriryQueue

	static int T, N;
	static long ans;
	static double E;
	static int[][] island;

	static ArrayList<ArrayList<Edge>> vertex;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> Long.compare(e1.c, e2.c));
	static boolean[] visit;

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

			// Prim
			vertex = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i < N; i++) {
				vertex.add(new ArrayList<Edge>());
			}

			// 인접 리스트 생성
			for (int v1 = 0; v1 < N - 1; v1++) {
				for (int v2 = v1 + 1; v2 < N; v2++) {
					// v1에서 갈 수 있는 Edge 객체 생성
					long dis = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
					Edge edge1 = new Edge(v2, dis);
					vertex.get(v1).add(edge1);

					Edge edge2 = new Edge(v1, dis);
					vertex.get(v2).add(edge2);
				}
			}

			// 초기화
			visit = new boolean[N];
			pqueue.clear();

			ans = 0;
			int cnt = 1;
			visit[0] = true;

			pqueue.addAll(vertex.get(0));
			while (!pqueue.isEmpty()) {
				Edge edge = pqueue.poll();
				if (visit[edge.v]) {
					continue;
				}

				// 선택
				ans += edge.c;
				visit[edge.v] = true;
				cnt++;

				if (cnt == N) {
					break;
				}

				// 둘중 하나 선택
				// 1. 일단 다 넣는다.
//				pqueue.addAll(vertex.get(edge.v));

				// 2. 방문하지 않는 곳만 넣는다
				for (Edge e : vertex.get(edge.v)) {
					if (visit[e.v]) {
						continue;
					}
					pqueue.add(e);
				}
			}

			System.out.println("#" + t + " " + Math.round(ans * E)); // round 소수점 반올림

		}

	}

	private static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	static class Edge {
		int v;
		long c;

		public Edge(int v, long c) {
			this.v = v;
			this.c = c;
		}

	}

}
