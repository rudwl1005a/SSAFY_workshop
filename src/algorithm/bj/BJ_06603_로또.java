package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// StringBuilder 썼을때 - 메모리: 14252KB, 시간: 140ms
// StringBuilder 안썼을때 - 메모리: 24432KB, 시간: 404ms
public class BJ_06603_로또 {
	
	static int N;
	static int[] pick;
	static int[] lotto = new int[6];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			pick = new int[N];
			if(N == 0) break;
			for(int i=0; i<N; i++) {
				pick[i] = Integer.parseInt(st.nextToken());
			}
			
			pickLotto(0, 0);
			sb.append("\n");
		}
		
		sb.setLength(sb.length()-2); // 만약 테케 출력본에서 마지막 개행 두개를 없애고 싶다면!
		System.out.println(sb);
	}
	
	static void pickLotto(int pCnt, int lCnt) {
		// 기저조건
		if(lCnt == lotto.length) {
			for(int n : lotto) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		if(pCnt == N) return;
		
		// 조합
		lotto[lCnt] = pick[pCnt];
		pickLotto(pCnt + 1, lCnt + 1);
		pickLotto(pCnt + 1, lCnt);
	
	}

}
