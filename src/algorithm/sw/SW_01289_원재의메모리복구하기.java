package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_01289_원재의메모리복구하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테케 입력 처리
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 테케 별 입력  - 풀이 - 출력
			int count = 0;
			
			// 입력 문자열 처리 - 입력자료구조(배열...)
			// char[] arr = br.readLine().toCharArray(); => 코드길이 짧게 가능
			String s = br.readLine();
			int[] arr = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}
			
			// 풀이
			int flag = 0; // 바뀌는지 안바뀌는지 확인
			for(int i=0; i<s.length(); i++) {
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
