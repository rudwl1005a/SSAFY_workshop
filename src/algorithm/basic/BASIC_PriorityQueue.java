package algorithm.basic;

import java.util.PriorityQueue;

public class BASIC_PriorityQueue {
	
	public static void main(String[] args) {
//		{
//			PriorityQueue<Integer> pqInt = new PriorityQueue<>();
//			pqInt.add(15);
//			pqInt.add(9);
//			pqInt.add(6);
//			pqInt.add(12);
//			pqInt.add(3);
//			
//			while(!pqInt.isEmpty()) {
//				System.out.println(pqInt.poll()); // 정렬되어 저장된다.
//			}
//			
////			for(int n : pqInt) {
////				System.out.println(n); // 이상하게 정렬됨 -> 사용하면 안된다.
////			}
//		}
		
//		{
//			// 생성자 부분에 람다식을 이용해서 정렬 기준을 변경할 수 있다.
//			PriorityQueue<Integer> pqInt = new PriorityQueue<>((i1, i2) -> i2 - i1);
//			pqInt.add(15);
//			pqInt.add(9);
//			pqInt.add(6);
//			pqInt.add(12);
//			pqInt.add(3);
//			
//			while(!pqInt.isEmpty()) {
//				System.out.println(pqInt.poll()); // 정렬되어 저장된다.
//			}
//		}
		
		{
			PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.y == n2.y ? n1.x - n2.x : n1.y - n2.y);
			pq.add(new Node(3,7));
			pq.add(new Node(1,5));
			pq.add(new Node(2,8));
			pq.add(new Node(1,3));
			pq.add(new Node(4,9));
			
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
		}
	}
	
	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
		
	}
	
//	static class Node implements Comparable<Node> {
//		int y, x;
//		
//		public Node(int y, int x) {
//			this.y = y;
//			this.x = x;
//		}
//		
//		@Override
//		public String toString() {
//			return "Node [y=" + y + ", x=" + x + "]";
//		}
//		
//		@Override
//		public int compareTo(Node o) {
//			return this.x - o.x;
//		}
//		
//	}
	
}
