package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 B1 ( https://www.acmicpc.net/problem/2839 )
 */
public class BJ_02839_설탕배달2 {
	// DP방식으로 풀기
	
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		if(N == 3 || N == 5) {
			System.out.println("1");
		} else if(N == 4) {
			System.out.println("-1");
		} else {
			dp = new int[N+1];
			Arrays.fill(dp, 5000);
			dp[3] = 1; dp[5] = 1;
			for (int i = 6; i <= N; i++) {
				dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
			}
			
			System.out.println(dp[N] >= 5000 ? "-1" : dp[N]);
		}
	}

}
