package study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserM userm =new UserM(null); 
		
		//자동차
		boolean flag=true;
		while(flag) {
			Scanner in=new Scanner(System.in);
			System.out.println("1.회원관리");
			System.out.println("2.로그인");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: userm.menu(); break;
			case 2: 
				System.out.println("로그인할 아이디를 입력하세요");
				String userid=in.nextLine();
				System.out.println("비밀번호를 입력하세요");
				String userpw=in.nextLine();
//				ArrayList<NoteOne> list =userm.getnoteList();
				
				if(userid.isEmpty() && userpw.isEmpty()) {
					System.out.println("입력값이 비어있습니다");
				}
				if(!userid.matches(userid)) {
					System.out.println("적합한 아이디가 없습니다");
				}
				if(userid.matches(userid) && userpw.matches(userpw)) {
					System.out.println(userid+"로 로그인되었습니다.");
					
				}
				
				
			default: flag=false;
			}
		}
	}

}
