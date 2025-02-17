package main;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class VocaCrud {
	static String[] engMean = {"important","pattern","","finish","intern"};
	static String[] krMean = {"중요한","패턴","","종료","인턴"};
	
	public static void main(String[] args) throws NoSuchElementException{
		// TODO Auto-generated method stub
		System.out.println("2"+engMean[2].length());
		Scanner in = new Scanner(System.in);
		menu();
		
		int num=in.nextInt();
		if(num==1) {
			saveEnglish();
		} else if(num==2) {
			prtAllEng();
		} else if(num==3) {
			searchEng();
		} else if(num==4) {
			updateEng();
		} else if(num==5) {
			deleteEng();
		}else if(num==6) {
			enrollAll();
		} else {
			menu();
		}
		//NoSuchElementException 처리구문
		Optional<String> optional = Optional.ofNullable(null);
        
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("더이상 결과가 없습니다.");
        }
	}
	public static void menu() {
		// TODO Auto-generated method stub
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.단어저장");
		System.out.println("2.단어전체보기");
		System.out.println("3.검색하기");
		System.out.println("4.수정하기");
		System.out.println("5.삭제하기");
		System.out.println("6.일괄 단어&뜻 입력");
		
	}
	//1. 영어 단어, 뜻 저장 기능 +  영어단어와 뜻도 보여주는 기능 추가
    public static void saveEnglish() {
    	System.out.println("단어와 뜻을 저장합니다");
    	//단어장이 비어있을 경우
    	for(int i=0;i<5;i++) {
    		if(engMean[i].length()==0) {
    			System.out.println("단어장이 비어있습니다");
    			System.out.println("저장할 단어를 입력하세요");
    	    	Scanner in = new Scanner(System.in);
    	    	String char2=in.next();//저장할 단어를 입력
    	    	engMean[i]=char2;
    	    	System.out.println("단어의 뜻을 입력하세요");
    	    	String char3=in.next();//저장할 단어를 입력
    	    	krMean[i]=char3;
    	    	System.out.println("저장할 단어는"+engMean[i]+" 뜻은"+krMean[i]);
    		} else if(engMean[i] != "") {
    			System.out.println("비어있는 단어장이 없습니다 삭제후 다시 시도하세요");
    			System.out.println("단어장 삭제로 이동합니다");
    			deleteEng();
    		}
    		
    	}
    	
    	
    }
    //2. 저장된 전체 단어 및 한글뜻 보기기능
    public static void prtAllEng() {
    	System.out.println("저장된 모든 단어와 뜻을 출력합니다");
    	for(int i=0;i<5;i++) {
    		System.out.println(engMean[i]);
    		System.out.println(krMean[i]);
    		
    	}
    }
    //3. 검색하기 기능  + 영어단어와 뜻도 검색해서 보기, 입력한 단어와 비슷한단어도 같이 보여주기 
    public static void searchEng() {
    	System.out.println("검색할 단어를 입력하세요");
    	Scanner in = new Scanner(System.in);
    	String char2=in.next();
    	for(int i=0;i<5;i++) {
    		if(engMean[i].contains(char2)) {
	    		System.out.println(engMean[i]+" 뜻은 "+krMean[i]);
	 
    		}
    	}
    	in.close();
    }
    //5.단어 삭제 기능
    public static void deleteEng()  {
    	System.out.println("지울단어를 입력하세요");
    	System.out.println("단어장의 현재 리스트입니다");
    	prtAllEng();
    	Scanner in = new Scanner(System.in);
    	String char1=in.next();
    	
    	for(int i=0;i<5;i++) {
    		if(char1.equalsIgnoreCase(engMean[i])) {
    			engMean[i]="";
    			krMean[i]="";
    		}
    	}
    	
    	System.out.println("입력한"+char1+"은 삭제되었습니다");
    	System.out.println("단어장의 현재 리스트입니다");
    	prtAllEng();
    	
		in.close();
    }
    //4. 단어 수정 기능
    public static void updateEng() {
    	System.out.println("수정할단어를 입력하세요");
    	Scanner in = new Scanner(System.in);
    	String char4=in.next();
    	for(int i=0;i<5;i++) {
    		if(engMean[i].contentEquals(char4)) {
    			System.out.println("새로 입력할 단어를 입력하세요");
    			String char5=in.next();
    			engMean[i]=char5;
    			System.out.println("단어의 뜻을 입력하세요");
    			String char6=in.next();
    			krMean[i]=char6;
    		}
    	}
    	System.out.println("갱신된 단어리스트입니다");
    	prtAllEng();
    	in.close();
    }
    	
    //6.단어 일괄 저장
    public static void enrollAll() {
    	System.out.println("일괄 단어입력입니다");
  
    	for(int i=0;i<5;i++) {
    		System.out.println((i+1)+"번째 새로 입력할 단어를 입력하세요");
        	Scanner in = new Scanner(System.in);
        	String char7=in.next();
        	engMean[i]=char7;
        	System.out.println((i+1)+"단어의 뜻을 입력하세요");
        	String char8=in.next();
        	krMean[i]=char8;
    	}
    	prtAllEng();//입력한 값 확인용 메서드
    	
    }
}

