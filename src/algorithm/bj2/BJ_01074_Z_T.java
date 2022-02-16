package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1074 )
 */
public class BJ_01074_Z_T {
	// 분할 정복

	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N); // 2^N

		// 원점 저장
		int y = 0;
		int x = 0;

		while (N > 1) { // 계속 4등분

			N /= 2;

			if (r < y + N && c < x + N) { // top-left
				// 아무것도 안해도 됨
			} else if (r < y + N && c >= x + N) { // top-right
				ans += N * N * 1;
				x += N;
			} else if (r >= y + N && c < x + N) { // bottom-left
				ans += N * N * 2;
				y += N;
			} else { // bottom-right
				ans += N * N * 3;
				y += N;
				x += N;
			}
			
		}
		
		System.out.println(ans);
	}

}
