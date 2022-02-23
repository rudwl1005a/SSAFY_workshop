package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD )
 * 메모리 : 46,708 kb, 실행시간 : 224 ms
 */
public class SW_01251_하나로_T3 {
	// Prim 알고리즘 + 인접행렬

	static int T, N;
	static long ans;
	static double E;

	static boolean[] visit;
	static long[] minEdge;
	static long[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			matrix = new long[N][N];
			visit = new boolean[N];
			minEdge = new long[N];

			// 일시적 배열 선언
			int[] x = new int[N];
			int[] y = new int[N];

			// 섬의 좌표 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine()); // 환경 부담 세율

			// 인접행렬 만들기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = distance(x[i], x[j], y[i], y[j]);
				}
			}

			// Prim
			ans = 0;

			prim();

			System.out.println("#" + t + " " + Math.round(ans * E)); // round 소수점 반올림

		}

	}

	static void prim() {
		// minEdge
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0; // 첫번째가 최소값으로 예상

		// 모든 정점을 고려 ( N번 반복,선택 )
		for (int v = 0; v < N; v++) {
			long minC = Long.MAX_VALUE;
			int minV = 0;

			// 최소값 - 정점
			for (int i = 0; i < N; i++) { // i가 고려하는 정점 index
				if (!visit[i] && minC > minEdge[i]) {
					minC = minEdge[i];
					minV = i;
				}
			}

			// 선택
			visit[minV] = true;
			ans += minC;

			// 새로운 선택된 minV으로부터 갈 수 있는 정점 고려해서 그 비용으로 minEdge 갱신
			for (int i = 0; i < N; i++) {
				if (!visit[i] && matrix[minV][i] != 0 && minEdge[i] > matrix[minV][i]) {
					minEdge[i] = matrix[minV][i];
				}
			}
		}
	}

	private static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

}
