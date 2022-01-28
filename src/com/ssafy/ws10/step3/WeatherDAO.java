package com.ssafy.ws10.step3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherDAO {
	private static WeatherDAO weatherDAO = new WeatherDAO();
	
	private List<Weather> list = new ArrayList<>(); // Weather List
	
	// xml builder
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private Document doc;
	private Element root;
	private Weather weather;

	private WeatherDAO() {
		
	}
	public static WeatherDAO getInstance() {
		return weatherDAO;
	}
	
	public List<Weather> getWeatherList(String url) {
		try {
			connectWeather(url);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private void connectWeather(String url) throws SAXException, IOException, ParserConfigurationException {
		builder = factory.newDocumentBuilder();
		doc = builder.parse(url);
		
		// print xml
		printXml(doc);
		
		// save xml
		saveXml(doc);
		
		root = doc.getDocumentElement();
		
		// parse(root); // 밑과 같은 행동 다른 방식
		byTagName(root);
	}
	
	private void printXml(Document doc) {
		try {
			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			Writer out = new StringWriter();
			tf.transform(new DOMSource(doc), new StreamResult(out));
			System.out.println(out.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveXml(Document doc) {
		try {
			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			FileWriter out = new FileWriter("weather.xml");
			tf.transform(new DOMSource(doc), new StreamResult(out));
			System.out.println(out.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void parse(Node node) {
		NodeList nl = node.getChildNodes();
		int len = nl.getLength();
		
		//자식들만큼 돌기
		for(int i=0; i<len; i++) {
			
			Node child = nl.item(i);
			
			if(child.getNodeType()== Node.ELEMENT_NODE) {
				
				String nodeName = child.getNodeName();
				// data이름을 가진 element node이면 weather 객체 생성
				if(nodeName.equals("data")) {
					weather = new Weather();
				}
				// 재귀로 아래 자식을 찾아 들어가기
				parse(child);
				
			} else if(child.getNodeType() == Node.TEXT_NODE &&  child.getNodeValue().trim().length() != 0) {
				
				// 텍스트 노드 중에 부모 노드를 파악하여 감싸여있는 태그 파악
				if(child.getParentNode().getNodeName().equals("hour")) {
					weather.setHour(child.getNodeValue());
				} else if(child.getParentNode().getNodeName().equals("temp")) {
					weather.setTemp(child.getNodeValue());
				} else if(child.getParentNode().getNodeName().equals("wfKor")) {
					weather.setWfKor(child.getNodeValue());
				} else if(child.getParentNode().getNodeName().equals("reh")) {
					weather.setReh(child.getNodeValue());
					list.add(weather);	// 마지막 정보인 reh 받고 나면 리스트에 weather 객체를 추가.
				}
			}
		}
		
		// nl.forEach..지원  X
		// for( Node n : nl ) 지원 X
		// 아마도 xml 중요성이 하락한 이유가 아닐까..
	}
	
	public void byTagName(Element elem) {
		
		NodeList nl = elem.getElementsByTagName("data");
		
		for (int i = 0; i < nl.getLength(); i++) {
			
			Node data = nl.item(i);
			weather = new Weather();
			NodeList childs = data.getChildNodes();
			
			for(int j=0; j<childs.getLength(); j++) {
				Node child = childs.item(j);
				String nodeName = child.getNodeName();
				if(nodeName.equals("hour")) {
					String hour = child.getTextContent();
					weather.setHour(hour);
				} else if(nodeName.equals("temp")) {
					weather.setTemp(child.getTextContent());
				} else if(nodeName.equals("wfKor")) {
					weather.setWfKor(child.getTextContent());
				} else if(nodeName.equals("reh")) {
					weather.setReh(child.getTextContent());
				}
			}
			list.add(weather);
			//System.out.println(weather);
		}
	}
}
