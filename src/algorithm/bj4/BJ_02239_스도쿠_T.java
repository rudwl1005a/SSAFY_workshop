package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2239 )
 */
public class BJ_02239_스도쿠_T {

	static int[][] map;
	static ArrayList<Node> zero = new ArrayList<>();
	static boolean complete = false;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		char[] line;

		for (int i = 0; i < 9; i++) {
			line = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line[j] - '0';
				if (map[i][j] == 0) {
					zero.add(new Node(i, j));
				}
			}
		}
		size = zero.size();

		dfs(0);

	}

	private static void dfs(int idx) { // count : 숫자로 바꾼 개수

		// 기저조건
		if (complete) {
			return;
		}

		if (idx == size) {
			// complete code
			complete = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}

		int y = zero.get(idx).y;
		int x = zero.get(idx).x;

		boolean[] visit = new boolean[10]; // 0 dummy

		// 가로로 이미 사용한 수 체크
		for (int i = 0; i < 9; i++) {
			if (map[y][i] != 0) {
				visit[map[y][i]] = true;
			}
		}

		// 세로로 이미 사용한 수 체크
		for (int i = 0; i < 9; i++) {
			if (map[i][x] != 0) {
				visit[map[i][x]] = true;
			}
		}

		// 사각형에 이미 사용한 수 체크
		int ny = (y / 3) * 3;
		int nx = (x / 3) * 3;
		for (int i = ny; i < ny + 3; i++) {
			for (int j = nx; j < nx + 3; j++) {
				if (map[i][j] != 0) {
					visit[map[i][j]] = true;
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!visit[i]) { // 아직 사용되지 않은 수라면
				map[y][x] = i;
				dfs(idx + 1);
				map[y][x] = 0;
			}
		}

	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
