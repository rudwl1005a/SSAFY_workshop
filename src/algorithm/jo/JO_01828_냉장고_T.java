package algorithm.jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828 )
 */
public class JO_01828_냉장고_T {

	static int N, count, max;
	static int[][] input; // input[i][0] : 최저(시작온도), input[i][1] : 최고(종료온도)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(input, (o1,o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		
		max = Integer.MIN_VALUE; // 현재 최고 온도
		count = 0;
		for (int i = 0; i < N; i++) {
			if(input[i][0] > max) {
				count++;
				max = input[i][1];
			}
		}
		
		System.out.println(count);
	}

}
