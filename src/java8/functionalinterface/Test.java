package java8.functionalinterface;

public class Test {
	public static void main(String[] args) {
//		MyFuncIF aaa = new MyFuncIFImpl();
//		System.out.println(aaa.proc1(3, 5));
		
		UseMyFuncIF func = new UseMyFuncIF();
		
//		MyFuncIFImpl impl = new MyFuncIFImpl();
//		func.m1(10, 20, impl);
		
		func.m1(10, 20, new MyFuncIFImpl());
		
		// Anonymous Class 객체 (lambda 이전)
		func.m1(10, 20, new MyFuncIF() {

			@Override
			public int proc1(int n1, int n2) {
				return n1 + n2;
			}
			
		});
		
		func.m1(10, 20, new MyFuncIF() {
			
			@Override
			public int proc1(int n1, int n2) {
				return n1 - n2;
			}
			
		});
		
		// lambda
		func.m1(10, 20, (n1,n2) -> n1*n2);
		
	}
}
