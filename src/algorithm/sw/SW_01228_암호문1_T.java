package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_01228_암호문1_T {
	
	static int N, M;
	static LinkedList<String> list = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			
			// 초기화
			list.clear();
			
			// 입력
			N = Integer.parseInt(br.readLine()); // 1줄
			StringTokenizer st = new StringTokenizer(br.readLine()); // 2줄
			for(int i=0; i<N; i++) {
				list.add(st.nextToken());
			}
			M = Integer.parseInt(br.readLine()); // 3줄
			st = new StringTokenizer(br.readLine()); // 4줄
			
			// 로직
			for(int i=0; i<M; i++) {
				st.nextToken(); // I 처리
				int X = Integer.parseInt(st.nextToken()); // index
				int Y = Integer.parseInt(st.nextToken()); // 들어갈 문자열 수
				int size = X + Y; // x의 위치에 y개만큼 문자열 추가
				for(int j=X; j<size; j++) {
					list.add(j, st.nextToken());
				}
			}
			
			// 출력
			System.out.print("#" + t + " ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
