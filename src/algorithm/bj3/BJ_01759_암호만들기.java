package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1759 )
 */
public class BJ_01759_암호만들기 {

	static int L, C, voCnt, coCnt;
	static char[] input, pwd;
	static boolean[] vowel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 암호 문자열 길이
		C = Integer.parseInt(st.nextToken()); // 추측할 문자열
		input = new char[C];
		pwd = new char[L];
		vowel = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(input);
		
		for (int i = 0; i < C; i++) {
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
				vowel[i] = true;
			}
		}
		
		comb(0, 0);
		
		System.out.println(sb);
		
	}

	private static void comb(int srcIdx, int tgtIdx) {
		
		if(tgtIdx == L) {
			if(voCnt < 1 || coCnt < 2) {
				return;
			}
			String s = String.valueOf(pwd);
			sb.append(s).append("\n");
			return;
		}
		if(srcIdx == C) {
			return;
		}
		
		pwd[tgtIdx] = input[srcIdx];
		
		if(vowel[srcIdx]) voCnt++;
		else coCnt++;
		comb(srcIdx + 1, tgtIdx + 1);
		
		if(vowel[srcIdx]) voCnt--;
		else coCnt--;
		comb(srcIdx + 1, tgtIdx);
	}

}
