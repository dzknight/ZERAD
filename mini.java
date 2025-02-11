package mini0205;

import java.util.*;

public class mini {	
	public static final String black    = "\033[30m" ;
	public static final String red      = "\033[31m" ;
	public static final String bold      = "\033[3m" ;
	public static final String green    = "\033[32m" ;
	public static final String yellow   = "\033[33m" ;
	public static final String blue     = "\033[34m" ;
	public static final String purple   = "\033[35m" ;
	public static final String Violet     = "\033[36m" ;
	public static final String cyan     = "\033[46m" ;
	public static final String[] color= {"\033[30m","\033[31m","\033[32m","\033[33m","\033[34m","\033[35m","\033[36m","\033[37m","\033[38m","\033[39m"};
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		int score=0;//총 점수 저장 정수형 변수
		int cnt=0;
		

		
		int typeCnt=0;;
		Random random=new Random();
		String randomColor=bold;//기본 색상은 볼드
		Scanner in =new Scanner(System.in);//스캐너 변수 선언
		
	//	System.out.println("아이디입력");
		
		 String[] str = {"apple","bird","cat","airplane","shoes","pocket","america","computer","coffee","keyboard"};
		 String[] str1 = {"app","bir","ct","airpla","shoe","pock","ame","comp","coff","keyb"};
		 String[] temp = {"","","","","","","","","",""};
		 int randArray[]= new int[str.length];//중복 체크 어레이
		 int randomCnt=0;
		//이미 등장한 단어인지 비교하기 위한 배열, 타이핑 할때 str에 해당하는 단어는 템프에서 제거하고 같은 단어가 나오지 않게 처리
		/*
		 * 0행 사용자가 미리 입력한 10개의 단어 저장 배열 행
		 * str1 in.nextLine()으로 사용자가 타이핑한 단어 저장 배열
		 * */
		//String id=in.nextLine();
		for(int i=0;i<=10;i++) {//10번 반복
			int randomIndex=random.nextInt(str.length);//랜덤인덱스는 랜덤배열에서 단어 갯수 내에서 난수 발생
			if(randArray[randomIndex]==0) {//
				randArray[randomIndex]++;
				randomCnt++;
			} else {
				i--;
				continue;
			}
			int randomColorIndex=random.nextInt(color.length);//색상 랜덤 생성
		   // int cor=random.nextInt(color.length);
			String randomWord=str[randomIndex];
			randomColor=color[randomColorIndex];//랜덤색상 생성하는 변수
			//System.out.print("연습할 단어는"+randomWord+"입니다");
			System.out.println("연습할 단어는"+randomColor+str[i]+"");
			//System.out.println("연습할 단어는"+" "+randomColor+str[i]+"");
			
		   String typeLetter=in.nextLine();//키보드로 입력한 값을 저장할 스트링타입 변수 id
		   	typeCnt++;
		   	str1[i]=typeLetter;
		   	System.out.print( str1[i]);
			  if( str1[i].equalsIgnoreCase(str[i])) {//정답일 경우 그냥 패스하고 정답 카운트에 1추가
				  System.out.println(blue+"정답입니다");
				  cnt++;
			  } else {
				  System.out.println("틀린부분은"+str1[i]);
				  System.out.println("정답은"+str[i]);
				  
			  }
		

			 //System.out.println(str[i] +"|"+str1[i]);
			 System.out.println("총점은"+10*cnt);//1문제당 10점 틀린 문제는 0점
			 
			 if(cnt*10==100) {
				   System.out.println("  #    ###  ###");
				   System.out.println("##   #  #  #   #");
				   System.out.println("  #   #   # #    #");
				   System.out.println("  #   #  #  #   #");
				   System.out.println("### ###   ###");
				 
			 }

			 
			  if(typeCnt==10) {//단어를 10번 입력하면 종료
				   break;
			  }
		
			  
		
			  
			  
			  
			  
			  
		}
		
	}

}
