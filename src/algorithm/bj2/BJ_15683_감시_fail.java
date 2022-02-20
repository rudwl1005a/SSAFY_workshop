package algorithm.bj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/15683 )
 */
public class BJ_15683_감시_fail {
	// 안맞는 코드
	
	static int N, M, min;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dx = { 0, 1, 0, -1 };
	static ArrayList<Cctv> cctv = new ArrayList<>();
	static Cctv[] tgt;
	static boolean[] visit;

	static class Cctv {
		int y, x, num; // 좌표, cctv번호

		public Cctv(int y, int x, int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) { // cctv라면 정보 저장
					cctv.add(new Cctv(i, j, map[i][j]));
				}
			}
		}

		visit = new boolean[cctv.size()];
		tgt = new Cctv[cctv.size()];
		min = Integer.MAX_VALUE;
		perm(0);

		System.out.println(min);

	}

	private static void perm(int cnt) {

		if (cnt == cctv.size()) {
			int ans = 0;

			// 새로운 맵에서 테스트
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}

			// 순서대로 맵에 그려보기
			for (int i = 0; i < cctv.size(); i++) {
				makeMax(tgt[i].y, tgt[i].x, tgt[i].num, temp);
			}

			// 사각지대(0) 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0) {
						ans++;
					}
				}
			}

			min = Math.min(min, ans);

			return;
		}

		// 순서 결정하기(순열)
		for (int i = 0; i < cctv.size(); i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;

			tgt[cnt] = cctv.get(i);
			// 다음 수 뽑으러 가기
			perm(cnt + 1);

			visit[i] = false;
		}

	}

	private static void makeMax(int y, int x, int num, int[][] temp) {

		int maxDirec = 0;
		int max = Integer.MIN_VALUE;
		int count = 0;

		if (num == 1) { // d 0,1,2,3
			for (int d = 0; d < 4; d++) {

				count = count(y, x, d, 0, temp);

				if (max < count) {
					maxDirec = d;
					max = count;
				}
			}

			// 제일 많이 변할 수 있는 방향으로 # -> 7로 대신해서 저장
			save(y, x, maxDirec, temp);

		} else if (num == 2) { // d 02, 13
			for (int d = 0; d < 2; d++) {

				// 상, 우 부분 계산
				count = count(y, x, d, 0, temp);

				// 하, 좌 부분 계산
				count = count(y, x, d + 2, count, temp);

				if (max < count) {
					maxDirec = d;
					max = count;
				}
			}

			// 상, 우 부분 저장
			save(y, x, maxDirec, temp);

			// 하, 좌 부분 저장
			save(y, x, maxDirec + 2, temp);

		} else if (num == 3) { // d 01, 12, 23, 30
			for (int d = 0; d < 4; d++) {
				count = count(y, x, d, 0, temp);
				count = count(y, x, (d + 1) % 4, count, temp);

				if (max < count) {
					maxDirec = d;
					max = count;
				}
			}

			save(y, x, maxDirec, temp);
			save(y, x, (maxDirec + 1) % 4, temp);

		} else if (num == 4) { // d 012, 123, 230, 301
			for (int d = 0; d < 4; d++) {
				count = count(y, x, d, 0, temp);
				count = count(y, x, (d + 1) % 4, count, temp);
				count = count(y, x, (d + 2) % 4, count, temp);

				if (max < count) {
					maxDirec = d;
					max = count;
				}
			}

			save(y, x, maxDirec, temp);
			save(y, x, (maxDirec + 1) % 4, temp);
			save(y, x, (maxDirec + 2) % 4, temp);

		} else if (num == 5) { // 5: 0123
			save(y, x, 0, temp);
			save(y, x, 1, temp);
			save(y, x, 2, temp);
			save(y, x, 3, temp);
		}

	}

	private static void save(int y, int x, int d, int[][] temp) {
		int ny = y + dy[d];
		int nx = x + dx[d];

		while (true) {
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
				break;
			}
			if (temp[ny][nx] == 6) {
				break;
			}

			if (temp[ny][nx] == 0) {
				temp[ny][nx] = 7;
			}

			ny += dy[d];
			nx += dx[d];
		}
	}

	private static int count(int y, int x, int d, int count, int[][] temp) {
		int ny = y + dy[d];
		int nx = x + dx[d];

		while (true) {
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
				break;
			}
			if (temp[ny][nx] == 6) {
				break;
			}

			if (temp[ny][nx] == 0) {
				count++;
			}

			ny += dy[d];
			nx += dx[d];
		}

		return count;
	}

}
