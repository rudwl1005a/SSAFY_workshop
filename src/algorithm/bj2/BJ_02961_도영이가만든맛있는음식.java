package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2961 )
 */
public class BJ_02961_도영이가만든맛있는음식 {
	// 조합
	
	static int N, min;
	static Ingredient[] ingredient;

	static class Ingredient {
		int sin; // 신맛
		int ssun; // 쓴맛

		public Ingredient(int sin, int ssun) {
			this.sin = sin;
			this.ssun = ssun;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ingredient = new Ingredient[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredient[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		min = Integer.MAX_VALUE;
		comb(0, 1, 0);

		System.out.println(min);
	}

	private static void comb(int cnt, int sinSum, int ssunSum) {

		if (cnt == N) {
			if (sinSum == 1 && ssunSum == 0) // 공집합이면 체크 안함
				return;
			int cha = Math.abs(sinSum - ssunSum);
			min = Math.min(min, cha);
			return;
		}

		comb(cnt + 1, sinSum * ingredient[cnt].sin, ssunSum + ingredient[cnt].ssun);
		comb(cnt + 1, sinSum, ssunSum);

	}

}
