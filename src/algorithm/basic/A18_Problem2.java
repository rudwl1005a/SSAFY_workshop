package algorithm.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
- 연습문제 2 -

1cm 짜리 파란 막대와 1cm 짜리 노란 막대 그리고 2cm 짜리 빨간 막대가 있다. 
이 막대들을 연결하여 길이가 ncm인 막대를 만드는 방법의 수를 f(n)이라 하자. 
예를 들면 2cm 막대를 만드는 방법은
(파란 막대, 파란 막대), 
(파란 막대, 노란 막대), 
(노란 막대, 파란 막대), 
(노란 막대, 노란 막대), 
(빨간 막대)
5가지이므로 f(2) = 5이다. 
f(6)의 값은?
 */

public class A18_Problem2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 2;
		dp[2] = 5;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] * 2 + dp[i - 2];
		}

		System.out.println(dp[N]);
	}

}
