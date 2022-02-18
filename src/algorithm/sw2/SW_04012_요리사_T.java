package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 모의 SW 역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH )
 */
public class SW_04012_요리사_T {

	static int T, N, min;
	static int[][] map;
	static int[] arrA, arrB; // 각 요리사가 가지고 있는 재료
	static boolean[] select; // tgt 반만 선택한 상태를 관리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			select = new boolean[N];
			arrA = new int[N / 2];
			arrB = new int[N / 2];
			min = Integer.MAX_VALUE;

			// 시너지는 항상 Sij + Sji가 같이 계산되기 때문에 한 쪽에다가 더해서 저장해 준다
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;

			comb(0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

	private static void comb(int srcIdx, int tgtIdx) {

		// 기저조건 - 반반 나누었다
		if (tgtIdx == N / 2) {
			check();
			return;
		}

		if (srcIdx == N) {
			return;
		}

		select[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1); // 현재 srcIdx를 tgtIdx에 받아 들이겠다

		select[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx); // 받아들이지 않는다

	}

	private static void check() {
		// arrA, arrB 구성
		// 문제에 맞게 처리
		int sumA = 0;
		int sumB = 0;

		int idxA = 0;
		int idxB = 0;

		// 8개 F F T F T T T F -> arrA[2, 4, 5, 6], arrB[0, 1, 3, 7]
		for (int i = 0; i < N; i++) {
			if (select[i]) {
				arrA[idxA++] = i;
			} else {
				arrB[idxB++] = i;
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i == j) { // 같을때는 진행 x
					continue;
				}
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
	}

}
