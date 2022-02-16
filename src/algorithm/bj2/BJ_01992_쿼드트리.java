package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1992 )
 */
public class BJ_01992_쿼드트리 {

	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		check(N / 2, N / 2, N / 2);

		System.out.println(sb);
	}

	private static void check(int y, int x, int depth) {

		if (depth == 1) {
			if (map[y - 1][x - 1] == '0' && map[y - 1][x] == '0' && map[y][x - 1] == '0' && map[y][x] == '0') {
				sb.append("0");
			} else if (map[y - 1][x - 1] == '1' && map[y - 1][x] == '1' && map[y][x - 1] == '1' && map[y][x] == '1') {
				sb.append("1");
			} else {
				sb.append("(").append(map[y - 1][x - 1]).append(map[y - 1][x]).append(map[y][x - 1]).append(map[y][x]).append(")");
			}
			return;
		}

		sb.append("(");
		
		depth /= 2;

		check(y - depth, x - depth, depth);
		check(y - depth, x + depth, depth);
		check(y + depth, x - depth, depth);
		check(y + depth, x + depth, depth);
		
		int size = sb.length();
		if(sb.substring(size-4, size).equals("0000")) {
			sb.setLength(size-5);
			sb.append("0");
		} else if(sb.substring(size-4, size).equals("1111")) {
			sb.setLength(size-5);
			sb.append("1");
		} else {
			sb.append(")");			
		}

		

	}

}
