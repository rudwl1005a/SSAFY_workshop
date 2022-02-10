package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_02267_단지번호붙이기 {
	
	static int N, apartNum = 0;
	static char[][] apart;
	static boolean[][] visited;
	static int[] answer; // 단지당 집 수
	static int[] dy = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dx = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		apart = new char[N][];
		for(int i=0; i<N; i++) {
			apart[i] = br.readLine().toCharArray();
		}
		
//		bfs();
		dfs();
		
	}
	
	// BFS로 풀기
	static void bfs() {
		// 초기화
		Queue<int[]> queue = new LinkedList<>();
		visited = new boolean[N][N];
		answer = new int[N*N];
		
		// 로직
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 아파트에서 처음 만나는 집
				if(visited[i][j] == false && apart[i][j] == '1') {
					apartNum++;
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
					answer[apartNum] = 1;
					
					// bfs
					while(!queue.isEmpty()) {
						int[] temp = queue.poll();
						
						for(int k=0; k<4; k++) {
							int ny = temp[0] + dy[k];
							int nx = temp[1] + dx[k];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
							if(visited[ny][nx] == false && apart[ny][nx] == '1') {
								visited[ny][nx] = true;
								answer[apartNum]++;
								queue.offer(new int[] {ny, nx});
							}
						}
					}
				}
			}
		}
		
		// 출력
		Arrays.sort(answer);
		sb.append(apartNum).append("\n");
		for(int n : answer) {
			if(n != 0) sb.append(n).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	
	// DFS로 풀기
	static void dfs() {
		// 초기화
		visited = new boolean[N][N];
		answer = new int[N*N];
		
		// 로직
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] == false && apart[i][j] == '1') {
					apartNum++;
					answer[apartNum] = 0;
					dfs(i,j);
				}
			}
		}
		
		// 출력
		Arrays.sort(answer);
		sb.append(apartNum).append("\n");
		for(int n : answer) {
			if(n != 0) sb.append(n).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	static void dfs(int y, int x) {
		// dfs
		visited[y][x] = true;
		answer[apartNum]++;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if (visited[ny][nx] == false && apart[ny][nx] == '1') {
				dfs(ny, nx);
			}
		}

	}

}
