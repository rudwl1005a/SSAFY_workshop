package algorithm.sw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGGNB6cnEDFAUo )
 */
public class SW_05604_구간합 {

	static int T;
	static long start, end, startSum, endSum, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());

			startSum = 0;
			endSum = 0;
			for (int i = 1; i <= 9; i++) {
				startSum += i * count(start - 1, i);
			}
			for (int i = 1; i <= 9; i++) {
				endSum += i * count(end, i);
			}
			res = endSum - startSum;

			System.out.println("#" + t + " " + res);
		}
	}

	private static long count(long n, int num) {
		if (n < 0) { // 0부터 시작하는 예외를 위해서
			return 0;
		}

		long result = 0;
		long ten = 1;
		while (n / ten != 0) {
			long next = n / (ten * 10);
			long current = (n % (ten * 10)) / ten;
			long prev = n % ten;

			if (current > num) {
				result += (next + 1) * ten;
			} else if (current == num) {
				result += next * ten + (prev + 1);
			} else {
				result += next * ten;
			}
			ten *= 10;
		}
		return result;
	}

}
