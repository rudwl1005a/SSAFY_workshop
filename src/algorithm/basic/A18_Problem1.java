package algorithm.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
- 연습문제 1 -
 
아파트를 각 층별로 파란색 또는 노란색 페인트로 칠하되 다음과 같은 규칙으로 칠하려고
한다.
노란색은 인접한 두 층에 연속하여 사용할 수 있다.
파란색은 인접한 두 층에 연속하여 사용할 수 없다.
이와 같은 규칙으로 층의 아파트를 칠할 수 있는 방법의 수를 f(n)이라 하면 다음 그림과
같이 f(1) = 2, f(2) = 3 이다. f(8)을 얼마인가?
 */

public class A18_Problem1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 2;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[N]);
	}

}
