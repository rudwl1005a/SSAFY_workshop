package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD )
 * 메모리 : 109,820 kb, 실행시간 : 2,182 ms
 */
public class SW_01251_하나로2 {
	// Prim 알고리즘

	static int T, N;
	static double E;
	static Island[] island;
	static boolean[] visit;
	static ArrayList<ArrayList<Tunnel>> vertex;
	static PriorityQueue<Tunnel> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.disSqu, e2.disSqu));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			visit = new boolean[N];
			island = new Island[N];
			pq.clear();

			// 섬의 좌표 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				island[i] = new Island(x, 0);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i].y = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			// 인접 리스트 만들기
			vertex = new ArrayList<ArrayList<Tunnel>>();
			for (int i = 0; i < N; i++) { // List의 1차구조 (2차원배열의 1차원)
				vertex.add(new ArrayList<Tunnel>());
			}
			for (int i = 0; i < N - 1; i++) { // List의 2차구조
				for (int j = i + 1; j < N; j++) {
					long disSqu = distanceSqu(island[i], island[j]);
					vertex.get(i).add(new Tunnel(j, disSqu));
					vertex.get(j).add(new Tunnel(i, disSqu));
				}
			}

			// Prim
			long min = 0;
			int cnt = 0; // 0번 정점부터 시작
			visit[0] = true;

			pq.addAll(vertex.get(0));
			while (!pq.isEmpty()) {
				Tunnel tunnel = pq.poll(); // 비용이 가장 작은 정점 선택
				if (visit[tunnel.island]) {
					continue;
				}

				visit[tunnel.island] = true;
				min += tunnel.disSqu;
				cnt++;

				if (cnt == N) {
					break;
				}

				pq.addAll(vertex.get(tunnel.island));
			}

			double ans = (double) min * E;

			System.out.print("#" + t + " ");
			System.out.printf("%.0f\n", ans); // 소수점 첫번째 자리에서 반올림

		}

	}

	// 거리계산(피타고라스) - 정답에서 제곱을 곱할 것이기 때문에 미리 제곱을 해서 결과를 도출
	private static long distanceSqu(Island i1, Island i2) {
		return (long) Math.abs(i1.y - i2.y) * (long) Math.abs(i1.y - i2.y) + (long) Math.abs(i1.x - i2.x) * (long) Math.abs(i1.x - i2.x);
	}

	static class Tunnel {
		int island; // 연결되어있는 섬의 번호
		long disSqu;

		public Tunnel(int island, long disSqu) {
			this.island = island;
			this.disSqu = disSqu;
		}

	}

	static class Island {
		int x, y; // 섬의 좌표

		public Island(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
