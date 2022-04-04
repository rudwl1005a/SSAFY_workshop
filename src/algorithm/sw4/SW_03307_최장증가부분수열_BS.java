package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D3 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr )
 */
public class SW_03307_최장증가부분수열_BS {
	// Binary Search
	// 시간 복잡도 : O(nlogn)

	static int T, N, len;
	static int[] input;
	static int[] memoi; // LIS X, 부분수열의 길이별로 가장 작은 값이 저장된다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			memoi = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			len = 0;
			for (int i = 0; i < N; i++) {
				int pos = Arrays.binarySearch(memoi, 0, len, input[i]);
				pos = Math.abs(pos) - 1;
				memoi[pos] = input[i];
				if (len == pos) {
					len++;
				}
			}

			System.out.println("#" + t + " " + len);
		}
	}

}