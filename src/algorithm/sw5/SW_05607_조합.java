package algorithm.sw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D3 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGKdbqczEDFAUo )
 */
public class SW_05607_조합 {

	static int T, N, R;
	static final int P = 1234567891;
	static long[] fac;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			System.out.println("#" + t + " " + nCr(N, R, P));
		}
	}

	private static long nCr(int n, int r, int p) {
		if (r == 0) {
			return 1L;
		}

		fac = new long[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}

		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, int y, int p) {
		long res = 1L;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % p;
			}
			y = y >> 1;
			x = (x * x) % p;
		}

		return res;
	}

}
