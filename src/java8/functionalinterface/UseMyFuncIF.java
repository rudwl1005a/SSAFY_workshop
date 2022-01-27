package java8.functionalinterface;

public class UseMyFuncIF {
	public void m1(int n1, int n2, MyFuncIF impl) {
		int result = impl.proc1(n1, n2);
		System.out.println(result);
	}
	
}
