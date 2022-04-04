package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D3 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr )
 */
public class SW_03307_최장증가부분수열_BF {
	// Brute-Force
	// 시간 복잡도 : O(n²)

	static int T, N, len;
	static int[] input;
	static int[] LIS;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			LIS = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			len = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if (input[j] < input[i]) {
						LIS[i] = Math.max(LIS[i], LIS[j] + 1);
					}
				}

				len = Math.max(len, LIS[i]);
			}

			System.out.println("#" + t + " " + len);
		}
	}

}
