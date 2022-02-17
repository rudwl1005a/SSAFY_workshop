package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D5 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD )
 */
public class SW_01247_최적경로 {

	static int T, N, X, Y, min;
	static Location[] input;
	static Location[] customer;

	static class Location {
		int y, x;

		public Location(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new Location[N + 2];
			customer = new Location[N];
			min = Integer.MAX_VALUE;
			
			// input[0] : 회사 좌표, input[1] : 집 좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				input[i] = new Location(Y, X);
			}

			perm(0, 0, 0);

			System.out.println("#" + t + " " + min);
		}
	}

	private static void perm(int cnt, int flag, int sum) {
		
		if(sum > min) return;
		
		if (cnt == N) {
			// 마지막 고객의 집과 집과의 거리 계산
			sum += Math.abs(customer[cnt - 1].y - input[1].y) + Math.abs(customer[cnt - 1].x - input[1].x);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 2; i < N + 2; i++) {
			if ((flag & 1 << (i - 2)) != 0) {
				continue;
			}

			customer[cnt] = input[i];
			
			int nSum;
			if (cnt == 0) { // 첫번째 집이면 회사와의 거리 계산
				nSum = sum + Math.abs(customer[cnt].y - input[0].y) + Math.abs(customer[cnt].x - input[0].x);
			} else { // 나머지 집이면 바로 앞 고객 집과의 거리 계산
				nSum = sum + Math.abs(customer[cnt].y - customer[cnt - 1].y) + Math.abs(customer[cnt].x - customer[cnt - 1].x);
			}

			perm(cnt + 1, flag | 1 << (i - 2), nSum);

		}

	}

}
