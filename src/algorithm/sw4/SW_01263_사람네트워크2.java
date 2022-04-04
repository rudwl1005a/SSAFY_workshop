package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D6 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN )
 */
public class SW_01263_사람네트워크2 {

	static int T, N;
	static int BIG = 999999;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (i != j && n == 0) {
						matrix[i][j] = BIG;
					} else {
						matrix[i][j] = n;
					}
				}
			}

			// 경유지를 따진다.
			// matrix 갱신 -> 완성
			for (int k = 0; k < N; k++) {
				// i -> j 각각의 비용
				for (int i = 0; i < N; i++) {

					if (i == k) continue;

					for (int j = 0; j < N; j++) {
						if (j == i || j == k) continue;
						// i->j로 가는 비용, i->k->j로 가는 비용의 최소값 선택해서 matrix 갱신
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}

			// matrix 최소값 찾기
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) { // 사람별 node별 계산(이동거리, 비용) sum
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += matrix[i][j];
				}
				min = Math.min(min, sum);
			}

			System.out.println("#" + t + " " + min);
		}
	}

}
