package temp.ws07.hw02;

public class SystemPrint extends PrintProcess {
	
	@Override
	public void print(double weightAve, double tallAve) {
		System.out.print("평균 몸무게 : ");
		System.out.printf("%.3fkg, ", weightAve);
		System.out.print("평균 키 : ");
		System.out.printf("%.3fcm\n", tallAve);
	}
	
}
