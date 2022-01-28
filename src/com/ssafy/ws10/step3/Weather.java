package com.ssafy.ws10.step3;

public class Weather {
	private String hour;
	private String temp;
	private String wfKor;
	private String reh;
	
	public Weather() {}
	public Weather(String hour, String temp, String wfKor, String reh) {
		super();
		this.hour = hour;
		this.temp = temp;
		this.wfKor = wfKor;
		this.reh = reh;
	}
	
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getWfKor() {
		return wfKor;
	}
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	public String getReh() {
		return reh;
	}
	public void setReh(String reh) {
		this.reh = reh;
	}
	
	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfKor=" + wfKor + ", reh=" + reh + "]";
	}
	
	
	
}
