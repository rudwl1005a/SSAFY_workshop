package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/3109 )
 */
public class BJ_03109_빵집_T {

	static int R, C, ans; // row, col
	static char[][] map;

	static int[] dy = { -1, 0, 1 }; // 우상, 우, 우하

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

		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static boolean dfs(int y, int x) {
		
		int nx = x + 1; // x는 오른쪽으로 한칸 이동
		
		// 파이프 설치 완료
		if(nx == C - 1) {
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			
			if(ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
			
			map[ny][nx] = 'x'; // visit 체크 -> 건물로 만들어주기
			
			if(dfs(ny, nx)) return true;
		}
		
		return false;
	}

}
