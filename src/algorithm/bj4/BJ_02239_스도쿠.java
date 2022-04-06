package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2239 )
 */
public class BJ_02239_스도쿠 {

	static int cnt, min;
	static boolean found;
	static int[] row, column, square; // 각 행, 열, 사각형에 있는 숫자 bit-masking으로 표현
	static int[][] map = new int[9][9];
	static int[][] ans = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		row = new int[9];
		column = new int[9];
		square = new int[9];

		for (int i = 0; i < 9; i++) {
			String st = br.readLine();
			for (int j = 0; j < 9; j++) {
				int n = st.charAt(j) - '0';
				map[i][j] = n;
				if (n != 0) {
					row[i] = row[i] | (1 << n);
					column[j] = column[j] | (1 << n);
					int squIdx = (i / 3) * 3 + (j / 3);
					square[squIdx] = square[squIdx] | (1 << n);
				} else {
					list.add(new Node(i, j));
					cnt++; // 0인 것 개수
				}
			}
		}

		min = Integer.MAX_VALUE;
		dfs(0, 0);
	}

	private static void dfs(int count, int idx) { // count : 숫자로 바꾼 개수

		if (found) {
			return;
		}

		if (count == cnt) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			found = true;
			return;
		}

		int y = list.get(idx).y;
		int x = list.get(idx).x;

		for (int i = 1; i <= 9; i++) {
			if ((row[y] & 1 << i) != 0 || (column[x] & 1 << i) != 0 || (square[(y / 3) * 3 + (x / 3)] & 1 << i) != 0 || found) {
				continue; // 행, 열, 사각형에 이미 번호가 있으면 확인 x
			}

			// 행, 열, 사각형에 각각 번호 넣기
			map[y][x] = i;
			row[y] = row[y] | (1 << i);
			column[x] = column[x] | (1 << i);
			int squIdx = (y / 3) * 3 + (x / 3);
			square[squIdx] = square[squIdx] | (1 << i);

			dfs(count + 1, idx + 1);

			// 되돌리기
			map[y][x] = 0;
			row[y] = row[y] & ~(1 << i);
			column[x] = column[x] & ~(1 << i);
			square[squIdx] = square[squIdx] & ~(1 << i);
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
