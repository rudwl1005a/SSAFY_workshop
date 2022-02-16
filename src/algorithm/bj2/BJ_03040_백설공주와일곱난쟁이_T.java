package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/3040 )
 */
public class BJ_03040_백설공주와일곱난쟁이_T {

	static int S = 9, T = 7;
	static int[] src = new int[S];
	static int[] tgt = new int[T];
	static boolean done;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < S; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}

		comb(0, 0);
		
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (done) // 한 조합 완성되면 더 만들지 않는다 -> 답은 유일하게 존재하기 때문에
			return;
		
		// 기저조건
		if (tgtIdx == T) {
			// complete code
			int sum = 0;
			for (int i = 0; i < T; i++) {
				sum += tgt[i];
			}
			if (sum == 100) {
				done = true;
				for (int i = 0; i < T; i++) {
					System.out.println(tgt[i]);
				}
			}
			return;
		}

		if (srcIdx == S)
			return;

		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
