package com.ssafy.hw0117.hw02;

import java.io.File;
import java.util.Scanner;


public class BmiCalculator {
	  public static void main(String[] args)  throws Exception{
		  String path = BmiCalculator.class.getResource("").getPath();
		  Scanner scanner = new Scanner(new File(path + "input.txt"));
		  
		  while(scanner.hasNext()) {
			  // 파일 받아와서 배열에 저장
			  String str = scanner.next();
			  String[] strarr = str.split(",");
			  
			  // 배열 받아와서 몸무게와 키 저장, bmi 수치 저장
			  double weight = Double.parseDouble(strarr[1]);
			  double tall = Double.parseDouble(strarr[2])/100;
			  double bmi = weight/(tall*tall);
			  
			  // BMI 결과 저장
			  String result;
			  if(bmi>30)
				  result = "<고도비만>";
			  else if(bmi>25) 
				  result = "<비만>";
			  else if(bmi>23) 
				  result = "<과체중>";
			  else if(bmi>18.5) 
				  result = "<정상>";
			  else
				  result = "<저체중>";
			  
			  System.out.println("BMI 지수는 "+bmi+"로 "+ result +"입니다.");
		  }
	  }
}
