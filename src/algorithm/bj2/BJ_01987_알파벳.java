package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1987 )
 */
public class BJ_01987_알파벳 {

	static int R, C, ans, max = Integer.MIN_VALUE;
	static char[][] map;
	static boolean[] visit = new boolean[26]; // 알파벳 선택했는지

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		// 초기 알파벳 visit
		visit[(int) map[0][0] - 65] = true;
		
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int y, int x, int cnt) {

		max = Math.max(max, cnt);
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= R || nx >= C )
				continue;
			
			int v = (int) map[ny][nx] - 65;
			if(visit[v]) continue;
			
			visit[v] = true;
			dfs(ny, nx, cnt + 1);
			visit[v] = false;
		}

	}

}
