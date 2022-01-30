package io.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Test {
	
	public static void main(String[] args) {
		File file = new File("./src/io/xml/emp-list.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			// parse
			SAXParser saxParser = saxParserFactory.newSAXParser();
			EmpListSaxHandler handler = new EmpListSaxHandler();
			saxParser.parse(file, handler); // 대상xml 파일, 핸들러
			
			// list 데이터 가공
			List<EmpDto> empList = handler.getEmpList();
			for(EmpDto dto : empList) {
				System.out.println(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
