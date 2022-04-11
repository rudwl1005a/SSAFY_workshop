package algorithm.sw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzaq5KKk_ADFAVU )
 */
public class SW_08458_원점으로집합_T {

	static int T, N, max;
	static int[] point;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			point = new int[N];
			max = Integer.MIN_VALUE;

			// 먼저 맨 앞의 점을 계산
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[0] = Math.abs(x) + Math.abs(y);

			max = point[0];
			// 모든 수가 똑같이 홀수이거나, 짝수이면 원점으로 모두 이동시킬 수 있다.
			// 홀수, 짝수가 섞여있다 => 원점으로 모두 이동할 수 없다
			boolean stop = false;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				point[i] = Math.abs(x) + Math.abs(y);
				max = Math.max(max, point[i]);

				if (point[i] % 2 != point[i - 1] % 2) {
					stop = true;
				}
			}

			if (stop) {
				System.out.println("#" + t + " -1");
				continue;
			}

			int sum = 0; // 움직이는 누적거리
			int cnt = 0; // 움직이는 횟수(답)

			// 직선으로 움직인다는 가정
			while (true) {
				if (sum == max || sum > max && (sum - max) % 2 == 0) {
					break;
				}
				sum += ++cnt;
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

}
