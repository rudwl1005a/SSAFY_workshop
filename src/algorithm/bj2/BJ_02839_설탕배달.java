package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B1 ( https://www.acmicpc.net/problem/2839 )
 */
public class BJ_02839_설탕배달 {
	
	static int N, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean isBreak = false;
		N = Integer.parseInt(br.readLine());
		while(!isBreak) {
			// N킬로그램 만들 수 없다면
			if(N < 0) {
				System.out.println("-1");
				return;
			}
			switch(N%5) {
				case 4:
					if(N == 9) {
						isBreak = true;
						count += 3;
						break;
					}
					N -= 5;
					count++;
					break;
				case 3:
					if(N == 3) {
						isBreak = true;
						count++;
						break;
					}
					N -= 5;
					count++;
					break;
				case 2:
					if(N == 12) {
						isBreak = true;
						count += 4;
						break;
					}
					N -= 5;
					count++;
					break;
				case 1:
					if(N == 6) {
						isBreak = true;
						count += 2;
						break;
					}
					N -= 5;
					count++;
					break;
				case 0:
					count += (N/5);
					N = 0;
					isBreak = true;
					break;
				}
		}
		
		System.out.println(count);
	}

}
