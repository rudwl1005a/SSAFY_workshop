package algorithm.sw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA SW역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH )
 */
public class SW_04013_특이한자석_T {

	static int T, K, ans;
	static int[] score = { 1, 2, 4, 8 }; // 자석별 점수
	static int[] dir; // 자석별 움직임 표시
	static int[][] gear; // 자석

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			gear = new int[4][8];
			ans = 0;

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 시뮬레이션 K만큼
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				// id, dir을 이용해서 각각의 자석이 어느 방향으로 이동해야 하는지, 혹은 움직이지 않아도 되는지 계산
				check(id, dir);
				// 회전
				rotate();
			}

			// 채점
			for (int i = 0; i < 4; i++) {
				if (gear[i][0] == 1) {
					ans += score[i];
				}
			}

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void check(int id, int d) {
		dir = new int[4]; // 0으로 초기화
		dir[id] = d;

		// 회전할 자석 기준으로 오른쪽 계산
		for (int i = id + 1; i < 4; i++) {
			if (gear[i - 1][2] != gear[i][6]) {
				dir[i] = dir[i - 1] * (-1);
			}
		}

		// 왼쪽 계산
		for (int i = id - 1; i >= 0; i--) {
			if (gear[i][2] != gear[i + 1][6]) {
				dir[i] = dir[i + 1] * (-1);
			}
		}
	}

	private static void rotate() {
		for (int i = 0; i < 4; i++) {
			int temp;
			switch (dir[i]) {
			case 1: // 시계방향
				temp = gear[i][7];
				for (int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j - 1];
				}
				gear[i][0] = temp;
				break;
			case -1: // 반시계방향
				temp = gear[i][0];
				for (int j = 0; j < 7; j++) {
					gear[i][j] = gear[i][j + 1];
				}
				gear[i][7] = temp;
				break;
			}
		}
	}

}
