package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_01873_상호의배틀필드_T {
	
	static int T, N, H, W;
	static char[][] map;
	static int ty, tx; // 전차의 위치

	static int dy[] = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int dx[] = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
//			map = new char[H][W]; // 메모리 낭비가 생김
			map = new char[H][];
			
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
				
				// 전차
				for(int j=0; j<W; j++) {
					switch(map[i][j]) {
						case '<':
						case '>':
						case '^':
						case 'v':
							ty = i;
							tx = j;
							break;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			String oper = br.readLine();
			
			for(int i=0; i<N; i++) {
				char c= oper.charAt(i);
				
				switch(c) {
				case 'U':
					map[ty][tx] = '^';
					move(0);
					break;
				case 'D':
					map[ty][tx] = 'v';
					move(1);
					break;
				case 'L':
					map[ty][tx] = '<';
					move(2);
					break;
				case 'R':
					map[ty][tx] = '>';
					move(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			
			// 출력
			System.out.print("#" + t + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}

	static void move(int dir) { // dir : delta의 index
		int ny = ty + dy[dir];
		int nx = tx + dx[dir];
		
		// 범위 체크
		if( ny<0 || nx<0 || ny>=H || nx>=W ) return;
		
		// 평지 체크
		if(map[ny][nx] == '.') {
			map[ny][nx] = map[ty][tx];
			map[ty][tx] = '.';
			
			ty = ny;
			tx = nx;
		}
	}
	
	static void shoot() {
		int dir = 0;
		switch(map[ty][tx]) {
			case '^': dir = 0; break;
			case 'v': dir = 1; break;
			case '<': dir = 2; break;
			case '>': dir = 3; break;
		}
		
		// 포탄 위치
		int ny = ty;
		int nx = tx;
		
		while(true) {
			ny = ny + dy[dir];
			nx = nx + dx[dir];
			
			if( ny<0 || nx<0 || ny>=H || nx>=W ) return;
			
			// 벽 체크
			if(map[ny][nx] == '*') {
				map[ny][nx] = '.';
				return;
			} else if(map[ny][nx] == '#') {
				return;
			}
		}
	}

}
