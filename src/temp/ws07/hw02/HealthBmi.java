package temp.ws07.hw02;

public class HealthBmi {	
	
	public double bmiProcess(double weight, double tall) {
		return weight/(tall*tall);
	}
	
	public String fatProcess(double bmi) {
		if(bmi > 30) return "고도비만";
		else if(bmi > 25) return "비만";
		else if(bmi > 23) return "과체중";
		else if(bmi > 18.5) return "정상";
		else return "저체중";
	}

}
