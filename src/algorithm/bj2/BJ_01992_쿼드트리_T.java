package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1992 )
 */
public class BJ_01992_쿼드트리_T {

	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		divide(0, 0, N);

	}

	static boolean check(int y, int x, int n) {
		char ch = map[y][x]; // 0 or 1;

		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (ch != map[i][j]) {
					return false;
				}
			}
		}

		System.out.print(ch);
		return true;
	}

	private static void divide(int y, int x, int n) {

		// y, x로 시작하는 n 크기의 정사각형의 문자가 모두 동일한가?
		if (!check(y, x, n)) { // 분할

			System.out.print("(");

			int half = n / 2;
			divide(y, x, half);
			divide(y, x + half, half);
			divide(y + half, x, half);
			divide(y + half, x + half, half);
			
			System.out.print(")");

		}
	}

}
