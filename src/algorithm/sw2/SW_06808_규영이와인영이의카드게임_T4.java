package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * SWEA D3 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0 )
 */
public class SW_06808_규영이와인영이의카드게임_T4 {
	// next-permutation을 사용하여 순열 생성

	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9];
	static int[] inCard = new int[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			win = 0;
			lose = 0;
			Arrays.fill(input, 0);

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 규영이의 카드
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1;
			}

			// 인영이의 카드
			num = 0;
			for (int i = 1; i <= 18; i++) {
				if (input[i] == 0) {
					inCard[num++] = i;
				}
			}

			// 로직(np)
			// 1. 배열 오름차순으로 정렬 -> 이 경우는 이미 정렬되어 있음
			// 2. 순열 각각의 경우 확인
			while(true) {
				// complete code
				check();
				if(!np()) break;
			}

			// 출력
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	private static boolean np() {
		int[] src = inCard;

		// 1. 꼭대기 찾기
		int i = src.length - 1;
		while (i > 0 && src[i - 1] >= src[i]) {
			--i;
		}

		// 내림차순으로 정렬되었으면 순열 모두 생성
		if (i == 0) {
			return false; // desc
		}

		// 2. i-1보다 작은 수 찾아서 서로 바꾸기
		int j = src.length - 1;
		while (src[i - 1] >= src[j]) {
			--j;
		}
		swap(src, i - 1, j);

		// 3. 바꾼 수 아래는 오름차순 정렬
		int k = src.length - 1;
		while (i < k) {
			swap(src, i++, k--);
		}
		
		// 새로운 순열 생성
		return true;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void check() {
		int guSum = 0;
		int inSum = 0;
		
		for (int i = 0; i < N; i++) {
			if(guCard[i] > inCard[i]) {
				guSum += guCard[i] + inCard[i];
			} else {
				inSum += guCard[i] + inCard[i];
			}
		}
		
		if(guSum > inSum) {
			win++;
		} else if(guSum < inSum) {
			lose++;
		}
	}
}
