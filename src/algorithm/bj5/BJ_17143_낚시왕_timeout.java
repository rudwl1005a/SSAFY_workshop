package algorithm.bj5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/17143 )
 */
public class BJ_17143_낚시왕_timeout {
	// 시간초과

	static int R, C, M, fisher, ans;
	static int[][] map; // 상어의 크기만 저장
	static ArrayList<Shark> list = new ArrayList<>();
	static ArrayList<Shark> copyList = new ArrayList<>();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 우 좌
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // row
		C = Integer.parseInt(st.nextToken()); // column
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		map = new int[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 행
			int c = Integer.parseInt(st.nextToken()); // 열
			int s = Integer.parseInt(st.nextToken()); // 속도
			int d = Integer.parseInt(st.nextToken()) - 1; // 방향(상 하 우 좌)
			int z = Integer.parseInt(st.nextToken()); // 크기

			if (d <= 1) {
				s %= (R - 1) * 2;
			} else {
				s %= (C - 1) * 2;
			}

			map[r][c] = z;
			list.add(new Shark(r, c, s, d, z));
		}

		// 시뮬레이션
		while (fisher < C) {
			// 1. 낚시왕 이동
			fisher++;

			// 2. 상어 낚시
			for (int i = 1; i < R + 1; i++) {
				if (map[i][fisher] > 0) {
					ans += map[i][fisher];
					for (int j = 0; j < list.size(); j++) { // 상어 삭제
						if (list.get(j).r == i && list.get(j).c == fisher) {
							list.get(j).z = 0;
						}
					}
					break; // 맨 위 상어만 낚시
				}
			}

			// 3. 상어 이동
			move();
		}

		System.out.println(ans);

	}

	private static void move() { // 상어 이동
		// 상어들을 다 꺼내서 움직여본다.
		copyList.clear();
		for (Shark shark : list) {
			if (shark.z == 0) {
				continue;
			}
			int s = shark.s;
			int ny = shark.r;
			int nx = shark.c;

			while (s > 0) {
				ny += dy[shark.d];
				nx += dx[shark.d];

				if (ny <= 0 || nx <= 0 || ny > R || nx > C) { // 벽에 부딛혔으면
					// 0<->1, 2<->3
					if (shark.d == 0) {
						shark.d = 1;
					} else if (shark.d == 1) {
						shark.d = 0;
					} else if (shark.d == 2) {
						shark.d = 3;
					} else if (shark.d == 3) {
						shark.d = 2;
					}

					ny += dy[shark.d] * 2; // 반대편으로 두칸
					nx += dx[shark.d] * 2;
				}

				s--;
			}

			copyList.add(new Shark(ny, nx, shark.s, shark.d, shark.z));
		}

		// 같은 위치에 상어가 있다면 큰것만 남기고 list에서 삭제
		for (int i = copyList.size() - 1; i >= 0; i--) {
			if (copyList.get(i).z == 0) { // 삭제한 것 건너뜀
				continue;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (copyList.get(j).z == 0) { // 삭제한 것 건너뜀
					continue;
				}
				if (copyList.get(i).r == copyList.get(j).r && copyList.get(i).c == copyList.get(j).c) { // 위치 같다면
					if (copyList.get(i).z < copyList.get(j).z) {
						copyList.get(i).z = copyList.get(j).z;
						copyList.get(i).s = copyList.get(j).s;
						copyList.get(i).d = copyList.get(j).d;
					}
					copyList.get(j).z = 0;
				}
			}
		}

		// 낚시터에 상어 크기 저장
		list.clear();
		map = new int[R + 1][C + 1];
		for (Shark shark : copyList) {
			if (shark.z == 0) { // 삭제한 것 건너 뜀
				continue;
			}
			map[shark.r][shark.c] = shark.z;
			list.add(shark);
		}
	}

	static class Shark {
		int r, c, s, d, z; // s : 속력, d : 방향, z : 크기

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
