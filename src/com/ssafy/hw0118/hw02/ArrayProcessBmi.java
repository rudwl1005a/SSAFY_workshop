package com.ssafy.hw0118.hw02;

public class ArrayProcessBmi {
	public static void main(String[] args) {
		double ssafyHealth[][] = {{21, 53.2, 1.673},
									{35, 90.3, 1.781},
									{28, 70.7, 1.653},
									{25, 75.1, 1.811},
									{31, 62.0, 1.532}};
		double age = 0;
		double weight = 0;
		double tall = 0;
		System.out.println("idx\t만 나이\t몸무게(kg)\t키(m)");
		for(int i=0; i<5; i++) {
			System.out.print("학원생"+(i+1)+"\t");
			for(int j=0; j<3; j++) {
				System.out.print(ssafyHealth[i][j]+"\t");
				if(j==0) age+=ssafyHealth[i][j];
				else if(j==1) weight+=ssafyHealth[i][j];
				else tall+=ssafyHealth[i][j];
			}
			System.out.println();
		}
		System.out.printf("평균\t%.3f\t%.3f\t%.3f",(age/5),(weight/5),(tall/5));
	}
}

