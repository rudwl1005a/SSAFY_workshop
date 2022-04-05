package algorithm.jo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://jungol.co.kr/bbs/board.php?bo_table=pbank&code=2577&sca=99 )
 */
public class JO_02577_회전초밥 {

	static int N, d, k, c, cnt, max;
	static int[] sushi;
	static int[] pick;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		sushi = new int[N + k];
		pick = new int[d + 1];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k; i++) { // 회전 초밥이므로 맨 뒤와 맨 앞의 조합도 생각해 봐야 함
			sushi[i] = sushi[i - N];
		}

		// 1 ~ k까지 우선 계산
		for (int i = 0; i < k; i++) {
			if (pick[sushi[i]] == 0) { // 이미 있는 것이 아니라면
				cnt++;
			}
			pick[sushi[i]]++; // 초밥 종류 따져서 증가
		}

		// 쿠폰 계산
		max = pick[c] == 0 ? cnt + 1 : cnt;

		int start = 0;
		int end = k - 1;
		while (end < N + k - 1) {
			pick[sushi[start]]--; // 맨 앞에 먹은것 - 1
			if (pick[sushi[start]] == 0) {
				cnt--;
			}
			start++;

			end++;
			if (pick[sushi[end]] == 0) {
				cnt++;
			}
			pick[sushi[end]]++;

			max = Math.max(max, pick[c] == 0 ? cnt + 1 : cnt);
		}

		System.out.println(max);
	}

}
