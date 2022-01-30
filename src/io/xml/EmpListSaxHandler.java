package io.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmpListSaxHandler extends DefaultHandler {
	
	List<EmpDto> empList = new ArrayList<>();
	private EmpDto emp;
	private String data;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
		if(qName.equals("emp")) {
			emp = new EmpDto();
		}
		data = null;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
			case "emp" : empList.add(emp); break;
			case "empId" : emp.setEmpId(data); break;
			case "empNm" : emp.setEmpNm(data); break;
			case "salary" : emp.setSalary(Integer.parseInt(data)); break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data = new String(ch, start, length );
	}
	
	public List<EmpDto> getEmpList(){
		return empList;
	}
	
}
