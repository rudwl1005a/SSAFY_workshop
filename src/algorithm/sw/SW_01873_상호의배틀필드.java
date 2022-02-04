package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_01873_상호의배틀필드 {
	
	static int T, N, H, W;
	static char[][] Field;
	static char[] Input;
	
	static int dy[] = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int dx[] = { 0, 1, 0, -1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력 처리
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			Field = new char[H][W];
			for(int i=0; i<H; i++) {
				Field[i] = br.readLine().toCharArray();
			}
			N = Integer.parseInt(br.readLine());
			Input = new char[N];
			Input = br.readLine().toCharArray();
			
			// 탱크 초기 위치, 방향
			int curX = 0;
			int curY = 0;
			int curD = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(Field[i][j] == '^') {
						curX = j; curY = i; curD = 0;
					} else if(Field[i][j] == '>') {
						curX = j; curY = i; curD = 1;
					} else if(Field[i][j] == 'v') {
						curX = j; curY = i; curD = 2;
					} else if(Field[i][j] == '<') {
						curX = j; curY = i; curD = 3;
					}
				}
			}
			
			// 유저 입력 처리
			int bullX = curX; // 포탄 위치
			int bullY = curY;
			for(int i=0; i<N; i++) {
				if(Input[i] == 'U') {
					curD = 0;
					if(curY+dy[curD] >= 0) {
						if(Field[curY+dy[curD]][curX] == '.') {
							Field[curY+dy[curD]][curX] = '^';
							Field[curY][curX] = '.';
							curY += dy[curD];
							bullY += dy[curD];
						} else {
							Field[curY][curX] = '^';
						}
					} else {
						Field[curY][curX] = '^';
					}
				} else if(Input[i] == 'D') {
					curD = 2;
					if(curY+dy[curD] < H) {
						if(Field[curY+dy[curD]][curX] == '.') {
							Field[curY+dy[curD]][curX] = 'v';
							Field[curY][curX] = '.';
							curY += dy[curD];
							bullY += dy[curD];
						} else {
							Field[curY][curX] = 'v';
						}
					} else {
						Field[curY][curX] = 'v';
					}
				} else if(Input[i] == 'L') {
					curD = 3;
					if(curX+dx[curD] >= 0) {
						if(Field[curY][curX+dx[curD]] == '.') {
							Field[curY][curX+dx[curD]] = '<';
							Field[curY][curX] = '.';
							curX += dx[curD];
							bullX += dx[curD];
						} else {
							Field[curY][curX] = '<';
						}
					} else {
						Field[curY][curX] = '<';
					}
				} else if(Input[i] == 'R') {
					curD = 1;
					if(curX+dx[curD] < W) {
						if(Field[curY][curX+dx[curD]] == '.') {
							Field[curY][curX+dx[curD]] = '>';
							Field[curY][curX] = '.';
							curX += dx[curD];
							bullX += dx[curD];
						} else {
							Field[curY][curX] = '>';
						}
					} else {
						Field[curY][curX] = '>';
					}
				} else if(Input[i] == 'S') {
					if(curD == 0) {
						while(bullY+dy[curD] >= 0) {
							if(Field[bullY+dy[curD]][bullX] == '*') {
								Field[bullY+dy[curD]][bullX] = '.';
								break;
							} else if(Field[bullY+dy[curD]][bullX] == '#') {
								break;
							}
							bullY += dy[curD];
						}
					} else if(curD == 1) {
						while(bullX+dx[curD] < W) {
							if(Field[bullY][bullX+dx[curD]] == '*') {
								Field[bullY][bullX+dx[curD]] = '.';
								break;
							} else if(Field[bullY][bullX+dx[curD]] == '#') {
								break;
							}
							bullX += dx[curD];
						}
					} else if(curD == 2) {
						while(bullY+dy[curD] < H) {
							if(Field[bullY+dy[curD]][bullX] == '*') {
								Field[bullY+dy[curD]][bullX] = '.';
								break;
							} else if(Field[bullY+dy[curD]][bullX] == '#') {
								break;
							}
							bullY += dy[curD];
						}
					} else if(curD == 3) {
						while(bullX+dx[curD] >= 0) {
							if(Field[bullY][bullX+dx[curD]] == '*') {
								Field[bullY][bullX+dx[curD]] = '.';
								break;
							} else if(Field[bullY][bullX+dx[curD]] == '#') {
								break;
							}
							bullX += dx[curD];
						}
					}
					bullX = curX; bullY = curY;
				}
			}
			
			// 출력
			System.out.print("#" + t + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(Field[i][j]);
				}
				System.out.println();
			}
			
		}
	}

}
