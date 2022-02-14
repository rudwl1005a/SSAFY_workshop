package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/3040 )
 */
public class BJ_03040_백설공주와일곱난쟁이 {

	static int sum;
	static int[] nine = new int[9];
	static int[] seven = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			nine[i] = Integer.parseInt(br.readLine());
		}

		comb(0, 0);
	}

	private static void comb(int cnt, int start) {

		if (cnt == 7) {
			sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += seven[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(seven[i]);
				}
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			seven[cnt] = nine[i];
			comb(cnt + 1, i + 1);
		}
	}
}
