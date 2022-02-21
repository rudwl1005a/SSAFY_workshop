package algorithm.sw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA D4 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD )
 */
public class SW_01238_Contact {

	static int length, start, ans, maxDepth;
	static boolean[][] contact;
	static boolean[] visit;
	static ArrayList<Node> last;

	static class Node {
		int value, depth;

		public Node(int value, int depth) {
			this.value = value;
			this.depth = depth;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			// 초기화
			ans = 0;
			contact = new boolean[101][101];
			visit = new boolean[101];
			last = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				contact[from][to] = true;
			}

			bfs(start);

			for (Node node : last) {
				ans = Math.max(ans, node.value);
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void bfs(int cur) {

		Queue<Node> q = new ArrayDeque<>();

		q.offer(new Node(cur, 0));
		last.add(new Node(cur, 0)); // 첫번째가 아무도 연락 못할 때를 위해서
		visit[cur] = true;
		maxDepth = Integer.MIN_VALUE;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 1; i <= 100; i++) {
				if (visit[i] || !contact[node.value][i]) {
					continue;
				}

				if (maxDepth < node.depth) { // 마지막 연락받은 리스트 갱신
					last.clear();
					last.add(new Node(i, node.depth + 1));
					maxDepth = node.depth;
				} else if (maxDepth == node.depth) { // 리스트에 추가
					last.add(new Node(i, node.depth + 1));
				}

				q.offer(new Node(i, node.depth + 1));
				visit[i] = true;
			}
		}

	}

}
