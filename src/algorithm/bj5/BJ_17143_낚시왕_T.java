package algorithm.bj5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/17143 )
 */
public class BJ_17143_낚시왕_T {

	static int R, C, M, sum;
	static Shark[][] map;
	static List<Shark> list = new ArrayList<>();
	// 상 - 하 - 우 - 좌
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1]; // 0 dummy

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d - 1, z);
			list.add(shark);
			map[r][c] = shark;
		}

		// 시뮬레이션
		for (int i = 1; i <= C; i++) {
			// 상어를 잡는다
			catchShark(i);
			// 상어들이 이동
			moveShark();
			// 상어들이 정리
			killShark();
		}

		System.out.println(sum);
	}

	static void catchShark(int col) {
		for (int i = 1; i <= R; i++) {
			if (map[i][col] != null) { // 땅에서 가장 가까운 상어
				sum += map[i][col].z;
				list.remove(map[i][col]);
				break;
			}
		}
	}

	static void moveShark() {
		for (Shark shark : list) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;

			switch (d) {
			case 0: // 상,하
			case 1:
				s = s % (R * 2 - 2); // 어차피 이동하면 같은 방향과 위치가 되는 거리로 나눈 나머지를 취한다.
				for (int i = 0; i < s; i++) {
					if (r == 1) {
						d = 1; // 상 -> 하
					} else if (r == R) {
						d = 0; // 하 -> 상
					}
					r += dy[d];
				}
				shark.r = r;
				shark.d = d;
				break;
			case 2: // 좌, 우
			case 3:
				s = s % (C * 2 - 2); // 어차피 이동하면 같은 방향과 위치가 되는 거리로 나눈 나머지를 취한다.
				for (int i = 0; i < s; i++) {
					if (c == 1) {
						d = 2; // 좌 -> 우
					} else if (c == C) {
						d = 3; // 우 -> 좌
					}
					c += dx[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}

	static void killShark() {
		// 보조 수단으로 상어의 위치 중복에 대한 처리
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = null;
			}
		}

		// list 에서 중복된 상어들 중 크기가 가장 큰 것만 남긴다. remove()
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			Shark s = list.get(i);
			if (map[s.r][s.c] == null) { // 아직 이 위치에 해당하는 상어가 없다.
				map[s.r][s.c] = s;
			} else {
				if (s.z > map[s.r][s.c].z) {
					list.remove(map[s.r][s.c]);
					map[s.r][s.c] = s;
				} else {
					list.remove(s);
				}
			}
		}
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
