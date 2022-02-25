package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/15686 )
 */
public class BJ_15686_치킨배달2 {

	static int N, M, min, cN, dN;
	static int[][] map;
	static ArrayList<Node> chicken = new ArrayList<>();
	static boolean[] pick; // 몇번째 치킨집

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 치킨집 최대 개수

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					cN++; // 치킨 집 개수
					chicken.add(new Node(i, j));
				}
			}
		}

		dN = cN - M; // 폐업시켜야 할 치킨집 수
		
		pick = new boolean[cN];
		min = Integer.MAX_VALUE;
		
		// 조합으로 dN개 뽑아서 비교
		comb(0, 0);
		
		System.out.println(min);
	}

	private static void comb(int srcIdx, int tgtIdx) {
		
		if(tgtIdx == dN) {
			int minDis = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						minDis += chickenDis(i, j, pick);
					}
				}
			}
			
			min = Math.min(min, minDis);
			
			return;
		}
		if(srcIdx == cN) {
			return;
		}
		
		pick[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1);
		
		pick[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx);
		
	}
	
	private static int chickenDis(int i, int j, boolean[] pick2) {
		int distance = Integer.MAX_VALUE;
		
		// 가장 짧은 치킨집과의 거리 찾기
		for (int k = 0; k < chicken.size(); k++) {
			if(pick2[k]) {
				continue;
			}
			int d = Math.abs(i - chicken.get(k).y) + Math.abs(j - chicken.get(k).x);
			distance = Math.min(distance, d);
		}
		
		return distance;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
