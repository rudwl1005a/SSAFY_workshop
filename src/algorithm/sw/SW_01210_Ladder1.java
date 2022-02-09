package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_01210_Ladder1 {

	static int T, ans, x, y;
	static int[][] ladder = new int[100][100];
	static StringBuilder sb = new StringBuilder();
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
					if(ladder[i][j] == 2) {
						y = i; x = j; // 정답부터 올라가기
					}
				}
			}
			
			// 로직
			while(true) {
				for(int i=0; i<3; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || nx >= 100 || ny <0 || ny >= 100) continue;
					if(ladder[ny][nx] == 1) {
						ladder[ny][nx] = 0;
						y = ny; x = nx;
						break;
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
