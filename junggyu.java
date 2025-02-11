package mini0205;

import java.util.*;

public class junggyu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		
		
		String[][] str = {{"inheritance", "delimiter", "spring", "Framework", "application", "stack", "operator", "binaryNumber", "CentralProcessingUnit", "depth"},
				{"","","","","","","","","",""}};
		String[][] str2 = {{"inheritance", "delimiter", "spring", "Framework", "application", "stack", "operator", "binaryNumber", "CentralProcessingUnit", "depth"},
				{"","","","","","","","","",""}};
		int[] score = {10,10,10,10,10,10,10,10,10,10};
		//색깔부분
		String[] lastColor = new String[]{"","","","","","","","","",""}; //정답오답별 단어별색깔 저장배열//
		String red = "\033[31m";
        String green = "\033[32m";
		
		//단어 출력
		for (int i = 0; i < 10; i++) {
			System.out.print(str[0][i] + " ");
		}
		System.out.println();

		int numCount = 0;
		int plag = 0;
		int endCount = 10;
		
		//엔터 시작부분
		System.out.println("단어 게임을 시작할려면 엔터 치세요!");
		while(true)
			if ("".equals(sc.nextLine()))
				break ;
		
		//게임시작될때 부분
		int[] checkNum = new int[10];
		while (true) {
			
			if (plag == 1) {
				lastColor = new String[]{"","","","","","","","","",""};
				//초기화
				endCount = 0;
				for (int i = 0; i < 10; i++) {
					if (score[i] != 10) {
						score[i] = 10;
						checkNum[i] = 0;
						numCount = 0;
						endCount++;
						continue ;
					}
					str[0][i] = "";
					score[i] = 10;
					checkNum[i] = 0;
					numCount = 0;
				}
				System.out.println();
				plag = 0;
				
				
			}else if (plag == 2) {
				lastColor = new String[]{"","","","","","","","","",""};
				//점수 초기화 입력값들 저장된곳 초기화 + checkNum 초기화
				for (int i = 0; i < 10; i++) {
					score[i] = 10;
					checkNum[i] = 0;
				}
				str = str2;
				endCount = 10;
				numCount = 0;
				plag  = 0;
			}
			
			//랜덤단어 출력 + 단어입력후 저장
			int num = random.nextInt(10);
			if (checkNum[num] > 0 || "".equals(str[0][num]))
				continue ;
			//입력받는 부분
			checkNum[num]++;
			System.out.println(str[0][num]);
			String inputStr = sc.nextLine();
			str[1][num] = inputStr;
			
			
			//
			
//			 for (int i = 0; i < inputWord.length(); i++) {
//	                if (i < englishWords[randomIndex].length()) {
//	                    if (inputWord.charAt(i) == englishWords[randomIndex].charAt(i)) {
//	                        lastColor[randomIndex] += green + inputWord.charAt(i); // 맞은 글자는 초록색
//	                    } else {
//	                        lastColor[randomIndex] += red + inputWord.charAt(i); // 틀린 글자는 빨간색
//	                    }
//	                } else {
//	                    lastColor[randomIndex] += red + inputWord.charAt(i); // 길이가 길면 빨간색으로 처리
//	                }
//	            }
			
			//입력받은 문자에서 틀린부분 빨간색으로
			for (int i = 0; i < inputStr.length(); i++) {
				if (i < str[0][num].length()) {
					if (inputStr.charAt(i) == str[0][num].charAt(i)) {
						lastColor[num] += green + inputStr.charAt(i); //맞는 글자는 초록색
					} else {
						lastColor[num] += red + inputStr.charAt(i);   //틀린글자는 빨간색
					}
				} else {
					lastColor[num] += red + inputStr.charAt(i);  // 길이가 길면 빨간색으로 처리
				}
			}
			
			
			//입력된값이 몇개 틀렸는지 체크 하는 부분
			int wrongNum = 0;
			
			if (str[0][num].length() >= inputStr.length()) {
				for (int i = 0; i < str[0][num].length(); i++) {
					//입력단어가 원래 단어보다 작게 입력했을때 처리
					if (inputStr.length() == i) {
						wrongNum += (str[0][num].length() - inputStr.length());
						break ;
						
					}
					if (str[0][num].charAt(i) != inputStr.charAt(i))
						wrongNum++;
				}
			}else {
				wrongNum = 123;
			}
//			System.out.println("wrongNum = " + wrongNum);
			if (wrongNum == 1) {
				score[num] = 8;
			}else if (wrongNum > 1 && wrongNum < 3) {
				score[num] = 5;
				
			}else if (wrongNum > 2) {
				score[num] = 0;
			}
			
			//종료조건
			numCount++;
//			System.out.println("numCount = " + numCount + " endCount = " + endCount);
			if (numCount == endCount) {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					System.out.println(str[0][i] + " 입력값 = " + lastColor[i] + " 점수 = " + score[i]);
					sum += score[i];
				}
				
				System.out.println("총점수는 = " + sum);
				System.out.println("틀린것을 복습하는 게임을 하시겠습니까? yes입력시 게임이 시작됩니다. 끝낼려면 아무거나입력");
				String temp = sc.nextLine();
				if (temp.equals("yes")) {
					plag = 1;
					if (sum == 100) {
						
						System.out.println("틀린것이 없네요 기존단어로 다시 게임하시겠습니까? yes 입력 ");
						temp = sc.nextLine();
						if (temp.equals("yes")) {
							plag = 2;
							continue ;
						}
					    break ;
						
					}
					continue ;
				}
				break ;
				
			}
	
		}
	
		
		
		
		
		
		
		
		
	}
	

}
