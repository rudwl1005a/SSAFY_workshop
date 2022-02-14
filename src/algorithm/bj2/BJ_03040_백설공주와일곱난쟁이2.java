package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/3040 )
 */
public class BJ_03040_백설공주와일곱난쟁이2 {
	// next-permutation
	// sort해서 출력한다고 되어있었다면 이렇게 풀기!

	static int[] nine = new int[9];
	static int[] seven = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			nine[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nine);

		while (true) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				seven[i] = nine[i];
				sum += seven[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(seven[i]);
				}
				break;
			}
			if (!np())
				break;
		}
	}

	private static boolean np() {

		int i = nine.length - 1;
		while (i > 0 && nine[i - 1] > nine[i]) {
			--i;
		}

		if (i == 0) {
			return false;
		}

		int j = nine.length - 1;
		while (nine[i - 1] >= nine[j]) {
			--j;
		}
		swap(nine, i - 1, j);

		int k = nine.length - 1;
		while (i < k) {
			swap(nine, i++, k--);
		}

		return true;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
