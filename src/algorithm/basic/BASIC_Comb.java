package algorithm.basic;

import java.util.Arrays;

public class BASIC_Comb {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		if(tgtIdx == tgt.length) {
			// complete code
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		// 조합이므로 이전에 src에서 사용한 것은 고려하지 않는다.
		for(int i=srcIdx; i<src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx+1);
		}
	}
	
}
