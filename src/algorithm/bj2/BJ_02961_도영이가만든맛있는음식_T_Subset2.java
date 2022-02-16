package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2961 )
 */
public class BJ_02961_도영이가만든맛있는음식_T_Subset2 {
	// 부분집합 & Bitmasking

	static int N, min;
	static int[][] src;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		src = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;

		// 모든 부분집합의 수
		int size = 1 << src.length; // 2^src.length
									// 5개 기준 2*2*2*2*2 000001 -> 010000 == 32
		
		// 적어도 1개의 재료는 사용 - i는 1부터 시작
		for (int i = 1; i < size; i++) { // 5개 기준 - i range : 1 ~ 31
			// 한개의 부분집합을 의미
			int sin = 1;
			int ssn = 0;
			for (int j = 0; j < src.length; j++) {
				if ((i & 1 << j) != 0) { // 위의 i가 표현하는 부분집합 0과 1중 현재 j가 선택되어 있다는 의미
					sin *= src[j][0];
					ssn += src[j][1];
				}
			}
			min = Math.min(min, Math.abs(sin - ssn));
		}	

		System.out.println(min);

	}

}
