package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기중 하나를 고르세요.\n"
				+ "1. 5판 3선승\n"
				+ "2. 3판 2선승\n"
				+ "3. 1판 1선승");
		Scanner scanner = new Scanner(System.in);
		
		// 변수 선언
		System.out.print("번호를 입력하세요: ");
		int menu = scanner.nextInt();
		int comWin = 0;
		int userWin = 0;
		int gameAll = 0; // 게임 총 수
		int gameCount = 0; // 현재 게임
		int gameWin = 0; // 게임 선승
		
		// 가위:1, 바위:2, 보:3
		int comNo = 0;
		int userNo = 0;
		
		// 가위바위보 세팅
		if(menu == 1) {
			gameAll = 5; gameWin = 3;
		}
		else if(menu == 2) {
			gameAll = 3; gameWin = 2;
		}
		else {
			gameAll = 1; gameWin = 1;
		}
		
		// 가위바위보 게임
		for(int i=0; i < gameAll; i++) {
			comNo = (int)(Math.random()*3) + 1;
			System.out.print("가위바위보중 하나 입력: ");
			String s = scanner.next();
			
			if(s.equals("가위")) userNo = 1;
			else if(s.equals("바위")) userNo = 2;
			else if(s.equals("보")) userNo = 3;
			
			if(comNo == 1) {
				if(userNo == 1) {
					System.out.println("비겼습니다!");
				}
				else if(userNo == 2) {
					System.out.println("이겼습니다!");
					userWin++;
				}
				else if(userNo == 3) {
					System.out.println("졌습니다!");
					comWin++;
				}
			}
			else if(comNo == 2) {
				if(userNo == 1) {
					System.out.println("졌습니다!");
					comWin++;
				}
				else if(userNo == 2) {
					System.out.println("비겼습니다!");
				}
				else if(userNo == 3) {
					System.out.println("이겼습니다!");
					userWin++;
				}
			}
			else if(comNo == 3) {
				if(userNo == 1) {
					System.out.println("이겼습니다!");
					userWin++;
				}
				else if(userNo == 2) {
					System.out.println("졌습니다!");
					comWin++;

				}
				else if(userNo == 3) {
					System.out.println("비겼습니다!");
				}
			}
			gameCount++;
			
			// 게임 결과
			if(comWin == gameWin) {
				System.out.println("###컴퓨터 승!");
				break;
			}
			else if(userWin == gameWin) {
				System.out.println("###유저 승!");
				break;
			}
			else if(gameCount == gameAll) {
				if(userWin > comWin) System.out.println("###유저 승!");
				else if(userWin < comWin) System.out.println("###컴퓨터 승!");
				else System.out.println("###비겼습니다!");
			}
		}
		
		scanner.close();
	}
}
