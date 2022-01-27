package com.ssafy.ws01.step3;

public class DigitTest1 {
	public static void main(String[] args) {
		int count=1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				// 공백 출력 + 숫자 출력
				if(i>j) System.out.printf("%3s", " ");
				else System.out.printf("%3d", count++);
			}
			System.out.println();
		}
	}
}
