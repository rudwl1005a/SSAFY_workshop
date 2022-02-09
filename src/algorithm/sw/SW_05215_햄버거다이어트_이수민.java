package algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_05215_햄버거다이어트_이수민 {
   static int T,N,L,ans;
   static int [] score;
   static int [] cal;

   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int T = Integer.parseInt(br.readLine());
      for (int t = 1; t <= T; t++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         //2번째 줄
         N = Integer.parseInt(st.nextToken()); //재료개수
         L = Integer.parseInt(st.nextToken());//제한칼로리
         score = new int[N];
         cal = new int[N];
         
         //재료정보 받아오기
         for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            cal[i] = Integer.parseInt(st.nextToken());
               
         }
         ans = 0;
         comb(0,0,0);// 빈리스트로 시작해야하는 이유 : 안뽑히는 경우가 있어서임
         System.out.println("#"+t+" "+ans);
   
      }

   }
   
   static void comb(int idx, int sumScore, int sumCal) { //idx는 현재 인덱스에있는 재료를 뽑을지말지
      if(sumCal>L)
         return ;
      if(idx == N) {
         ans = Math.max(ans,sumScore );
         return;
      }
      comb(idx+1,sumScore+score[idx],sumCal+cal[idx]); //뽑고감
      comb(idx+1,sumScore,sumCal); // 안뽑고감

   }

}