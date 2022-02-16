package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1074 )
 */
public class BJ_01074_Z {

	static int N, R, C, num, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		num = 1 << N; // 2^N

		Z(0, 0);

		System.out.println(answer);
	}

	private static void Z(int y, int x) {
		
		// 기저 조건
		if (num == 1)
			return;

		// 분할 정복
		num /= 2;

		if (R < num + y && C < num + x) { // z중 첫번째
			// x
			Z(y, x);
		} else if (R < num + y && C >= num + x) { // z중 두번째
			answer += num * num;
			Z(y, x + num);
		} else if (R >= num + y && C < num + x) { // z중 세번째
			answer += num * num * 2;
			Z(y + num, x);
		} else { // z중 네번째
			answer += num * num * 3;
			Z(y + num, x + num);
		}
	}

}
