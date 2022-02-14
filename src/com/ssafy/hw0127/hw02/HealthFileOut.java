package com.ssafy.hw0127.hw02;

import java.io.FileReader;

public class HealthFileOut {
	public static void main(String[] args) {
		String path = HealthFileOut.class.getResource("").getPath();
		String filePath = path + "fileout_hw02.txt";
		
		try(FileReader reader = new FileReader(filePath);) {
			int i;
			while((i = reader.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
