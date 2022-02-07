package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_09229_한빈이와SpotMart_T {

	static int T, N, M, max;
	static int[] src, tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			max = -1;

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			src = new int[N];
			tgt = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		if(tgtIdx == 2){
			// complete code
			int sum = tgt[0] + tgt[1];
			if(sum > M) return;
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=srcIdx; i<src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}
	}

}
