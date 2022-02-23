package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD )
 * 메모리 : 93,476 kb, 실행시간 : 876 ms
 */
public class SW_01251_하나로 {
	// Kruskal 알고리즘

	static int T, N;
	static double E;
	static Island[] island;
	static Tunnel[] tunnel;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			island = new Island[N];

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

			// make-set
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			// 간선 리스트 만들기
			int size = (N - 1) * N / 2;
			tunnel = new Tunnel[size]; // 가능한 간선의 개수
			int index = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					tunnel[index++] = new Tunnel(i, j, distanceSqu(island[i], island[j]));
				}
			}
			
			Arrays.sort(tunnel, (e1, e2) -> Long.compare(e1.disSqu, e2.disSqu));

			long min = 0;
			int cnt = 0;
			for (Tunnel tun : tunnel) {
				if (union(tun.i1, tun.i2)) {
					min += tun.disSqu;
					cnt++;
					if (cnt == N - 1) {
						break;
					}
				}
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

	static class Tunnel {
		int i1, i2; // 연결되어있는 섬의 번호
		long disSqu;

		public Tunnel(int i1, int i2, long disSqu) {
			this.i1 = i1;
			this.i2 = i2;
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
