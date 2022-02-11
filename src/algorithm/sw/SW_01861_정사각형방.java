package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA D4 (https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc)
 */
public class SW_01861_정사각형방 {
	
	static int[] dy = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dx = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	static int T, N, count;
	static int max, minRoom; // 가장 많이 이동할수 있는 방의 수, 동률일때 가장 작은 수
	static int[][] room;
	// visit 됐다면 현재보다 작은 수 부터 확인을 했었던 수이기 때문에 무조건 작은 수 보다 이동할 수 있는 방의 수가 작아서 확인할 필요가 없다.
	static boolean[][] visit;
	static Queue<Node> q = new ArrayDeque<>();
	
	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			visit = new boolean[N][N];
			max = Integer.MIN_VALUE;
			minRoom = Integer.MAX_VALUE;
			
			// 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 로직
//			bfs();
			dfs();
			
			// 출력
			System.out.println("#" + t + " " + minRoom + " " + max);
		}
		
	}

	// BFS로 풀기
	static void bfs() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]) continue;
				q.add(new Node(i,j));
				count = 1;
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					
					for(int d=0; d<4; d++) {
						int ny = node.y + dy[d];
						int nx = node.x + dx[d];
						
						if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
						if(room[node.y][node.x] + 1 == room[ny][nx]) {
							visit[ny][nx] = true;
							count++;
							q.offer(new Node(ny,nx));
						}
					}
				}
				
				if(max < count) {
					minRoom = room[i][j];
				} else if(max == count) {
					minRoom = Math.min(minRoom, room[i][j]);
				}
				max = Math.max(max, count);
			}
		}
	}

	// DFS로 풀기
	static void dfs() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]) continue;
				count = 0;
				dfs(i, j);
				
				if(max < count) {
					minRoom = room[i][j];
				} else if(max == count) {
					minRoom = Math.min(minRoom, room[i][j]);
				}
				max = Math.max(max, count);
			}
		}
	}
	static void dfs(int y, int x) {
		count++;
		visit[y][x] = true;
		
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			if(room[y][x] + 1 == room[ny][nx]) {
				dfs(ny, nx);
			}
		}
		
	}
}
