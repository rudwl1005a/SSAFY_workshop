package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_01225_암호생성기_T {
	
//	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> queue = new ArrayDeque<>(); // 이것도 사용가능 - 좀 더 빠르다
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {

			// 탈출조건
			String tc = br.readLine();
			if(tc == null || tc.length() == 0) break;
			
			// 초기화
			queue.clear();
			
			// 입력처리
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			make();
			
			// 출력
			System.out.print("#" + tc + " ");
			for(int num : queue) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	
	}
	
	static void make() {
		
		int num = 0;
		while(true) {
			// cycle
			for(int i=1; i<=5; i++) {
				num = queue.poll() - i; // 맨 앞에서 숫자 뺀 값
				// 0 체크
				if(num <= 0) {
					queue.offer(0);
					return;
				}
				queue.offer(num);
			}
		}
		
	}

}
