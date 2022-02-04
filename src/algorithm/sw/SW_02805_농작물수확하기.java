package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_02805_농작물수확하기 {

	static int T, N, mid, sum;
	static char[][] parm;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			parm = new char[N][];
			for(int i=0; i<N; i++) {
				parm[i] = br.readLine().toCharArray();
			}
			mid = N/2;
			sum = 0;
			for(int i=0; i<N; i++) {
				for(int j=mid; j<N-mid; j++) {
					int tmp = parm[i][j] - '0';
					sum += tmp;
				}
				if(i<N/2) mid--;
				else mid++;
			}
			
			System.out.println("#" + t + " " + sum);
		}
		
	}

}
