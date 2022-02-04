package algorithm.basic;

public class BASIC_RecursiveCall {

	public static void main(String[] args) throws Exception {
		m5(0);
	}

	static int m1_cnt = 0;
	static void m1() {
		int i = 0;
		System.out.println("m1()" + i++ + " m1_cnt: " + m1_cnt++);
		m1();
	}
	
	static int m2_cnt = 5;
	static void m2() {
		System.out.println("1 m2_cnt = " + m2_cnt);
		// 조건이 맞으면 m2() 호출
		if( m2_cnt > 0 ) {
			m2_cnt--;
			m2();
		}
		System.out.println("2 m2_cnt = " + m2_cnt);
	}
	
	static int m2_correct_cnt = 5;
	static void m2_correct() {
		System.out.println("1 m2_correct_cnt = " + m2_correct_cnt);
		// 조건이 맞으면
		if( m2_correct_cnt == 0 ) {
			return;
		}
		
		m2_correct_cnt--;
		m2_correct();
		
		System.out.println("2 m2_correct_cnt = " + m2_correct_cnt);
	}
	
	static int m2_correct_cnt_2 = 5;
	static void m2_correct_2() {
		// 조건이 맞으면
		if( m2_correct_cnt_2 == 0 ) {
			return;
		}
		
		System.out.println("1 m2_correct_cnt_2 = " + m2_correct_cnt_2);
		
		m2_correct_cnt_2--;
		m2_correct_2();
		m2_correct_cnt_2++;
		
		System.out.println("2 m2_correct_cnt_2 = " + m2_correct_cnt_2);
	}
	
	static void m3(int m3_cnt) {
		// 조건이 맞으면
		if( m3_cnt == 0 ) {
			return;
		}
		
		System.out.println("1 m3_cnt = " + m3_cnt);
		
//		m3_cnt--;
//		m3(m3_cnt);
//		m3_cnt++;
		
		m3(m3_cnt - 1);
		
		System.out.println("2 m3_cnt = " + m3_cnt);
	}
	
	static int[] m4_intArr = {10, 20, 30, 40, 50};
	static void m4(int m4_cnt) {
		// 조건이 맞으면
		if( m4_cnt < 0 ) {
			return;
		}
		
		System.out.println("1 m4_cnt = " + m4_intArr[m4_cnt]);
		
//		m4_cnt--;
//		m4(m4_cnt);
//		m4_cnt++;
		
		m4(m4_cnt - 1);
		
		System.out.println("2 m4_cnt = " + m4_intArr[m4_cnt]);
	}
	
	// 짝수들만의 합을 구하라
	static int[] m5_intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static int m5_even_count = 0;
	static int m5_even_sum = 0;
	
	static void m5(int m5_cnt) {
		// 조건이 맞으면
		if( m5_cnt == m5_intArr.length ) {
			// complete code
			System.out.println(m5_even_count);
			System.out.println(m5_even_sum);
			return;
		}
		
		if( m5_intArr[m5_cnt] % 2 == 0 ) {
			m5_even_count++;
			m5_even_sum += m5_intArr[m5_cnt];
		}
		
		m5(m5_cnt + 1);
		
	}
}
