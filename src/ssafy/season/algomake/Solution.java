package ssafy.season.algomake;

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static boolean FINISHED;			// 순열에서 k번째 암호를 찾았는지 여부
	static int T,N,M,K;					// T: 테스트 케이스 수, N: 배열 세로 길이, M: 배열 가로 길이, K: 찾아야하는 암호의 순서
	static long ans;					// ans: 정답 (k번째 암호)
	
	static List<Integer> list = null;	// 배열에서 찾은 숫자를 저장할 리스트
	static char[][] arr = null;			// 지도를 저장할 배열
	static boolean[] used = null;		// 순열 생성 시, 숫자의 사용 여부를 체크하기 위한 배열
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			input();
			func();
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void func() {
		BFS();								// 1. BFS 돌리기
		Collections.sort(list);				// 2. 찾은 숫자 오름차순 정렬
		
		used = new boolean[list.size()];	// 3. 순열 생성하기
		permutation(0,0);
	}

	static void BFS() {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new ArrayDeque<>();		
		
		q.add(new Point(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			// 인접한 상하좌우 네 칸 탐색
			for(int dir = 0; dir<4; dir++) {
				int nx = now.x+dx[dir];
				int ny = now.y+dy[dir];
				
				// 다음 칸이 벽 또는 방문한 칸이면 continue;
				if(nx<0||nx>=N||ny<0||ny>=M||visited[nx][ny] || arr[nx][ny]=='#') continue;
				char next = arr[nx][ny];
				
				// 다음 칸이 숫자이면 list에 추가
				if(next >='0' && next <= '9')
					list.add(next - '0');
				
				// 다음 탐색할 칸 queue에 삽입
				q.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}

	static void permutation(int cnt, long n) {
		// 순열 생성 완료했으면
		if(cnt == list.size()) {
			// K번째 암호를 찾았으면 더 이상 순열 돌지 않기
			if(--K == 0) {
				ans = n;
				FINISHED = true;
			}
			return;
		}
		
		// 순열 생성하기
		for(int i = 0; i<list.size(); i++) {
			// K번째 암호를 찾았으면 더 이상 순열 돌지 않기
			if(FINISHED) break;
			
			int num = list.get(i);
			if(used[i]) continue;
			used[i] = true;
			permutation(cnt+1, n*10+num);
			used[i] = false;
		}
	}

	// 입력 처리
	static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 전역 변수 초기화
		list = new ArrayList<>();
		arr = new char[N][M];
		FINISHED = false;
		
		// 배열 입력 받기
		for(int i = 0; i<N; i++) 
			arr[i] = br.readLine().toCharArray();
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}	

