package algorithm.jo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://jungol.co.kr/bbs/board.php?bo_table=pbank&code=2577&sca=99 )
 */
public class JO_02577_회전초밥_T {

	static int N, d, k, c, count, max;
	static int[] src;
	static int[] select = new int[3001]; // 1~3000 선택된 가지수가 몇개인지, 0 dummy

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		src = new int[N];

		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}

		// 쿠폰으로 주어진 것 먼저 처리
		select[c] = 1;
		count = 1; // 가장 큰 경우 => 답

		// 처음 k개를 선택 ( 0 ~ k - 1 )
		for (int i = 0; i < k; i++) {
			if (select[src[i]] == 0) { // 이미 있는 것이 아니라면
				count++;
			}
			select[src[i]]++; // 초밥 종류 따져서 증가
		}

		max = count;

		for (int i = k; i < N + k - 1; i++) {
			// 맨 앞접시
			int dish = src[i - k];

			select[dish]--; // 맨 앞 접시 종류를 취소
			if (select[dish] == 0) { // 취소했더니 0이면 가짓수도 줄어야 함
				count--;
			}

			if (i < N) {
				dish = src[i];
			} else {
				dish = src[i - N];
			}
			if (select[dish] == 0) {
				count++;
			}
			select[dish]++;
			
			max = Math.max(max, count);
		}

		System.out.println(max);
	}

}
