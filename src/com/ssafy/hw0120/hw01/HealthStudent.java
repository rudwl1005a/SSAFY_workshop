package com.ssafy.hw0120.hw01;

public class HealthStudent {
	// field
	private String name;
	private int date;
	private double weight;
	
	// 생성자
	public HealthStudent() { }

	public HealthStudent(String name, int date, double weight) {
		super();
		this.name = name;
		this.date = date;
		this.weight = weight;
	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
