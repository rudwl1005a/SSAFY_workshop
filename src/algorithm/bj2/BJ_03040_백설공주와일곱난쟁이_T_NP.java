package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/3040 )
 */
public class BJ_03040_백설공주와일곱난쟁이_T_NP {
	// Next-Permutation으로 풀기

	static int S = 9, T = 7;
	static int[] src = new int[S];
	static int[] index = new int[S]; // 000000000 -> 001111111 -> ... -> 111111100

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < S; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < T; i++) {
			index[(S - 1) - i] = 1;
		}
		
		while(true) {
			int sum = 0;
			for (int i = 0; i < S; i++) {
				if(index[i] == 1) {
					sum += src[i];
				}
			}
			if(sum == 100) {
				for (int i = 0; i < S; i++) {
					if(index[i] == 1) {
						System.out.println(src[i]);
					}
				}				
				break; // 찾았다.
			}
			
			// 다음 수 고려
			if(!np(index)) break;
		}

	}

	static boolean np(int[] array) {
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;

		if (i == 0)
			return false;

		int j = array.length - 1;
		while (array[i - 1] >= array[j])
			j--;
		swap(array, i - 1, j);

		int k = array.length - 1;
		while (i < k) {
			swap(array, i++, k--);
		}
		
		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
