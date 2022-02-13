package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 실버2 ( https://www.acmicpc.net/problem/16926 )
 */
public class BJ_16926_배열돌리기1 {
	
	static int N, M, R;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 로직
		for(int i=0; i<R; i++) {
			rotation();
		}
		
		// 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotation() {
		// 맨 바깥쪽 사각형
		int sy = 0; int ey = N - 1;
		int sx = 0; int ex = M - 1;
		
		while(true) { // 맨 안쪽 사각형일 때 까지 반복
			
			if(ey - sy < 1 || ex - sx < 1) return;
			
			int temp = arr[sy][sx]; // 왼쪽 맨 위 저장
			
			// 위, 오른쪽, 아래, 왼쪽 순으로 한칸씩 이동시키기
			for(int i = sx; i < ex; i++)
				arr[sy][i] = arr[sy][i+1];
			for(int i = sy; i < ey; i++ )
				arr[i][ex] = arr[i+1][ex];
			for(int i = ex; i > sx; i--)
				arr[ey][i] = arr[ey][i-1];
			for(int i = ey; i > sy; i--)
				arr[i][sx] = arr[i-1][sx];
			
			// 원래 왼쪽 맨 위 저장되어있던 데이터 한칸 이동한 곳에 저장
			arr[sy + 1][sx] = temp;
			
			// 한칸 안쪽 사각형도 회전
			sy++; sx++; ey--; ex--;
		}
		
	}

}
