package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_02563_색종이 {
	
	static int N, x, y, count;
	static int[][] area = new int[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					if(area[j][k] != 1) {
						count++;
						area[j][k] = 1;
					}
				}
			}
		}
		System.out.println(count);
	}

}
