package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 모의 역량 테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo )
 */
public class SW_05644_무선충전_T {

	static int T, M, A, ans, ay, ax, by, bx;
	static int[] pathA, pathB;
	static BC[] bcArray;

	static int[] dy = { 0, -1, 0, 1, 0 }; // 제자리 상 우 하 좌
	static int[] dx = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			// path
			pathA = new int[M];
			pathB = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathA[i] = st.nextToken().charAt(0) - '0';
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathB[i] = st.nextToken().charAt(0) - '0';
			}

			// BC
			bcArray = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcArray[i] = new BC(y, x, c, p);
			}

			// 초기화
			ans = 0;
			ay = 1;
			ax = 1;
			by = 10;
			bx = 10;

			// action : t = 0일 때
			charge();

			// 시뮬레이션
			for (int i = 0; i < M; i++) {
				ay += dy[pathA[i]];
				ax += dx[pathA[i]];
				by += dy[pathB[i]];
				bx += dx[pathB[i]];
				// action
				charge();
			}
			
			System.out.println("#" + t + " " + ans);
		}

	}

	static void charge() {
		int max = 0;

		// a <= i , b <= j 사용
		for (int i = 0; i < A; i++) {

			for (int j = 0; j < A; j++) {
				int sum = 0;

				int aPower = getPower(bcArray[i], ay, ax);
				int bPower = getPower(bcArray[j], by, bx);

				if (i != j) {
					sum = aPower + bPower;
				} else {
					sum = Math.max(aPower, bPower);
				}
				
				max = Math.max(max, sum);
			}

		}
		
		ans += max;
	}

	static int getPower(BC bc, int y, int x) {
		if (Math.abs(bc.y - y) + Math.abs(bc.x - x) <= bc.c) {
			return bc.p;
		}
		return 0;
	}

	static class BC {
		int y, x, c, p;

		public BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}

	}

}
