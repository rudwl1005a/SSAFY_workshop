package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * SWEA D3 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0 )
 */
public class SW_06808_규영이와인영이의카드게임 {

	static int T, win, lose; // 이긴횟수, 진횟수
	static int[] GY; // 규영이의 카드 순서
	static ArrayList<Integer> IY; // 인영이의 카드
	static boolean[] isCheck;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			win = 0; lose = 0;
			GY = new int[9];
			IY = new ArrayList<>();
			for (int i = 1; i <= 18; i++) {
				IY.add(i);
			}
			isCheck = new boolean[9];
			
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				GY[i] = Integer.parseInt(st.nextToken());
				
				// 규영이가 가지고 있는 카드 인영이 카드 더미에서 제거
				if(IY.contains(GY[i])) {
					IY.remove(IY.indexOf(GY[i]));
				}
			}
			
			check(0, 0, 0);
			
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}
	
	static void check(int cnt, int gyScore, int iyScore) {
		
		// 기저 조건
		if(cnt == 9) {
			if(iyScore > gyScore) lose++;
			else if(iyScore < gyScore) win++;
			return;
		}
		
		// 순열로 접근하여 비교
		for(int i=0; i<9; i++) {
			if(isCheck[i]) continue;
			
			if(GY[cnt] > IY.get(i)) {
				isCheck[i] = true;
				check(cnt + 1, gyScore + GY[cnt] + IY.get(i), iyScore);
				isCheck[i] = false;
			}
			else{
				isCheck[i] = true;
				check(cnt + 1, gyScore, iyScore + GY[cnt] + IY.get(i));
				isCheck[i] = false;
			}
		}

	}

}
