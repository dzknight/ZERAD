package Member;

import java.util.Scanner;

public class UserManager {
	User user[]=new User[10];
	Scanner in=new Scanner(System.in);
	
	public  void menu(){

		while(true) {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("1.회원등록");
			System.out.println("2.회원전체보기");
			System.out.println("3.회원삭제");
			System.out.println("4.회원수정");
			System.out.println("5.회원검색");
			System.out.println("6.사용자취미조회등록");
			System.out.println("7.메모등록");
			System.out.println("0.종료");
			
			String select=sc.nextLine();
//			while(true) {
				switch(select) {
					case "1":
						add();//회원등록
						break;
					case "2":
						showAll();//회원모두보기
						break;
					case "3":
						delete();//회원삭제
						break;
					case "4":
						mod();//회원기본수정,취미등록
						break;
					case "5":
						view();//회원검색
						break;
					case "6":
						addHobby();//사용자취미조회등록
						break;
					case "7":
						addMemo();//메모조회등록
						break;
					case "0":
						exit();//종료
						break;
				}
			}
//		}
		
	}
	//회원등록
	public  void add() {
		boolean nullChk=false;
		System.out.println("회원등록을시작합니다");
		for(int i=0;i<user.length;i++) {
			if(user[i]==null) {
				nullChk=true;
				break;
			}
		}
		if(nullChk==false) {
			System.out.println("더이상 빈공간이 없음");
			return;
		}
		Scanner sc=new Scanner(System.in);
		
		
			System.out.println("아이디를 입력");
			String id=sc.nextLine();
			System.out.println("이름을 입력");
			String name=sc.nextLine();
			System.out.println("주소를 입력");
			String addr=sc.nextLine();
			System.out.println("미성년자이면 y 아니면 n");
			String adult=sc.nextLine();
			if(adult.equalsIgnoreCase("y")||adult.equalsIgnoreCase("n")) {
				for(int i=0;i<user.length;i++) {
					if(user[i]==null) {
						user[i]=new User(id, name, addr, adult);
						break;
					}
				}
				showAll();
				
			}else {
				System.out.println("바른입력값을 입력하세요");
			}
			//회원정보 모두출력
//			showAll();
		
	}
	public void showAll() {
		System.out.println("회원정보를 모두출력합니다");
	
		for(int i=0;i<user.length;i++) {
			
			if(user[i]!=null) {
				System.out.println("id:"+user[i].id);
				System.out.print("name:"+user[i].name);
				
				if(user[i].adult.contains("y")) {
					System.out.println(user[i].adult.replaceFirst(user[i].adult, "(미성년자)"));
				} else {
					System.out.println(user[i].adult.replaceFirst(user[i].adult, ""));
				}
				
				System.out.println("addrs:"+user[i].addr);//주소출력
				for(int j=0;j<user[0].hobby.length;j++) {
					if(user[i].hobby[j] !=null) {
						System.out.println("취미는"+user[i].hobby[j]);//객체의 변수를 접근
					}
				}
				
				System.out.println("메모:");
				
				for(int j=0;j<user[0].memo.length;j++) {
					if(user[i].memo[j]!=null) {//메모가 널이 아니라면 출력
						System.out.println(user[i].memo[j]);
					}
				}
			}
		}
		
	}
	
	//메모등록
	private void addMemo() {
		// TODO Auto-generated method stub
		boolean nullChk=false;
		System.out.println("메모등록을시작합니다");
		System.out.println("아이디를입력하세요");
		Scanner sc=new Scanner(System.in);
		String id=sc.nextLine();//input
		
		int index=searchUser(id);
		
		if(index==-1) {
			System.out.println("해당아이디가 없습니다");
			return;
		}
		
		nullChk=nullCheck(index);//?
		for(int i=0;i<user.length;i++) {
			if(user[i]==null) {
				nullChk=true;
				break;
			}
		}
		if(nullChk==false) {
			System.out.println("더이상 빈공간이 없음");
			return;
		}
		System.out.println("메모를입력하세요");
		String memo=sc.nextLine();
		for(int i=0;i<memo.length();i++) {
			for(int j=0;j<user[index].memo.length;j++) {
				user[index].memo[j]=memo;
			}
		}
	}
	
	

	
	
