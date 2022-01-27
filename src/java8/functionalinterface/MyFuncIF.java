package java8.functionalinterface;

@FunctionalInterface
public interface MyFuncIF {
	// 인터페이스에 abstract method가 1개가 있으면 fuctional interface라고 한다 -> 특정 기능 하나만을 위해 존재
	int proc1(int n1, int n2);
//	int proc3(int n1, int n3); // functional interface가 아니면 lambda식 사용 못함
	
	// proc2는 추상메서드가 아니기 때문에 오류 안남
	default int proc2(int n1, int n2) {
		return n1 - n2;
	}
}
