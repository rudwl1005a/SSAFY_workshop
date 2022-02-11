package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_01233_사칙연산유효성검사 {
	
	static int N, node, lNode, rNode; // 정점 번호, 왼쪽자식 번호, 오른쪽 자식 번호
	static char info; // 노드 내용
	static boolean ans; // 유효성 검사
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			// 초기화
			ans = true;
			
			N = Integer.parseInt(br.readLine());
			// 자식이 있는 노드만 검사
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				node = Integer.parseInt(st.nextToken());
				info = st.nextToken().charAt(0);
				lNode = Integer.parseInt(st.nextToken());
				if(lNode == N) break;
				rNode = Integer.parseInt(st.nextToken());
				if(rNode == N) break;
				if(info >= 48 && info <=57) ans = false;
			}
			
			// 자식이 없는 노드 검사(리프 노드)
			for (int i = node; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				node = Integer.parseInt(st.nextToken());
				info = st.nextToken().charAt(0);
				if(!(info >= 48 && info <=57)) ans = false;
			}
			
			if(ans) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
		}
	}

}
