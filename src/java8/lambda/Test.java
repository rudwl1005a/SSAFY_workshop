package java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		list.add(new Node(6, 4));
		list.add(new Node(1, 7));
		list.add(new Node(8, 4));
		list.add(new Node(6, 0));
		list.add(new Node(9, 6));
		
//		for(Node n : list) {
//			System.out.println(n);
//		}
		
//		Collections.sort(list);
		
		// Anonymous Class
//		Collections.sort(list, new Comparator<Node>() {
//
//			@Override
//			public int compare(Node o1, Node o2) {
//				return o1.y - o2.y;
//			}
//			
//		});
		
		// lambda
		Collections.sort(list, (o1,o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);
		for(Node n : list) {
			System.out.println(n);
		}
		
		
	}
	
	static class Node {
		public int y;
		public int x;
		
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
//		public int y;
//		public int x;
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
//			if(this.y == o.y) {
//				return this.x - o.x;
//			}
//			return this.y - o.y;
//		}
//		
//	}
}
