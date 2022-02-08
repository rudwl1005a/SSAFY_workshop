package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_01225_암호생성기 {
	
	static int tmp;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = "";
		while((S = br.readLine()) != null) {
			// 입력처리
			int t = Integer.parseInt(S);
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue = new LinkedList<>();
			for(int i=0; i<8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			outer:while(true) {
				for(int i=1; i<6; i++) { // 한 사이클
					tmp = queue.poll();
					if(tmp - i <= 0) { // 하나라도 0 되면 암호 완성
						queue.add(0);
						break outer;
					}
					else {
						queue.add(tmp - i);
					}
				}
			}
			
			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(" ");
			for(int i=0; i<8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			System.out.println(sb);
		}
	}

}
