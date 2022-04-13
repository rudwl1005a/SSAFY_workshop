package algorithm.sw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA SW역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH )
 */
public class SW_04013_특이한자석 {

	static int T, K, ans;
	static int[][] magnet;
	static boolean[] isRotate;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			// 자석 정보 저장
			magnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 시뮬레이션 시작
			ans = 0;
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1; // 자석 번호
				int dir = Integer.parseInt(st.nextToken()); // 회전 방향
				isRotate = new boolean[4]; // 이번 시간에 회전했는가
				rotate(num, dir);
			}

			// 점수 계산
			for (int i = 0; i < 4; i++) {
				if (magnet[i][0] == 1) { // s극일때만 점수
					ans += (int) Math.pow(2, i);
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void rotate(int num, int dir) {

		int originR = magnet[num][2];
		int originL = magnet[num][6];

		isRotate[num] = true;

		if (dir == -1) { // 반시계방향
			int temp = magnet[num][0];
			for (int i = 1; i < 8; i++) {
				magnet[num][i - 1] = magnet[num][i];
			}
			magnet[num][7] = temp;
		} else if (dir == 1) { // 시계방향
			int temp = magnet[num][7];
			for (int i = 6; i >= 0; i--) {
				magnet[num][i + 1] = magnet[num][i];
			}
			magnet[num][0] = temp;
		}

		switch (num) {
		case 0: // 1번만 비교
			if (!isRotate[1] && originR != magnet[1][6]) {
				rotate(1, dir * (-1)); // 반대 방향으로 회전
			}
			break;
		case 1: // 0,2번 비교
			if (!isRotate[0] && originL != magnet[0][2]) {
				rotate(0, dir * (-1));
			}
			if (!isRotate[2] && originR != magnet[2][6]) {
				rotate(2, dir * (-1));
			}
			break;
		case 2: // 1,3번 비교
			if (!isRotate[1] && originL != magnet[1][2]) {
				rotate(1, dir * (-1));
			}
			if (!isRotate[3] && originR != magnet[3][6]) {
				rotate(3, dir * (-1));
			}
			break;
		case 3: // 2번만 비교
			if (!isRotate[2] && originL != magnet[2][2]) {
				rotate(2, dir * (-1));
			}
			break;
		}

	}

}
