package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B1 ( https://www.acmicpc.net/problem/2839 )
 */
public class BJ_02839_설탕배달_T {
	
	static int N, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		while(true) {
			if(N < 0) {
				System.out.println(-1);
				break;
			}
			
			if(N % 5 == 0) {
				System.out.println(N/5 + count);
				break;
			} else {
				N -= 3;
				count++;
			}
		}
	}

}
