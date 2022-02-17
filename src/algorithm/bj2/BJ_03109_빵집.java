package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/3109 )
 */
public class BJ_03109_빵집 {

	static int R, C, ans; // row, col
	static boolean flag; // 길 찾았는지 확인
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			// 초기화
			flag = false;
			find(i, 0);
		}

		System.out.println(ans);
	}

	private static void find(int y, int x) {
		if (x == C - 1) {
			flag = true;
			ans++;
			return;
		}

		if (promising(y - 1, x + 1)) { // 오른쪽 위
			visit[y - 1][x + 1] = true;
			find(y - 1, x + 1);
		}

		if (promising(y, x + 1)) { // 오른쪽
			visit[y][x + 1] = true;
			find(y, x + 1);
		}

		if (promising(y + 1, x + 1)) { // 오른쪽 아래
			visit[y + 1][x + 1] = true;
			find(y + 1, x + 1);
		}

		// 3개 다 안되면 return
		return;
	}

	private static boolean promising(int y, int x) {
		if (y < 0 || x < 0 || y >= R || x >= C || map[y][x] == 'x' || flag || visit[y][x])
			return false;

		return true;
	}

}
