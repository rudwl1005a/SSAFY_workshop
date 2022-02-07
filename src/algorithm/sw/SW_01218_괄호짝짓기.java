package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_01218_괄호짝짓기 {

	static int N;
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			input = br.readLine().toCharArray();
			for(int i=0; i<N; i++) {
				if(!stack.empty()) {
					if(input[i] == ')' && stack.peek() == '(') stack.pop();
					else if(input[i] == ']' && stack.peek() == '[') stack.pop();
					else if(input[i] == '}' && stack.peek() == '{') stack.pop();
					else if(input[i] == '>' && stack.peek() == '<') stack.pop();
					else stack.push(input[i]);
				} else {
					stack.push(input[i]);
				}
			}
			
			if(stack.empty()) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
			
		}
		
	}

}
