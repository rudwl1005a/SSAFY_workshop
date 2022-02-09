package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_03499_퍼펙트셔플 {
	
	static int T, N, mid;
	static String[] deck;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			deck = new String[N];
			mid = N/2;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 로직
			for(int i=0; i<N; i++) {
				if(N%2 == 0) {
					if(i<mid) deck[i*2] = st.nextToken();
					else deck[(i-mid)*2+1] = st.nextToken();
				}
				else {
					if(i<=mid) deck[i*2] = st.nextToken();
					else deck[(i-mid)*2-1] = st.nextToken();
				}
			}
			
			// 출력
			sb.append('#').append(t).append(" ");
			for(int i=0; i<N; i++) {
				sb.append(deck[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
