package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_09229_한빈이와SpotMart {

	static int T, N, M, max;
	static int[] snack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			snack = new int[N];
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int temp = snack[i] + snack[j];
					if(temp > max && temp <= M) max = temp;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

}
