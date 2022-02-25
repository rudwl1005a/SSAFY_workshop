package algorithm.bj3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/15686 )
 */
public class BJ_15686_치킨배달_T3 {
	// NP를 이용한 조합

	static int N, M, min;
	static List<int[]> house, src;
	static int[] index; // index는 src의 size만큼

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		house = new ArrayList<int[]>(); // 집들
		src = new ArrayList<int[]>(); // 치킨집 전체

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 치킨집 최대 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) { // 집일 경우
					house.add(new int[] { i, j });
				} else if (a == 2) { // 치킨집일 경우
					src.add(new int[] { i, j });
				}
			}
		}

		min = Integer.MAX_VALUE;

		// NP
		index = new int[src.size()];
		for (int i = 0; i < M; i++) { // 뒤쪽부터 M개만큼 1 채워줌 <- 가장 작은 수 표현
			index[src.size() - i - 1] = 1;
		}

		// while version
		while (true) {
			// complete code
			int sum = 0; // 치킨 거리의 총 합
			for (int i = 0; i < house.size(); i++) { // 각각의 집에 대해서 최소값
				int dist = Integer.MAX_VALUE;
				for (int j = 0; j < index.length; j++) {
					if (index[j] == 1) {
						// i 집 - 치킨집 거리
						dist = Math.min(dist, Math.abs(house.get(i)[0] - src.get(j)[0]) + Math.abs(house.get(i)[1] - src.get(j)[1]));
					}
				}
				sum += dist;
			}

			// sum : 현재 조합에서 치킨 거리의 합
			min = Math.min(min, sum);

			if (!np()) {
				break;
			}
		}

		// do while version
//		do {
//			// complete code
//			int sum = 0; // 치킨 거리의 총 합
//			for (int i = 0; i < house.size(); i++) { // 각각의 집에 대해서 최소값
//				int dist = Integer.MAX_VALUE;
//				for (int j = 0; j < index.length; j++) {
//					if (index[j] == 1) {
//						// i 집 - 치킨집 거리
//						dist = Math.min(dist, Math.abs(house.get(i)[0] - src.get(j)[0]) + Math.abs(house.get(i)[1] - src.get(j)[1]));
//					}
//				}
//				sum += dist;
//			}
//
//			// sum : 현재 조합에서 치킨 거리의 합
//			min = Math.min(min, sum);
//		} while (np());
//
//		System.out.println(min);
	}

	private static boolean np() {
		int[] src = index;

		int i = src.length - 1;
		while (i > 0 && src[i - 1] >= src[i]) {
			--i;
		}

		if (i == 0) { // 가장 큰 수 확인 -> 더 이상 조합 없음
			return false;
		}

		int j = src.length - 1;
		while (src[i - 1] >= src[j]) {
			--j;
		}
		swap(src, i - 1, j);

		int k = src.length - 1;
		while (i < k) {
			swap(src, i++, k--);
		}

		return true;
	}

	private static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
