package algorithm.basic;

import java.util.Arrays;

public class BASIC_Comb2 {
	
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
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1); // src증가, tgt증가 : 현재 srcIdx를 tgt가 받아들이고 다음으로 간다.
		comb(srcIdx + 1, tgtIdx); // src만 증가 : 현재 srcIdx를 tgt가 받아들이지 않는다. (난 그대로 있을거니까 너는 다음것을 줘)
	}
	
}
