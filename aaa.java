package mini0205;
import java.util.*;

public class aaa {

public static void main(String[] args) {
        String[] englishWords = new String[]
                {"apple", "adventure", "brilliant", "inspire", "brave", "dream", "strength", "grate", "coffee", "computer"};

        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int[] randomArray = new int[englishWords.length]; //랜덤중복여부 판단배열
        int[] eachScores = new int[englishWords.length]; //영단어 각각의 점수저장
        String[] myAnswer = new String[englishWords.length]; //내가 입력한값을 저장배열
        String[] rankingID = new String[]{"","","","","","","","","","",""};
        int[] rankingScore = new int[11];
        int rankingIndex = 0;   //나중에 ++해줘야댐++

        int eachScore = 0; //연속 단어 보너스 판단
        String red = "\033[31m";
        String green = "\033[32m";
        String white = "\033[97m";
        String[] lastColor = new String[]{"", "", "", "", "", "", "", "", "", ""}; //정답오답별 단어별색깔 저장배열
        boolean gameOver = true;

        String[] correctAnswer =
                new String[]
                        {"apple", "adventure", "brilliant", "inspire", "brave", "dream", "strength", "grate", "coffee", "computer"}; //오답공백으로 변경할 배열

        while(gameOver) { //                       완전 시작!!!!!!!!!!!!!!!!
            System.out.println("게임시작 || 랭킹보기 || 아이디점수");
            String answer = in.nextLine();
            int totalScore = 0; //총합 점수
            int bonus = 0; //보너스

            if(answer.equals("게임시작")){
                System.out.println("아이디를 입력하세요");

            }else if(answer.equals("랭킹확인")){
                System.out.println("------------------");
                System.out.println("등수   아이디    점수");
                for(int i = 0 ; i < rankingID.length-1 ; i++) {
                    System.out.print((i+1) + "등 | "+rankingID[i] + " | ");
                    System.out.print(rankingScore[i] + " | ");
                    System.out.println();
                }
                System.out.println("------------------");
                continue;
            }

            String id = in.nextLine();

            rankingID[rankingIndex] = id;


        for(int i = 0; i < englishWords.length; i++) {
            randomArray[i] = 0;
            eachScores[i] = 0;
            myAnswer[i] = "";
            lastColor[i] = "";
        }
        for(int i = 0; i < englishWords.length; i++) {
            correctAnswer[i] = englishWords[i];
        }
        boolean gameContinue = true;               //          여기까지가 재시작 초기화단계!@!@!@!@!@!@!@!@



        System.out.println("타자게임을 시작합니다");//------------------------------------------
        int kk =0;
            int randomCnt = 0;
        while (gameContinue) {
            boolean anyWrongAnswer = false; // 오답이 있는지 확인할 변수
            lastColor = new String[]{"", "", "", "", "", "", "", "", "", ""};
            // 처음에 모든 단어를 풀도록 하되, 틀린 문제는 계속해서 반복하게 만들기


            for (int i = 0; i < englishWords.length; i++) {//----------------------------------------
                int randomIndex = rand.nextInt(englishWords.length);
                if(randomArray[randomIndex]==0){  //중복여부 판단 기능
                    randomArray[randomIndex] ++;
                    randomCnt++;
                }else{
                    i--;
                    continue;
                }

                if (!correctAnswer[i].equals("")) { // 오답이 아닌 문제는 건너뛰기
                    System.out.println("단어 : " + englishWords[randomIndex]);
                    String inputWord = in.nextLine();
                    myAnswer[randomIndex] = inputWord;
                    for(int p = 0 ; p < inputWord.length() ; p++) {
                        if(myAnswer[randomIndex].charAt(p)==' '){
                           myAnswer[randomIndex] =  myAnswer[randomIndex].replace(' ','□');
                        }
                    }
                    if(inputWord.length() < englishWords[i].length()){
                        int ccc = englishWords[i].length()-inputWord.length();
                        for(int kkk = 0 ; kkk<ccc ; kkk++){
                            myAnswer[randomIndex] += red+"□";//여기이따가 수정~!~!~!~!~!~!~!~!~!
                        }
                    }
                    int correctCnt = 0; // 정답문자 횟수

                    // 입력한 단어와 원본 단어를 비교해서 색상 처리
                    for (int j = 0; j < inputWord.length(); j++) {
                        if (j < englishWords[i].length()) {
                            if (inputWord.charAt(j) == englishWords[i].charAt(j)) {
                                lastColor[randomIndex] += green + inputWord.charAt(j); // 맞은 글자는 초록색
                                correctCnt++;
                            }else if(inputWord.charAt(j) == ' ') {
                                lastColor[randomIndex] += red + "□";
                            }
                            else {
                                lastColor[randomIndex] += red + inputWord.charAt(j); // 틀린 글자는 빨간색
                            }

                        }
                        else {
                            lastColor[randomIndex] += red + inputWord.charAt(j); // 길이가 길면 빨간색으로 처리
                        }


                    }
                    if(inputWord.length() < englishWords[i].length()) {
                        int cnt = englishWords[i].length() - inputWord.length();
                         for(int k = 0; k < cnt; k++) {
                             lastColor[randomIndex] += red+"□" ;
                         }
                    }

                    if (correctCnt != englishWords[i].length()) { // 틀린 단어들을 해당 인덱스에 저장
                        correctAnswer[i] = inputWord;
                        anyWrongAnswer = true;
                    } else {
                        correctAnswer[i] = ""; // 맞은 단어는 오답 목록에서 제거
                    }

                    // 점수 계산
                    if (englishWords[i].equals(myAnswer[randomIndex])) {
                        eachScores[i] = 10;
                        totalScore += 10;
                        eachScore++;
                        if (eachScore >= 3) {                 // 연속 3개 단어 맞추면 보너스 3점
                            bonus += 3;
                            eachScore = 0;
                        }
                    } else if (inputWord.length() - correctCnt < 2) {
                        eachScores[i] = 5;
                        totalScore += 5;
                        eachScore = 0;
                    } else if (inputWord.length() - correctCnt < 3) {
                        eachScores[i] = 3;
                        totalScore += 3;
                        eachScore = 0;
                    } else {
                        eachScores[i] = 0;
                        eachScore = 0;
                    }
                }
                // 최대 점수는 100으로
                if (totalScore > 100) {
                    totalScore = 100;
                }
            }
            rankingScore[rankingIndex] = totalScore;//랭킹점수 저장!~~!!~!~!~!~!~!~!~!~!~!~!~!~

            for (int i = 0 ; i < rankingID.length; i++) {
                if(rankingID[i].equals(id) && i!=rankingIndex) {
                    if(rankingScore[i]<rankingScore[rankingIndex]) {
                        rankingScore[i] = rankingScore[rankingIndex];
                        rankingScore[rankingIndex] = 0;
                        rankingID[rankingIndex] = "";
                        rankingIndex--;
                    }else if(rankingScore[i]>rankingScore[rankingIndex]) {
                        rankingScore[rankingIndex]=0;
                        rankingID[rankingIndex] = "";
                        rankingIndex--;
                    }
                }

            }
            for(int i = 0 ; i < rankingID.length; i++) {
                for(int j = i+1 ; j < rankingID.length-1; j++) { //내림차순 정렬
                if(rankingScore[i]<rankingScore[j]){
                    int temp = rankingScore[i];
                    rankingScore[i] = rankingScore[j];
                    rankingScore[j] = temp;

                    String str = rankingID[i];
                    rankingID[i] = rankingID[j];
                    rankingID[j] = str;
                    }
                }
            }
            // 점수와 결과를 출력
            if(kk==0) {
                System.out.println("\n=== 결과 ===");
                System.out.println("총 점수: " + totalScore);
                System.out.println("보너스 점수: " + bonus);
            }

            for (int i = 0; i < englishWords.length; i++) {
                if (eachScores[i] == 10) {
                    System.out.println(green + "정답: " + englishWords[i] + " | " + myAnswer[i]);
                } else {
                    System.out.println(red + "오답: " + englishWords[i] + " | " + myAnswer[i]);
                }
            }

            // 각 단어에 대한 색상 결과 출력
            System.out.println("\033[33m\n단어별 색상 결과:" +white);
            for (int i = 0; i < englishWords.length; i++) {
                System.out.println("단어: " + englishWords[i]+ white+ " | 결과: " + lastColor[i] + white);
            }

            // 오답이 없으면 게임 종료
            if (!anyWrongAnswer) {
                System.out.println("모든 단어를 맞췄습니다!");
                break;
            }

            // 오답 문제를 다시 풀지 묻기
            System.out.println("\n오답문제를 다시 풀어보시겠습니까? (Y / N)");
            String yesOrNo = in.nextLine();
            if (yesOrNo.equals("Y")) {
                kk = 1;
                continue;
            } else if (yesOrNo.equals("N")) {
                gameContinue = false; // 게임 종료
            }



            System.out.println("\n현재 점수와 상태:");
            for (int i = 0; i < englishWords.length; i++) {
                System.out.print("\033[36m" + "문제" + (i+1)+"번" + englishWords[i]+white);
                System.out.print(" | " );
            }
            System.out.println();
            for (int i = 0; i < englishWords.length; i++) {
                if (eachScores[i] == 10) {
                    System.out.print((i+1)+"번"+"\033[32m정답 " + myAnswer[i] + white);
                    System.out.print(" | ");
                } else {
                    System.out.print((i+1)+"번"+"\033[31m오답 " + myAnswer[i] + " | "+white);
                }
            }
            System.out.println();
            for (int i = 0; i < englishWords.length; i++) {
                System.out.print((i+1) + "번" +lastColor[i] + white+" "  );
            }
            }
            System.out.println();
            System.out.println(white + "다시 게임을 시작하시겠습니까? (yes / no)"); //다시시작
            String aaa = in.nextLine();
        if(aaa.equals("no")) {
            System.out.println("종료되었습니다.");
            gameOver = false;
        }else if(aaa.equals("yes")) {
            rankingIndex++;
            if(rankingIndex>=10){
            rankingIndex=10;
            }

        }
        }
    }
}













