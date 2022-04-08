package algorithm.sw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA 역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq )
 */
public class SW_01953_탈주범검거_T {

	static int T, N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visit;
	// 상하좌우 순서
	static int[][] dy = {{}, {-1, 1, 0, 0}, {-1, 1, 0, 0}, {0, 0, 0, 0}, {-1, 0, 0, 0},{0, 1, 0, 0},{ 0, 1, 0, 0}, {-1, 0, 0, 0}}; //1번 - 7번
	static int[][] dx = {{}, { 0, 0,-1, 1}, { 0, 0, 0, 0}, {0, 0,-1, 1}, { 0, 0, 0, 1},{0, 0, 0, 1},{ 0, 0,-1, 0}, { 0, 0,-1, 0}};
	
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 1; // 시작위치부터 1시간
			queue.clear();
			
			visit[R][C] = true;
			queue.add(new Node(R, C, 1));
			bfs();
			
			System.out.println("#" + t + " " + ans);
		}

	}

	static boolean connect(int dir, int to) {
		// dir 이 상하좌우로 움직이려고 할 때 받아줄 수 있는 to 인지 확인
		if( to == 1 ) return true;
		switch(dir) {
			case 0: if( to == 2 || to == 5 || to == 6 ) return true; break; // 상
			case 1: if( to == 2 || to == 4 || to == 7 ) return true; break; // 하
			case 2: if( to == 3 || to == 4 || to == 5 ) return true; break; // 좌
			case 3: if( to == 3 || to == 6 || to == 7 ) return true; break; // 우
		}
		return false;
	}
	static void bfs() {
		while( !queue.isEmpty() ) {
			Node node = queue.poll();
			if( node.d == L ) return;
			
			int current = map[node.y][node.x];
			int[] deltaY = dy[current];
			int[] deltaX = dx[current];
			
			for (int d = 0; d < 4; d++) {
				if(deltaY[d] == 0 && deltaX[d] == 0 ) continue; // 이부분이 없어도 되긴함. visit에서 체크가 됨
				int ny = node.y + deltaY[d];
				int nx = node.x + deltaX[d];
				
				if( ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] ) continue;
				
				int next = map[ny][nx];
				if( next == 0 || !connect(d, next) ) continue;
				
				visit[ny][nx] = true;
				ans++;
				queue.add(new Node(ny, nx, node.d+1 ));
			}
		}
	}
	
	static class Node{
		int y;
		int x;
		int d;
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

}
