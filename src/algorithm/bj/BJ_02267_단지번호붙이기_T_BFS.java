package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class BJ_02267_단지번호붙이기_T_BFS {
	
	static char[][] map;
	static int N, cnt;
	static boolean[][] visit;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static Queue<Node> queue = new ArrayDeque<>();
	static ArrayList<Integer> al = new ArrayList<>();
	
	static class Node{
		int y,x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != '1' || visit[i][j]) continue;
				bfs(i,j);
				
				al.add(cnt);
			}
		}
		
		Collections.sort(al);
		System.out.println(al.size());
		for(int n : al) {
			System.out.println(n);
		}
		
	}
	
	static void bfs(int y, int x) {
		cnt = 1; // 새로운 단지의 시작
		visit[y][x] = true;
		queue.offer(new Node(y, x));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			// 사방 탐색
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(visit[ny][nx] || map[ny][nx] != '1') continue;
				
				cnt++; // 단지 내 집cnt 증가
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx));
			}
		}
		
		
	}
	
}
