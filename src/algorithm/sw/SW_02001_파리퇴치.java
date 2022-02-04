package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_02001_파리퇴치 {

	static int T, N, M;
	static String[][] fly;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			fly = new String[N][];
			for(int i=0; i<N; i++) {
				fly[i] = br.readLine().split(" ");
			}
			
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					sum = 0;
					int ni = i+M;
					int nj = j+M;
					int tmp = 0;
					for(int k=i; k<ni; k++) {
						for(int l=j; l<nj; l++) {
							tmp = Integer.parseInt(fly[k][l]);
							sum += tmp;
						}
					}
					if(sum>max) max=sum;
				}
			}
			
			// 출력
			System.out.println("#" + t + " " + max);
		}
		
	}

}
