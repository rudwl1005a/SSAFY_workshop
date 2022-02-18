package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D5 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD )
 */
public class SW_01247_최적경로_T {
	// 순열로만 풀기

	static int T, N, comX, comY, homeX, homeY, min;
	static int[][] cust; // src
	static int[] tgt;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 초기화
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			cust = new int[N][2];
			tgt = new int[N];
			select = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 회사 좌표, 집 좌표 넣어주기
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}

			perm(0);

			System.out.println("#" + t + " " + min);
		}
	}

	private static void perm(int tgtIdx) {
		// 기저조건
		if (tgtIdx == N) {
			// complete code
			int sum = 0;
			// 회사 - 첫 고객
			sum += distance(comY, comX, cust[tgt[0]][0], cust[tgt[0]][1]);

			// 고객들
			for (int i = 0; i < N - 1; i++) {
				sum += distance(cust[tgt[i]][0], cust[tgt[i + 1]][1], cust[tgt[i]][0], cust[tgt[i + 1]][1]);
			}

			// 마지막 고객 - 집
			sum += distance(homeY, homeX, cust[tgt[N - 1]][0], cust[tgt[N - 1]][1]);

			min = Math.min(min, sum);

			return;
		}

		for (int i = 0; i < N; i++) {
			if (select[i]) {
				continue;
			}

			select[i] = true;
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
			select[i] = false;
		}

	}

	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}

}
