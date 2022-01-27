package io.file;

import java.io.File;

public class Test {
	public static void main(String[] args) throws Exception {
		// 폴더 생성
		String dirName = "c:" + File.separator + "SSAFY" + File.separator + "mydir";
		
		// 폴더, 파일 동시에 표현 : File
		File file1 = new File(dirName);
		
		// 동일 폴더가 있는 지 확인
		if(file1.exists()) {
			System.out.println("폴더가 존재합니다.");
		} else {
			boolean success = file1.mkdir();
			if( success ) {
				System.out.println("폴더를 생성했습니다.");
			}
		}
		
		// 파일 생성
		File file2 = new File(dirName, "char.txt");
//		file2.createNewFile();
		
		// 파일 삭제
		file2.delete();
	}
}
