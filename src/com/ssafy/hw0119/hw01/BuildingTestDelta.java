package com.ssafy.hw0119.hw01;

import java.io.FileInputStream;
import java.util.Scanner;

public class BuildingTestDelta {
	public static void main(String[] args) throws Exception {
		String path = BuildingTestDelta.class.getResource("").getPath();
		System.setIn(new FileInputStream(path + "/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// delta
		int dy[] = { -1, -1, 0, 1, 1,  1,  0, -1,};
		int dx[] = {  0,  1, 1, 1, 0, -1, -1, -1 }; // 위에서부터 시계방향
		
		for(int t = 1; t <= T; t++) {
			
			// 테케별 
			int max = 2; // 최소 빌딩높이는 2층이다.
			int N = sc.nextInt();
			char[][] area = new char[N][N];
			
			// 테케별 area 설정
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			
			// delta
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					boolean isPark = false;
					if(area[i][j] == 'B') {
						// delta
						for(int d = 0; d < 8; d++) {
							int nx = i + dy[d];
							int ny = j + dx[d];
							if( ny < 0 || nx < 0 || nx >= N || ny >= N) continue;
							if( area[nx][ny] == 'G' ) {
								isPark = true;
								break;
							}
						}
						if(!isPark) {
							for(int k=0; k<N; k++) {
								if(area[i][k] == 'B') cnt++;
							}						
							for(int k=0; k<N; k++) {
								if(area[k][j] == 'B') cnt++;
							}
							if(max<cnt-1) {
								max=cnt-1;
							}
							cnt=0;							
						}
					}
				}
			}
			// 출력
			System.out.println("#" + t + " " + max);
		}
		
		sc.close();
	}
}
