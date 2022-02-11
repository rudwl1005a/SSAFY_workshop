package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_01233_사칙연산유효성검사_T {
	
	static int N, ans;
	static char[] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			
			// 두번째만 처리
			for(int i=1; i<=N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}
			
			// 유효성 검사
			int no = N;
			ans = 1;
			
			while( no != 1) {
				// 유효하지 않은 조건
				if(!isNum(no) || !isNum(no-1) || isNum(no/2)) {
					ans = 0;
					break;
				}
				
				node[no/2] = '1'; // 연산자 숫자로 바꿔주기
				
				no -= 2;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static boolean isNum(int idx) {
		return Character.isDigit(node[idx]);
	}

}
