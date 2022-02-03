package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_01289_원재의메모리복구하기2 {
	
	static int T;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테케 입력 처리
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 테케 별 입력  - 풀이 - 출력
			int count = 0;
			
			// 입력 문자열 처리 - 입력자료구조(배열...)
			arr = br.readLine().toCharArray(); // => 코드길이 짧게 가능
			
			// 풀이
			char flag = '0'; // 바뀌는지 안바뀌는지 확인
			int cnt = arr.length;
			for(int i=0; i<cnt; i++) { // arr.length를 for문 안에서 쓰지 않는 이유는 매번 참조를 하기 때문에 시간이 더 걸리기 때문이다.
				if(flag != arr[i]) {
					count++;
					flag = arr[i];
				}
			}
			
			// 출력
			System.out.println("#" + t + " " + count);
		}
		
	}

}
