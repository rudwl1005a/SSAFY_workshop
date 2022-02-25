package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/16236 )
 */
public class BJ_16236_아기상어 {

	static int N, Y, X, size = 2, eat, distance, ans; // size = 아기 상어 크기, eat = 아기 상어가 먹은 수
	static int[][] map;
	static boolean isFound;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 아기상어 초기 위치
					Y = i;
					X = j;
				}
			}
		}

		while (true) {
			isFound = false;

			bfs(Y, X);

			if (!isFound) { // 먹이 못찾았으면
				break;
			}

			// 먹이 찾았으면 거리 더해주기
			ans += distance;
			eat++;
			if (eat == size) {
				size++;
				eat = 0;
			}
		}

		System.out.println(ans);
	}

	private static void bfs(int y, int x) {
		Queue<Fish> q = new ArrayDeque<>();
		visit = new boolean[N][N];
		distance = 0;

		ArrayList<Fish> list = new ArrayList<>(); // 먹이 리스트 저장

		q.offer(new Fish(Y, X, 0));
		visit[Y][X] = true;

		while (!q.isEmpty()) {
			// 우선 확인만
			Fish f = q.peek();

			if (isFound && f.dis >= distance) { // 먹이 이미 찾았는데 더 나아가려고 하면 더 나아가지 않고 큐에 남아있는 애들 확인
				int minY = Integer.MAX_VALUE;
				while (!q.isEmpty()) {
					Fish f2 = q.poll();

					// 큐에 있는 것 중에 먹을 수 없는 것은 넘긴다
					if (map[f2.y][f2.x] == 0 || map[f2.y][f2.x] == 9 || map[f2.y][f2.x] == size) {
						continue;
					}

					if (minY == f2.y) { // 가장 위에 있는 물고기가 여러마리일 경우
						list.add(f2);
					} else if (minY > f2.y) { // 가장 위에 있는 물고기
						list.clear();
						minY = f2.y;
						list.add(f2);
					}
				}

				map[Y][X] = 0; // 원래 상어 있던 자리 0으로

				Y = minY;
				X = Integer.MAX_VALUE;
				for (Fish f3 : list) {
					X = Math.min(X, f3.x); // 가장 왼쪽에 있는 물고기 먹기
				}

				map[Y][X] = 9; // 먹이 있는 곳에 아기 상어놓기
				return;
			}

			// 먹이를 못찾았거나 찾았지만 거리가 작은경우는 진행
			Fish fish = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = fish.y + dy[d];
				int nx = fish.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > size) {
					continue;
				}

				visit[ny][nx] = true;

				if (map[ny][nx] < size && map[ny][nx] != 0) { // 빈곳이 아니고 자기 사이즈보다 작은경우 잡아먹는다
					isFound = true;
					distance = fish.dis + 1;
				}
				q.offer(new Fish(ny, nx, fish.dis + 1));

			}

		}

		// 먹이 못찾고 큐가 비었으면 먹이가 더 이상 없다는 뜻이다
		isFound = false;
	}

	static class Fish {
		int y, x, dis; // dis : 아기 상어와의 거리

		public Fish(int y, int x, int dis) {
			this.y = y;
			this.x = x;
			this.dis = dis;
		}

	}

}
