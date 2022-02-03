package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_01954_달팽이숫자 {
	
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			int cnt=1; // 저장할 숫자

			// 예외사항 먼저 저장
			for(int i=0; i<n-1; i++) {
				arr[0][i] = cnt++;
			}
			
			int direct = 1; // 0이면 오른쪽, 1이면 아래쪽, 2면 왼쪽, 3이면 위쪽 방향
			int m = 0; // 몇번 꺾었는지, 2가 되면 전진하는 정도 -1
			int k = n-1; // 전진하는 정도
			// for index
			int i = 0;
			int j = n-1;
			
			// 나머지 사항 저장
			while(true) {
				if(direct == 0) {
					for(int l = 0; l < k; l++) {
						arr[i][j] = cnt++;
						if(j<n-1) j++;
					}
					m++;
					direct++;
				} else if(direct == 1) {
					for(int l = 0; l < k; l++) {
						arr[i][j] = cnt++;

						if(i<n-1) i++;
					}
					m++;
					direct++;
				} else if(direct == 2) {
					for(int l = 0; l < k; l++) {
						arr[i][j] = cnt++;

						if(j>0) j--;
					}
					m++;
					direct++;
				} else if(direct == 3) {
					for(int l = 0; l < k; l++) {
						arr[i][j] = cnt++;
						if(i>0) i--;
					}
					m++;
					direct = 0;
				}
				
				if(m == 2) {
					if(k==0) {
						// 마지막 번호 저장
						if(n%2 == 0) arr[n/2][n/2 - 1] = cnt; 							
						else arr[n/2][n/2] = cnt; 
						break;
					}
					k--;
					m = 0;
				}
			}
			
			System.out.println("#" + t);
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
			
		}
	}

}
