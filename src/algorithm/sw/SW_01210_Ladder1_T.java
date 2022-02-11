package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_01210_Ladder1_T {

	static int T, ans, x, y;
	static int[][] ladder = new int[100][100];
	static int[] dy = {0, 0, -1}; // 좌, 우, 위
	static int[] dx = {-1, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			T = Integer.parseInt(br.readLine());
			// 입력
			StringTokenizer st;
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작 좌표
			y = 99;
			for(int i=0; i<100; i++) {
				if(ladder[y][i] == 2) x = i;
			}
			
			// 탐색
			int dir = 2; // 위(delta)
			while(true) {
				// 위로 가는 상태
				if(dir == 2) {
					
					// 왼 -> 오 -> 위
					for(int d=0; d<3; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						
						if(ny >=0 && nx >= 0 && nx<100 && ladder[ny][nx] == 1) {
							y = ny; x = nx;
							dir = d; // 방향전환 (혹은 그대로)
							break;
						}
					}
					
				} else if(dir == 0 || dir == 1) { // 옆으로 가는 상태 
					// 위로 갈 수 있는지 확인
					int ny = y + dy[2];
					int nx = x + dx[2];
					
					if(ny >= 0 && ladder[ny][nx] == 1) {
						y = ny; x = nx; dir = 2;
					} else {
						ny = y + dy[dir];
						nx = x + dx[dir];
					}
				}
				
				if(y == 0) {
					ans = x;
					break;
				}
			}
			
			System.out.println("#" + T + " " + ans);
		}
	}
}
