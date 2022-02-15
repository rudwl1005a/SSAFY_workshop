package algorithm.basic;

// 피보나치
// 1, 1, 2, 3, 5, 8, 13, 21 ...
public class BASIC_DP_Fibonacci {
	
	public static void main(String[] args) throws Exception {
//		long result = fibo_rc(10);  // 40이 넘어가면 출력x -> 오래걸려서
		long result = fibo_dp(50);
		
		System.out.println(result);
	}

	// 시간 엄청 많이 걸림 ( 중복 호출되는 것이 많기 때문에 )
	private static long fibo_rc(int n) {
	
		// 기저조건
		if(n <= 1) return n;  
		
		return fibo_rc(n-1) + fibo_rc(n-2);
	}
	
	static long fibo_dp(int n) {
		// memorization
		long[] memoi = new long[n+1];
		
		// initialization
		memoi[1] = 1;
		memoi[2] = 1;
		for (int i = 3; i <= n; i++) {
			memoi[i] = memoi[i-1] + memoi[i-2];
		}
		
		return memoi[n];
	}

}
