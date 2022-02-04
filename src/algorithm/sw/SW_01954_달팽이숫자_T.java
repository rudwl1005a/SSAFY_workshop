package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_01954_달팽이숫자_T {
	
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
			int y = 0;
			int x = 0;
			int d = 0; // 방향
			int num = 1; // 배열에 넣는 증가하는 수
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					snail[y][x] = num++;
					
					if(d==0) { // 우
						if( x+dx[d]	>= N || snail[y][x+dx[d]] != 0) {
							d = 1; // 방향전환
						}
					} else if(d==1) { // 하
						if( y+dy[d]	>= N || snail[y+dy[d]][x] != 0) {
							d = 2; // 방향전환
						}
					} else if(d==2) { // 좌
						if( x+dx[d]	< 0 || snail[y][x+dx[d]] != 0) {
							d = 3; // 방향전환
						}
					} else if(d==3) { // 상
						if( y+dy[d]	< 0 || snail[y+dy[d]][x] != 0) {
							d = 0; // 방향전환
						}
					}
					
					x += dx[d];
					y += dy[d];
				}
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
