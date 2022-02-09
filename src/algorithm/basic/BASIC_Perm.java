package algorithm.basic;

import java.util.Arrays;

public class BASIC_Perm {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	static boolean[] select = new boolean[src.length];
	public static void main(String[] args) {
		perm(0);
		System.out.println(COUNT);
	}
	
	static void perm(int tgtIdx) {
		// 기저조건
		if(tgtIdx == tgt.length) {
			// complete code
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		// 순열이니까 모든 src의 수를 고려한다.
		for(int i=0; i<src.length; i++) {
			if(select[i]) continue;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
	
}
