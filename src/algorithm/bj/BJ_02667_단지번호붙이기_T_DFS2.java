package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_02667_단지번호붙이기_T_DFS2 {
	
	static char[][] map;
	static int N, cnt;
//	static boolean[][] visit;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static ArrayList<Integer> al = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
//		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != '1') continue;
				cnt = 0;
				dfs(i,j);
				
				al.add(cnt);
			}
		}
		
		Collections.sort(al);
		System.out.println(al.size());
		for(int n : al) {
			System.out.println(n);
		}
		
	}
	
	static void dfs(int y, int x) {
		cnt++;
//		visit[y][x] = true;
		map[y][x] = '0'; // 지나온곳 0으로 고치자!

		// 사방 탐색
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N)	continue;
			if (map[ny][nx] != '1') continue;

			dfs(ny, nx);
		}
		
	}
	
}
