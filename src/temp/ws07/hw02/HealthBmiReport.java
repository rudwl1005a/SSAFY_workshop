package temp.ws07.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HealthBmiReport {
	public static void main(String[] args) throws FileNotFoundException {
		String path = HealthBmiReport.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
		Scanner scan = new Scanner(new File(path + "input.txt")); // path 폴더 내의 test.txt 를 가리킨다.

		int index = 0;
		String[][] report = new String[6][4];
		while(scan.hasNext()) {
			 // 파일 받아와서 배열에 저장
			  String str = scan.next();
			  String[] strarr = str.split(",");
			  report[index++] = strarr;
		}
		
		// 정보 출력
		System.out.println("이름\t측정일\t몸무게\t키");
		for(int i=0; i<6; i++) {
			System.out.println(report[i][0] + "\t" + report[i][1] + "\t" + report[i][2] + "\t" + report[i][3]);
		}
		
		// 입력한 학원생 정보
		Scanner input = new Scanner(System.in);
		System.out.println("학원생 이름을 입력하세요. >>");
		String inputName = input.next();
		
		double weightSum = 0; double tallSum = 0; double count = 0;
		for(int i=0; i<6; i++) {
			if(report[i][0].equals(inputName)) {
				weightSum = weightSum + Double.parseDouble(report[i][2]);
				tallSum = tallSum + Double.parseDouble(report[i][3]);
				count++;
			}
		}
		SystemPrint sp = new SystemPrint();
		sp.print(weightSum/count, tallSum/count);
		
	}
}
