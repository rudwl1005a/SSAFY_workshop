package com.ssafy.ws10.step3;

public class WeatherMain {
	
	public static void main(String[] args) {
		WeatherDAO weatherDao = WeatherDAO.getInstance();
		
		String url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159066000";
		java.util.List<Weather> datas = weatherDao.getWeatherList(url);
		System.out.println(datas);
	}
	
}
