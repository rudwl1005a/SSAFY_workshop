package basic;

public class PassByValueTest {
	public static void main(String[] args) {
		int i= 10;
		setVal(i);
		System.out.println(i); // 10
		
		Pass p = new Pass();
		setVal(p);
		System.out.println(p.val);
	}
	
	static void setVal(int x) {
		x=5;
	}
	
	static void setVal(Pass p) {
		p.val = 5;
	}
	
	static class Pass{
		public int val = 10;
	}
}
