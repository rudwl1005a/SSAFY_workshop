package algorithm.sw2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 모의 SW 역량테스트 ( https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH )
 */
public class SW_04012_요리사 {

	static int T, N, min;
	static int[][] ingre;
	static boolean[] select;
	static int[] c1, c2; // 각 요리사가 가지고 있는 재료

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ingre = new int[N][N];
			select = new boolean[N];
			c1 = new int[N / 2];
			c2 = new int[N / 2];
			min = Integer.MAX_VALUE;

			// 시너지는 항상 Sij + Sji가 같이 계산되기 때문에 한 쪽에다가 더해서 저장해 준다
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (i < j) {
						ingre[i][j] += Integer.parseInt(st.nextToken());
					} else {
						ingre[j][i] += Integer.parseInt(st.nextToken());
					}
				}
			}

			min = Integer.MAX_VALUE;
			divideTwo(0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

    private static void divideTwo(int cnt, int start) {
    	 
        if (cnt == N / 2) {
            int index = 0;
            for (int i = 0; i < N; i++) {
                // 선택되지 않은 것은 두번째 사람이 요리
                if (!select[i]) {
                    c2[index] = i;
                    index++;
                }
            }
             
            // 첫번째 사람 요리 시너지 계산
            int sum1 = 0;
            for (int j = 0; j < N / 2; j++) {
                for (int k = j; k < N / 2; k++) {
                    sum1 += ingre[c1[j]][c1[k]];
                }
            }
             
            // 두번째 사람 요리 시너지 계산
            int sum2 = 0;
            for (int j = 0; j < N / 2; j++) {
                for (int k = j; k < N / 2; k++) {
                    sum2 += ingre[c2[j]][c2[k]];
                }
            }
             
            min = Math.min(min, Math.abs(sum1 - sum2));
            return;
        }
 
        if (start == N) {
            return;
        }
 
        // 첫번째 사람 요리 저장
        c1[cnt] = start;
        select[start] = true;
        divideTwo(cnt + 1, start + 1);
        c1[cnt] -= start;
 
        select[start] = false;
        divideTwo(cnt, start + 1);
    }

}
