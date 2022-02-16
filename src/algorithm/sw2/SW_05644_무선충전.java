package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 모의 역량 테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo )
 */
public class SW_05644_무선충전 {

	static int T, M, A, sum; // M : 총 이동시간, A : BC 개수
	static int[] p1, p2;
	static BC[] bc;
	static Map[][] map;
	static int[] dy = { 0, -1, 0, 1, 0 }; // 제자리 상 우 하 좌
	static int[] dx = { 0, 0, 1, 0, -1 };

	static class Map {
		int bcNum; // bc번호 이진법으로
		int bcCnt; // 영향주는 bc수
		int max; // 충천 최대량
		int person; // 사람 수

		public Map() {
			this.bcNum = 0;
			this.bcCnt = 0;
			this.max = 0;
			this.person = 0;
		}

		public Map(int bcNum, int bcCnt, int max, int person) {
			this.bcNum = bcNum;
			this.bcCnt = bcCnt;
			this.max = max;
			this.person = person;
		}

	}

	static class BC {
		int y, x; // 위치
		int c; // 충전 범위
		int p; // 성능

		public BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			sum = 0;
			map = new Map[10][10];

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			// 사용자 A 이동경로 저장
			p1 = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				p1[i] = Integer.parseInt(st.nextToken());
			}

			// 사용자 B 이동경로 저장
			p2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				p2[i] = Integer.parseInt(st.nextToken());
			}

			// map 정보 초기화
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = new Map();
				}
			}

			// 충전기 정보 저장
			bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bc[i] = new BC(y, x, c, p);

				// map에 충전기 정보 추가
				for (int ny = y - c; ny <= y + c; ny++) {
					for (int nx = x - c; nx <= x + c; nx++) {
						if (ny < 0 || nx < 0 || ny >= 10 || nx >= 10) // 배열 벗어나면 안됨
							continue;
						if ((Math.abs(ny - y) + Math.abs(nx - x)) > c) // 거리가 c보다 작은 경우만 해당
							continue;

						map[ny][nx].bcNum = map[ny][nx].bcNum | 1 << i;
						map[ny][nx].max = Math.max(map[ny][nx].max, p);
						map[ny][nx].bcCnt++;
					}
				}
			}

			// 시작 위치
			int p1y = 0;
			int p1x = 0;
			int p2y = 9;
			int p2x = 9;

			for (int i = 0; i <= M; i++) {
				// p1 이동
				map[p1y][p1x].person++;
				// p2 이동
				map[p2y][p2x].person++;

				if (map[p1y][p1x].bcCnt == 0 && map[p2y][p2x].bcCnt == 0) { // 둘다 충전 못하면 건너뜀
					// 이동하기전 초기화
					map[p1y][p1x].person = 0;
					map[p2y][p2x].person = 0;

					if (i != M) {
						p1y += dy[p1[i]];
						p1x += dx[p1[i]];
						p2y += dy[p2[i]];
						p2x += dx[p2[i]];
					}
					continue;
				}

				if (map[p1y][p1x].person == 2) { // 1. 같은 자리에 있을 때
					if (map[p1y][p1x].bcCnt > 1) { // 1-1. bc개수 2개 이상일 때
						int max = map[p1y][p1x].max;
						int secondMax = Integer.MIN_VALUE;
						for (int flag = 0; flag < A; flag++) { // 자리에 있는 bc찾기
							if ((map[p1y][p1x].bcNum & 1 << flag) != 0) {
								if (bc[flag].p < max) {
									secondMax = Math.max(secondMax, bc[flag].p);
								}
							}
						}
						sum += max + secondMax;
					} else if (map[p1y][p1x].bcCnt == 1) { // 1-2. bc개수 1개일 때
						sum += map[p1y][p1x].max; // 둘이서 나눠가져야 함
					}

				} else { // 2. 서로 다른 자리에 있을 때

					// p1이 영향받는 Max BC 찾기
					int p1BC = -1;
					int max = Integer.MIN_VALUE;
					for (int flag = 0; flag < A; flag++) { // 자리에 있는 bc찾기
						if ((map[p1y][p1x].bcNum & 1 << flag) != 0) {
							if (bc[flag].p > max) {
								max = bc[flag].p;
								p1BC = flag;
							}
						}
					}

					// p2가 영향받는 Max BC 찾기
					int p2BC = -2;
					max = Integer.MIN_VALUE;
					for (int flag = 0; flag < A; flag++) { // 자리에 있는 bc찾기
						if ((map[p2y][p2x].bcNum & 1 << flag) != 0) {
							if (bc[flag].p > max) {
								max = bc[flag].p;
								p2BC = flag;
							}
						}
					}

					if (p1BC == p2BC) { // 2-1. 두사람 같은 BC 영향 받고 있을 때
						int max2 = map[p1y][p1x].max;
						int secondMax = Integer.MIN_VALUE;
						// p1의 두번째 큰 bc찾기
						for (int flag = 0; flag < 8; flag++) { // 자리에 있는 bc찾기
							if ((map[p1y][p1x].bcNum & 1 << flag) != 0) {
								if (bc[flag].p < max2) {
									secondMax = Math.max(secondMax, bc[flag].p);
								}
							}
						}
						// p2의 두번째로 큰 bc찾기
						for (int flag = 0; flag < 8; flag++) { // 자리에 있는 bc찾기
							if ((map[p2y][p2x].bcNum & 1 << flag) != 0) {
								if (bc[flag].p < max2) {
									secondMax = Math.max(secondMax, bc[flag].p);
								}
							}
						}

						if (secondMax < 0) { // secondMax가 MIN_VALUE로 남아있다면 둘다 같은 BC이고 하나만 영향 받을 때 이다
							sum += max2;
						} else {
							sum += max2 + secondMax;
						}

					} else { // 2-2. 아닐 때
						sum += map[p1y][p1x].max + map[p2y][p2x].max;
					}
				}

				// 이동하기전 초기화
				map[p1y][p1x].person = 0;
				map[p2y][p2x].person = 0;

				// 다음 넘어가기
				if (i != M) { // 마지막은 진행 x
					p1y += dy[p1[i]];
					p1x += dx[p1[i]];
					p2y += dy[p2[i]];
					p2x += dx[p2[i]];
				}
			}

			System.out.println("#" + t + " " + sum);
		}
	}

}
