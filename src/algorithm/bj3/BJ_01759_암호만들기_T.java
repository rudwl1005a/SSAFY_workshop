package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1759 )
 */
public class BJ_01759_암호만들기_T {

	static int L, C;
	static char[] src, tgt;
	static boolean[] isMo; // 모음인지 확인

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 암호 문자열 길이
		C = Integer.parseInt(st.nextToken()); // 추측할 문자열

		tgt = new char[L];
		src = new char[C];
		isMo = new boolean[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			src[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(src); // 정렬을 미리 하고 감

		for (int i = 0; i < C; i++) {
			if (src[i] == 'a' || src[i] == 'e' || src[i] == 'i' || src[i] == 'o' || src[i] == 'u') {
				isMo[i] = true;
			}
		}

		comb(0, 0, 0, 0);

	}

	private static void comb(int srcIdx, int tgtIdx, int moCnt, int jaCnt) {

		if (tgtIdx == L) {
			if (moCnt >= 1 && jaCnt >= 2) {
				for (int i = 0; i < L; i++) {
					System.out.print(tgt[i]);
				}
				System.out.println();
			}
			return;
		}
		if (srcIdx == C) {
			return;
		}

		tgt[tgtIdx] = src[srcIdx];

		if (isMo[srcIdx]) {
			comb(srcIdx + 1, tgtIdx + 1, moCnt + 1, jaCnt);
		} else {
			comb(srcIdx + 1, tgtIdx + 1, moCnt, jaCnt + 1);
		}

		comb(srcIdx + 1, tgtIdx, moCnt, jaCnt);
	}

}
