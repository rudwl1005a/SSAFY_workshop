package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분집합
public class SW_05215_햄버거다이어트_T2 {
	
	static int T, N, L, max;
	static Item[] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			max = 0;
			
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			src = new Item[N];
			select = new boolean[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 부분집합
			subset(0);
			
			
			System.out.println("#" + t + " " + max);
		}
		
	}

	static void subset(int srcIdx) {
		// 기저조건
		if(srcIdx == N) {
			// complete code
			int cal = 0;
			int point = 0;
			
			// 칼로리의 합
			for(int i=0; i<N; i++) {
				if(select[i]) {
					cal += src[i].c;
					point += src[i].p;
				}
			}
			
			// 체크
			if(cal <= L) max = Math.max(max, point);
			
			return;
		}
		
		// 선택
		select[srcIdx] = true;
		subset(srcIdx+1);
		
		select[srcIdx] = false;
		subset(srcIdx+1);
		
	}

	static class Item{
		int p; // 점수
		int c; // 칼로리
		
		public Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
		
	}
}
