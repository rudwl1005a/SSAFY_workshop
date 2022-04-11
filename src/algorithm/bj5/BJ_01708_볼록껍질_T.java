package algorithm.bj5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 P5 ( https://www.acmicpc.net/problem/1708 )
 */
public class BJ_01708_볼록껍질_T {

	static int N;
	static long sy, sx;
	static long[][] point;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		point = new long[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}

		// 시작점 - y가 가장 작은것, y가 같으면 x가 가장 작은 점
		sx = point[0][0];
		sy = point[0][1];
		for (int i = 1; i < N; i++) {
			if (sy > point[i][1]) {
				sx = point[i][0];
				sy = point[i][1];
			} else if (sy == point[i][1] && sx > point[i][0]) {
				sx = point[i][0];
				sy = point[i][1];
			}
		}

		// 반시계 방향으로 정렬
		Arrays.sort(point, (p1, p2) -> {
			int ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);
			if (ret > 0) {
				return -1; // 반시계 방향이면 앞으로
			} else if (ret < 0) {
				return 1; // 시계 방향이면 뒤로
			} else {
				long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
				return diff > 0 ? 1 : -1;
			}
		});

		// 선을 그어가면서 시계방향을 구성하는 것은 제외
		Stack<long[]> stack = new Stack<>();
		stack.add(new long[] { sx, sy });

		int length = point.length;
		for (int i = 1; i < length; i++) {
			long[] next = point[i];
			while (stack.size() > 1) {
				long[] first = stack.get(stack.size() - 2);
				long[] second = stack.get(stack.size() - 1);
				int ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1]);
				if (ret <= 0) {
					stack.pop();
				} else {
					break;
				}
			}
			stack.add(next);
		}

		System.out.println(stack.size());
	}

	private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long ret = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		if (ret > 0) { // 반시계 방향
			return 1;
		} else if (ret < 0) { // 시계 방향
			return -1;
		} else { // 일직선 방향
			return 0;
		}
	}

	private static long distance(long x1, long y1, long x2, long y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

}
