package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//실행시간 : 1,072 ms, 메모리 : 24,076 kb
public class SW_05215_햄버거다이어트 {
	
	static class Burger {
		int score;
		int kcal;
		boolean isCheck;
	}
	
	static int T, N, L;
	static int kcalSum, scoreSum, max;
	static ArrayList<Burger> burger = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			burger.clear();
			
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());			
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				Burger b = new Burger();
				b.score = Integer.parseInt(st.nextToken());
				b.kcal = Integer.parseInt(st.nextToken());
				burger.add(b);
			}
			
			// 로직
			max = Integer.MIN_VALUE;
			burgerSub(0);
			
			// 출력
			System.out.println("#" + t + " " + max);
			
		}
	}
	
	static void burgerSub(int cnt) { // 재료 조합

		if(cnt == N) {
			kcalSum = 0;
			scoreSum = 0;
			for(Burger b : burger) {
				if(b.isCheck == true) {
					kcalSum += b.kcal;
					scoreSum += b.score;
				}
			}
			if(kcalSum <= L) {
				max = Math.max(max, scoreSum);
			}
			return;
		}
		
		burger.get(cnt).isCheck = true;
		burgerSub(cnt+1);
		burger.get(cnt).isCheck = false;
		burgerSub(cnt+1);
	}

}
