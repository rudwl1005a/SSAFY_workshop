package com.ssafy.ws02.step3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BuildTestInput.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			// 테케별 
			int max = 2; // 최소 빌딩높이는 2층이다.
			int N = sc.nextInt();
			char[][] area = new char[N+2][N+2];
			
			// 테케별 area 설정
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			
			// 가장 높은 빌딩 설정
			int cnt = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(area[i-1][j-1] != 'G' && area[i-1][j] != 'G' && area[i-1][j+1] != 'G'
							&& area[i][j-1] != 'G' && area[i][j+1] != 'G'
							&& area[i+1][j-1] != 'G' && area[i+1][j] != 'G' && area[i+1][j+1] !='G') {
						for(int k=1; k<=N; k++) {
							if(area[i][k] == 'B') cnt++;
						}						
						for(int k=1; k<=N; k++) {
							if(area[k][j] == 'B') cnt++;
						}
						if(max<cnt-1) max=cnt-1;
						cnt=0;
					}
				}
			}
			
			// 출력
			System.out.println("#" + t + " " + max);
		}
		
		
		sc.close();
	}
}
