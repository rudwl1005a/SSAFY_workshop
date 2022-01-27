package java7.objects;

import java.util.Objects;

public class B extends A {
	int n = 10;

	@Override
	public String toString() {
		return super.toString() + " B [n=" + n + "]";
	}
	
	@Override
	public int hashCode() {
		// hashCode 오버라이딩 할 때는 hash를 사용해라
		return Objects.hash(super.str, this.n);
	}
	
	
}
