package algorithm.bj5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/9205 )
 */
public class BJ_09205_맥주마시면서걸어가기 {

	static int T, N, hY, hX;
	static boolean canGo;
	static boolean[] visit;
	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list.clear();
			N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Node(y, x, i));
			}

			canGo = false;
			visit = new boolean[N + 2];
			bfs();

			sb.append(canGo ? "happy" : "sad").append("\n");
		}
		System.out.println(sb);
	}

	private static int dist(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(list.get(0).y, list.get(0).x, 0));
		visit[0] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.n == N + 1) {
				canGo = true;
				return;
			}
			for (int i = 0; i < N + 2; i++) {
				if (visit[i] || dist(node.y, node.x, list.get(i).y, list.get(i).x) > 1000) {
					continue;
				}
				visit[i] = true;
				q.offer(new Node(list.get(i).y, list.get(i).x, i));
			}
		}

	}

	static class Node {
		int y, x, n;

		public Node(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}
	}
}