	public void delete() {
		Scanner sc=new Scanner(System.in);
		System.out.println("회원정보를 삭제합니다");
		
		System.out.println("아이디를 입력하세요");
		
		String id=sc.nextLine();
		int index=searchUser(id);
		
		if(index==-1) {
			System.out.println("해당유저가 없습니다");
		}
		user[index]=null;
		/*
		for(int i=0;i<user.length;i++) {
			
			if(user[i].id==id) {
				user[i]=null;
			}
			if(user[i]==null) {
				System.out.println("아이디가 없습니다");
				break;
			}
		}
		*/
		

		System.out.println("아이디를 삭제했습니다");
	}
	//기본정보수정
	public void mod() {
		while(true) {
			int input;
			System.out.println("1.기본정보수정");
			System.out.println("2.취미등록");
			input=in.nextInt();
			in.nextLine();//버퍼클리어 이전의개행문자 제거
			
			if(input==1) {
				normalMod();
				break;
			} else if(input==2) {
				addHobby();
				break;
			} else {
				System.out.println("다시입력해주세요");
			}
		}
	}

	
	private void addHobby() {
		// TODO Auto-generated method stub
		boolean nullCheck=false;
		String input;
		System.out.println("아이디를 입력");
		input=in.nextLine();
		int index=searchUser(input);
		if(index==-1) {
			System.out.println("일치하는 회원이 없습니다");
			return;
		}
		nullCheck=nullCheck(index);//해당
		if(nullCheck==false) {//불린 타입 널체크가 거짓이라면 =모든 취미공간이 점유되어있다
			System.out.println("취미는 5개까지 입력할수 있씁니다");
			return;//break
		}
		System.out.println("취미를 입력하세요");
		input=in.nextLine();
		for(int j=0;j<user[index].hobby.length;j++) {
			//유저객체의 인덱스(id)를 가져온결과로 해당유저의 취미의 길이 호출 반복
			if(user[index].hobby[j]==null) {
				user[index].hobby[j]=input;
				break;//반복문에서 사용
			}
			
		}
		System.out.println("취미등록이 완료되었습니다");
		
	}
	//메모가 비었는지 체크하는 메서드
	private boolean nullCheck(int index) {//유저인덱스 인자의미?
		// TODO Auto-generated method stub
		for(int i=0;i<user[0].memo.length;i++) {//유저객체의 메모길이까지 반복
			if(user[index].memo[i]==null) {
				return true;
			}
		}
		return false;
	}
	//유저일반검색메서드 인자 아이디
	public int searchUser(String id) {
		for(int i=0;i<user.length;i++) {
			if(user[i]!=null) {//유저가 널이 아니고
				if(user[i].id.equals(id)) {//유저아이디가 입력한 아이디값과 같다면
					return i;			//i값을 리턴
				}
			}
		}
		return -1;//유저가 널이라면 -1을 리턴
	}
	
	private void normalMod() {
		// TODO Auto-generated method stub
		System.out.println("회원정보수정입니다");
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디를 입력하세요1");
		String id=sc.nextLine();
		int index=searchUser(id);
		//if(user[index]!=null) {
		if(index==-1) {
			System.out.println("해당사용자가 없습니다");
			return;
			
		}
		
		System.out.println("수정할 아이디를 입력하세요");
		user[index].id=in.nextLine();
		System.out.println("수정할 이름를 입력하세요");
		user[index].name=in.nextLine();
		System.out.println("수정할 주소를 입력하세요");
		user[index].addr=in.nextLine();
		System.out.println("수정할 미성년자여부를 입력하세요");
		user[index].adult=in.nextLine();
		System.out.println("수정된 아이디는"+user[index].id);
		System.out.println("수정된 이름은"+user[index].name);
		System.out.println("수정된 주소는"+user[index].addr);
		System.out.println("수정된 미성년자여부는"+user[index].adult+"입니다");
		
	}
	//사용자취미조회
	public void hobbyMod() {
		Scanner sc=new Scanner(System.in);
		System.out.println("사용자의 아이디를 입력하세요");
		String id=sc.nextLine();
		
		for(int i=0;i<user.length;i++) {
			int cnt=0;
			if(user[i].equals(id)) {
				cnt++;
			} 
			
			if(cnt==0) {
				System.out.println("해당하는사용자가 없습니다 다시입력하세요");
				break;
			}
		}
		System.out.println("사용자의 취미를 입력하세요");
		String hobby=sc.nextLine();
		for(int i=0;i<user.length;i++) {
			if(user[i].equals(id)) {
				System.out.println(user[i].hobby);
			}
		}
	}
		
		
		
	
//종료
	public void exit() {
		System.out.println("메뉴를 종료합니다");
		
		
	}
	
	//회원정보검색
	public void view() {
		Scanner sc=new Scanner(System.in);
		System.out.println("회원조회메뉴입니다");
		
		System.out.println("아이디를 입력하세요");
		String id=sc.nextLine();
		for(int i=0;i<user.length;i++) {
			if(user[i].toString().contains(id)) {
				System.out.println(user[i].id);
				System.out.println(user[i].name);
//				System.out.println(user[i].adult);
				if(user[i].adult.contains("y")) {
					System.out.println(user[i].adult.replaceFirst(user[i].adult, "(미성년자)"));
				} else {
					System.out.println(user[i].adult.replaceFirst(user[i].adult, ""));
				}
				System.out.println(user[i].addr);
				System.out.println(user[i].hobby[i]);//user[i].hobby[i]
				
			}
		}
		menu();
		
	}
}

