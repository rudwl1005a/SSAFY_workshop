package algorithm.bj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2636 )
 */
public class BJ_02636_치즈_T {

	static int H, W, hour, cheese;
	static int[][] map;
	static boolean[][] visitAir;
	static boolean[][] visitCheese;

	static Queue<Node> queueAir = new LinkedList<>();
	static Queue<Node> queueBorder = new LinkedList<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); // 세로
		W = Integer.parseInt(st.nextToken()); // 가로
		map = new int[H][W];
		visitAir = new boolean[H][W];
		visitCheese = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// bfs
		visitAir[0][0] = true;
		queueAir.offer(new Node(0, 0));
		while (true) {
			// 공기를 순회하면서 공기와 닿은 치즈를 찾아서 queueBorder에 담는다.
			bfsAir();
			// queueBorder에 더이상 없다 => break;
			if (queueBorder.isEmpty()) {
				break;
			}
			// queueBorder에서 치즈 -> 공기로 전환 queueAir에 담는다 (cheese수를 매번 새로 계산)
			bfsBorder();
			// 1회->1시간 증가
			hour++;
		}
		
		System.out.println(hour);
		System.out.println(cheese);

	}

	private static void bfsAir() {
		while (!queueAir.isEmpty()) {
			Node n = queueAir.poll();

			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || visitAir[ny][nx]) {
					continue;
				}

				// 공기
				if (map[ny][nx] == 0) {
					visitAir[ny][nx] = true;
					queueAir.offer(new Node(ny, nx));
					continue;
				}

				// 치즈
				if (map[ny][nx] == 1) {
					if (visitCheese[ny][nx]) { // 다른 공기에 의해서 치즈가 이미 발견되었다면
						continue;
					}
					visitCheese[ny][nx] = true;
					queueBorder.offer(new Node(ny, nx));
				}
			}
		}
	}

	// 경계면 치즈는 공기로 바뀐다.
	// 매번 남아있는 치즈를 새롭게 계산
	private static void bfsBorder() {
		
		cheese = 0;
		
		while(!queueBorder.isEmpty()) {
			Node n = queueBorder.poll();
			visitAir[n.y][n.x] = true;
			queueAir.offer(n);
			cheese++;
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
