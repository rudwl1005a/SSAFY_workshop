package algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// StringBuilder 안썼을때, 메모리: 122,100KB, 속도: 2980ms
// StringBuilder 썼을때, 메모리: 80,528KB, 속도: 696ms
public class BJ_02493_탑 {
	
	static int N, index;
	static boolean isPop; // push할 당시 pop을 했는지 확인
	static int[] answer;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		answer = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			isPop = false;
			if(stack.empty()) { // stack이 비었으면 처음 넣은 수
				answer[i] = 0;
				stack.push(Integer.parseInt(st.nextToken()));
				index = 1;
			} else {
				int temp = Integer.parseInt(st.nextToken());
				// stack에서 자기보다 큰 수를 찾을때까지 pop
				while(true) { // 반복해서 자기보다 작은 수 중 가장 큰 수를 찾음 -> 그 큰 수의 출력값을 찾기위함
					if(!stack.empty() && stack.peek() <= temp) { // 자기보다 작은 수는 pop, pop할 때, pop한 수의 출력값을 가져옴
						isPop = true;
						index = answer[index];
						stack.pop();
					} else break;
				}
				if(isPop) { // push할때 pop했었으면 마지막으로 pop한 값의 출력값이 자기의 출력값이 됨
					answer[i] = index;
					index++; // index 최신화 ( 최신화 하지 않으면, 두번이상 pop할 때 오류 )
							 // ex) 첫번째 pop한 answer[index]가 4이고 answer[4]=2이고, 두번째 pop할때는 index=answer[2]이고, answer[2]=0이라고 하면
							 // 	index는 0이 된다. -> 오류
							 //		하지만 index++를 해주면, 첫번째 pop할떄 answer[5]=4가 index가 되고, 두번째 pop할때 index=answer[4]=2가 되므로
							 //		의도했던 대로 저장이 가능하다. (pop하지 않고 남아있는 다음번째 수는 항상 남아있는 수가 몇번째인지 저장하고 있기 때문이다.)
				} else { // push할때 pop하지 않았으면 바로 전에 push한 값의 index가 출력값이 됨 -> pop하지 않았다면 stack의 맨 위는 직전에 push한 값
					answer[i] = i-1;
					index = i; // index 최신화
				}
				stack.push(temp);
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(answer[i]).append(" ");
//			System.out.print(answer[i] + " ");
		}
		System.out.println(sb);
		
	}
	
}

//  데이터 작을 때 version
//	static int N;
//	static int[] top, answer;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		top = new int[N];
//		answer = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			top[i] = Integer.parseInt(st.nextToken());
//		}
//		for(int i=N-1; i>0; i--) {
//			for(int j=i-1; j>=0 ; j--) {
//				if(top[i] < top[j]) {
//					answer[i] = j+1;
//					break;
//				}
//				
//			}
//		}
//		for(int i=0; i<N; i++) {
//			System.out.print(answer[i] + " ");
//		}
//	}
