package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_01954_달팽이숫자_T2 {
	
	static int T, N;
	static int[][] snail;
	
	// 우 하 좌 상
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			
			// 초기 세팅
			int dir = 1; // 1이면 증가, -1이면 감소
			int count = N;
			int num = 1;
			
			int y = 0;
			int x = -1;
			while( num <= N*N ) {
				// 우 시작하지만, 계속 좌, 우 반복
				for(int i=0; i<count; i++) {
					x += dir;
					snail[y][x] = num++;
				}
				
				count--; // 이동 거리 1 줄인다.
				
				for(int i=0; i<count; i++) {
					y += dir;
					snail[y][x] = num++;
				}
				
				dir = dir * (-1);
			}
			
			// 출력
			System.out.println("#" + t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
