package algorithm.jo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954 )
 */
public class JO_01681_해밀턴순환회로_T {
	// dfs
	// select는 기존 완탐에서 사용하는 재방문 방지를 위한 visit X

	static int N, min;
	static int[][] matrix;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N + 1][N + 1];
		select = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		select[1] = true; // 1번회사
		dfs(1, 1, 0); // 1번정점, depth:1, 비용:0
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}

	// 방문 정점, depth, 누적비용
	private static void dfs(int v, int d, int c) {

		// 기저조건
		if (d == N) {
			// 1번으로 되돌아 갈 수 있는지 확인
			if (matrix[v][1] != 0) {
				min = Math.min(min, c + matrix[v][1]);
			}
			return;
		}

		// 현재까지 온 정점은 제외(select), 갈 수 있어야함(비용!=0), 비용 가지치기
		for (int i = 1; i <= N; i++) {
			if (select[i] || matrix[v][i] == 0 || c + matrix[v][i] >= min) {
				continue;
			}

			select[i] = true;
			dfs(i, d + 1, c + matrix[v][i]);
			select[i] = false;
		}
	}
}
