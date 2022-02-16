package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2961 )
 */
public class BJ_02961_도영이가만든맛있는음식_T {
	// 조합

	static int N, min;
	static int[][] src, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		src = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;

		// i : 재료 수
		for (int i = 1; i <= N; i++) {
			tgt = new int[i][2];
			comb(0, 0);
		}

		System.out.println(min);

	}

	private static void comb(int srcIdx, int tgtIdx) {

		if (tgtIdx == tgt.length) {
			int sin = 1; // 곱
			int ssn = 0; // 합

			for (int i = 0; i < tgt.length; i++) {
				sin *= tgt[i][0]; // 신 맛
				ssn += tgt[i][1]; // 쓴 맛
			}

			min = Math.min(min, Math.abs(sin - ssn));
			return;
		}

		if (srcIdx == N)
			return;

		tgt[tgtIdx][0] = src[srcIdx][0];
		tgt[tgtIdx][1] = src[srcIdx][1];

		comb(srcIdx + 1, tgtIdx + 1); // 현재값 받음
		comb(srcIdx + 1, tgtIdx); // 현재값 안받음

	}

}
