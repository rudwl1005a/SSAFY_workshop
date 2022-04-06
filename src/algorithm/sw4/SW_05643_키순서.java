package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo )
 */
public class SW_05643_키순서 {

	static int T, N, M, ans;
	static int INF = 9999999;
	static int[][] tall;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine()); // 학생들 수
			M = Integer.parseInt(br.readLine()); // 학생 키 비교 횟수
			
			tall = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					tall[i][j] = INF;
				}
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tall[a][b] = 1;
			}
			
			// 플로이드-와샬
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					if (i == k) continue;
					for (int j = 1; j <= N; j++) {
						if (j == i || j == k) continue;
						tall[i][j] = Math.min(tall[i][j], tall[i][k] + tall[k][j]);
					}
				}
			}
			
			// 순회하면서 자기 자신 외에 키를 비교할 수 있는 사람이 N - 1명이면 자신의 키가 몇번째인지 알 수 있다.
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				for (int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(tall[i][j] != INF || tall[j][i] != INF) {
						cnt++;
					}
				}
				
				if(cnt == N - 1) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
