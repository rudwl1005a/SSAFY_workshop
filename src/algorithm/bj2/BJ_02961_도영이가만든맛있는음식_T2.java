package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2961 )
 */
public class BJ_02961_도영이가만든맛있는음식_T2 {
	// 조합 refactoring

	static int N, min;
	static int[][] src;

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

		comb(0, 1, 0); // 신맛은 *, 쓴맛은 + 이므로 초기값 각각 1, 0

		System.out.println(min);

	}

	private static void comb(int srcIdx, int sinSum, int ssnSum) {

		if (srcIdx == N) return;

		int curSin = src[srcIdx][0] * sinSum;
		int curSsn = src[srcIdx][1] + ssnSum;
		
		min = Math.min(min, Math.abs(curSin - curSsn));

		comb(srcIdx + 1, curSin, curSsn); // 현재 값 받음
		comb(srcIdx + 1, sinSum, ssnSum); // 현재 값 안받음

	}

}
