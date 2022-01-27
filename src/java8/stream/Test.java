package java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		{
			String[] strArray = {"Abc", "Bcd", "Cde", "Def", "Dfg", "Egh"};
			// strArray <= File, log, DB....
			Stream<String> stream = Arrays.stream(strArray).distinct(); // 중복 제거
			print(stream);
		}
		
		{
			Integer[] intArray = {4, 3, 5, 1, 2};
			// strArray <= File, log, DB....
			Stream<Integer> stream = Arrays.stream(intArray).sorted( (n1, n2) -> n2 - n1 ); // 정렬
			print(stream);
		}
		
		{
			Integer[] intArray = {4, 3, 5, 1, 2, 6, 7, 12, 74, 56};
			// strArray <= File, log, DB....
			Stream<Integer> stream = Arrays.stream(intArray).filter( n -> n>2 ).sorted( (n1, n2) -> n2 - n1 ); // 필터링
			print(stream);
		}
		
		{
			Integer[] intArray = {4, 3, 5, 1, 2, 6, 7, 12, 74, 56};
			// strArray <= File, log, DB....
			Stream<Integer> stream = Arrays.stream(intArray).filter( n -> n>2 ).sorted( (n1, n2) -> n2 - n1 ).limit(5); // 5개만 출력
			print(stream);
		}
	}
	
	static void print(Stream<?> stream) {
		// 그 각각에 대해서
		stream.forEach(a -> System.out.print(a + " "));
		System.out.println();
		
	}
	
}
