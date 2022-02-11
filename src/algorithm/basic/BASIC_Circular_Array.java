package algorithm.basic;

public class BASIC_Circular_Array {
	
	public static void main(String[] args) {
		char[] input = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int n = input.length;
		{
			for (int i = 0; i < n*2; i++) {
				System.out.println(input[i%n]);
			}
		}
		{
			int count = 0; // 실행 횟수
			int i = 0; // index
			
			while(true) {
				if(count == 20) break;
				System.out.print(input[i%n] + " ");
				count++;
				i++;
			}
		}
	}
}
