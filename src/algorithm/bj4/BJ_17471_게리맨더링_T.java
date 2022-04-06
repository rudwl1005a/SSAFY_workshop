package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17471 )
 */
public class BJ_17471_게리맨더링_T {

	static int N, min;
	static int[][] matrix;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N + 1][N + 1]; // 2차원의 index(0)은 인구수 저장
		select = new boolean[N + 1];
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // i구역의 인접한 다른 구역의 수
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		subset(1); // 1번부터

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void check() {
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		// A : select[i] == true
		for (int i = 1; i <= N; i++) { // A그룹에 해당하는 1개를 선택 후 큐에 넣는다
			if (select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		if (queue.size() == 0) { // 적어도 한개의 구역을 포함해야 하는데 그렇지 않은 경우
			return;
		}
		while (!queue.isEmpty()) { // 게리맨더링의 가장 까다롭지만 중요한 부분
			int v = queue.poll();
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && select[adj]) { // select[adj] - A그룹인지 따진다
					visit[adj] = true;
					queue.offer(adj);
				}
			}
		}

		// B : select[i] == false
		for (int i = 1; i <= N; i++) { // B그룹에 해당하는 1개를 선택 후 큐에 넣는다
			if (!select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && !select[adj]) { // select[adj] - B그룹인지 따진다
					visit[adj] = true;
					queue.offer(adj);
				}
			}
		}

		// 위 작업은 visit[]을 완성해 가는 작업
		boolean visitAll = true;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) { // 연결되지 않은 구역이 남아있다
				visitAll = false;
				break;
			}
		}

		// A, B 각각 따졌을때 모두 연결되어 있다면 visitAll = true
		if (visitAll) { // 두 그룹 모두 연결되어 있다.
			int sumA = 0;
			int sumB = 0;
			for (int i = 1; i <= N; i++) {
				if (select[i]) {
					sumA += matrix[i][0];
				} else {
					sumB += matrix[i][0];
				}
			}
			min = Math.min(min, Math.abs(sumA - sumB));
		}
	}

	private static void subset(int srcIdx) {

		if (srcIdx == N + 1) {
			// complete code
			check();
			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

}
