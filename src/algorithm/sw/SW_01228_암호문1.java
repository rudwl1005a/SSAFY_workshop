package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_01228_암호문1 {
	
	static int N, M, X, Y; // N: 원본 암호문의 길이, M: 명령어 갯수, X: 넣을 위치, Y: 넣을 숫자 갯수
	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> tmpList = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			
			// 초기화
			list.clear();
			tmpList.clear();
			
			// 입력 처리
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			// 로직
			for(int i=0; i<M; i++) {
				String I = st.nextToken(); // I는 쓸모 없다.
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				for(int j=0; j<Y; j++) {
					tmpList.add(Integer.parseInt(st.nextToken()));
				}
				
				list.addAll(X,tmpList);
				tmpList.clear();
			}
			
			// 출력
			System.out.print("#" + t + " ");
			for(int i=0; i<10; i++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println();
		}
	}

}
