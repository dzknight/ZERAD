package Admin;

import java.util.Scanner;

public class Manager {
	Scanner in=new Scanner(System.in);
	Member[] m=new Member[5];
	
	Manager() {
		System.out.println("회원관리 프로그램");
		int sel=-1;
		
		while(true) {
			System.out.println("\n1.등록    2.전체보기   3.삭제    4.수정   5.검색");
			sel=in.nextInt();
			in.nextLine();
			
			if(sel==1) {
				add();
			}else if(sel==2) {
				view();
			}else if(sel==3) {
				delete();
			}else if(sel==4) {
				update();
			}else if(sel==5) {
				search();
			}else {
				break;
			}
		}
	}
	
	
	public void add() {									//추가
		System.out.println("아이디를 입력하세요: ");
		String id=in.nextLine();
		
		if(check(id)>-1) {
			System.out.println("아이디 중복, 처음으로 돌아갑니다.");
			return;
		}
		System.out.println("이름을 입력하세요: ");
		String name=in.nextLine();
		
		System.out.println("주소를 입력하세요: ");
		String addr=in.nextLine();
		
		System.out.println("성년 여부를 입력하세요: 1.성인, 2.미성년자");
		int input=in.nextInt();
		boolean adult=true;
		if(input==2) {
			adult=false;
		}
		Member temp=new Member(id,name,addr,adult);
		
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				m[i]=temp;
				System.out.println("등록되었습니다.");
				return;
			}
		}
		System.out.println("회원은 5명까지 입력할수 있습니다.");
		
	}
	
	
	public void view() {								//전체보기
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {
				m[i].mPrt();
			}
		}
	}
	
	
	public void delete() {								//삭제
		System.out.println("삭제할 아이디를 입력하세요: ");
		String id=in.nextLine();
		int index=check(id);
		
		if(index==-1) {
			System.out.println("없는 아이디 입니다.");
			return;
		}
		m[index]=null;
		
		System.out.println("삭제되었습니다");
		
	}
	
	
	public void update() {									//수정
		int sel=-1;
		
		System.out.println("수정할 아이디를 입력하세요: ");
		String id=in.nextLine();
		int index=check(id);
		
		if(index==-1) {
			System.out.println("없는 아이디 입니다.");
			return;
		}
		
		while(sel<6) {
			System.out.println("\n1.회원정보수정  2.취미등록  3.취미삭제  4.메모작성  5.메모삭제  6.돌아가기");
			sel=in.nextInt();
			in.nextLine();
			if(sel==1) {
				System.out.println("수정할 이름을 입력하세요: ");
				m[index].name=in.nextLine();
				
				System.out.println("수정할 주소를 입력하세요: ");
				m[index].addr=in.nextLine();
				
				System.out.println("수정완료");
				
			}else if(sel==2) {
				System.out.println("등록할 취미를  입력하세요: ");
				m[index].addHobby(in.nextLine());
				
			}else if(sel==3) {
				System.out.println("삭제할 취미의 번호를  입력하세요: ");
				int index2=in.nextInt();
				in.nextLine();
				if(index2<5 && index2>=0)
					m[index].hobby[index2]=null;

			}else if(sel==4) {
				System.out.println("등록할 메모의 제목을  입력하세요: ");
				String title=in.nextLine();
				System.out.println("등록할 메모의 내용을  입력하세요: ");
				String memo=in.nextLine();
				
				m[index].addNote(title,memo);
				
			}else if(sel==5) {
				System.out.println("삭제할 메모의 번호를  입력하세요: ");
				int index2=in.nextInt();
				in.nextLine();
				if(index2<10 && index2>=0)
					m[index].note[index2]=null;

				
			}
		}
	}
	
	
	public void search() {									//검색
		System.out.println("검색할 아이디를 입력하세요: ");
		String id=in.nextLine();
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {
				if(m[i].id.indexOf(id)>-1) {
					m[i].mPrt();
				}
			}
		}
	}
	
	
	public int check(String id) {							//일치하는 id 인덱스 반환
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {
				if(m[i].id.equals(id)) {
					return i;
				}
			}
		}
		return -1;
	}
	
}
