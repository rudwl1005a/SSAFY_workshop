package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2961 )
 */
public class BJ_02961_도영이가만든맛있는음식3 {
	// Subset binary counting으로 풀기 + 2차원배열

	static int N, min;
	static int[][] ingredient;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ingredient = new int[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredient[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		min = Integer.MAX_VALUE;
		subset();

		System.out.println(min);
	}

	private static void subset() {

		for (int flag = 1, caseCount = 1 << N; flag < caseCount; flag++) {
			int sinSum = 1, ssunSum = 0;
			for (int i = 0; i < N; i++) { // 각 비트열의 상태 확인
				if ((flag & 1 << i) != 0) {
					sinSum *= ingredient[i][0];
					ssunSum += ingredient[i][1];
				}
			}
			min = Math.min(min, Math.abs(sinSum - ssunSum));
		}

	}

}
