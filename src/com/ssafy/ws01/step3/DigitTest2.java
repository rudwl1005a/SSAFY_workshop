package com.ssafy.ws01.step3;

public class DigitTest2 {
	public static void main(String[] args) {
		int count=1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i<=j) System.out.printf("%3d", count++);
				else System.out.print("   ");
			}
			System.out.println();
		}
	}
}
