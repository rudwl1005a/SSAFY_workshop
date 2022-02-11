package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA D4 (https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc)
 */
public class SW_01861_정사각형방_T_DFS {
	
	static int[][] map;
	static int T, N, NO, COUNT; // 방번호, 이동횟수
	
	static int[] dy = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dx = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	
	static Node node = new Node();
	
	static class Node{
		int y, x;
		int no; // 시작 방번호
		int cnt; // 방문 횟수(계속 증가)

		public Node(int y, int x, int no, int cnt) {
			this.y = y;
			this.x = x;
			this.no = no;
			this.cnt = cnt;
		}

		public Node() {}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			NO = 0;
			COUNT = 1;
			
			// 입력
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// bfs
			// 모든 방에서 한번씩 출발을 해 본다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					node.y = i;
					node.x = j;
					node.no = map[i][j];
					node.cnt = 1;
					dfs();
				}
			}
			
			// 출력
			System.out.println("#" + t + " " + NO + " " + COUNT);
		}
		
	}

	// DFS로 풀기
	static void dfs() {
		
		// 문제 풀이 코드
		if (node.cnt > COUNT) {
			COUNT = node.cnt;
			NO = node.no;
		} else if (node.cnt == COUNT) {
			NO = (node.no < NO) ? node.no : NO;
		}

		for (int d = 0; d < 4; d++) {
			int ny = node.y + dy[d];
			int nx = node.x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] != map[node.y][node.x] + 1) continue;
			
			node.y = ny;
			node.x = nx;
			node.cnt++;
			dfs();
			break;
		}

	}
}
