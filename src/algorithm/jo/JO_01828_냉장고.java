package algorithm.jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828 )
 */
public class JO_01828_냉장고 {
	
	static int N, count = 1;
	static Chemical[] chemical;
	static ArrayList<Chemical> answer = new ArrayList<>();
	
	static class Chemical implements Comparable<Chemical> {
		int min; // 최저 보관 온도
		int max; // 최고 보관 온도

		public Chemical(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Chemical o) {
			return this.max != o.max ? this.max - o.max : this.min - o.min;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		chemical = new Chemical[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			chemical[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(chemical);
		
		// greedy
		answer.add(chemical[0]);
		
		for (int i = 1, size = chemical.length; i < size; i++) {
			if(answer.get(answer.size() - 1).max < chemical[i].min) {
				answer.add(chemical[i]);
				count++;
			}
		}
		
		System.out.println(count);
	}

}
