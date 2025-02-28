package study;

import java.util.Scanner;

public class StartMenu {
	UserM userm =new UserM(null); 
	
	Scanner in=new Scanner(System.in);
	//자동차
	public void menu() {
		
		boolean flag=true;
		while(flag) {
			System.out.println("1.회원관리");
			System.out.println("2.로그인");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: userm.menu(); break;
			case 2: 
				System.out.println("start로그인할 아이디를 입력하세요");
				String userid=in.nextLine();
				System.out.println("start비밀번호를 입력하세요");
				String userpw=in.nextLine();
//			ArrayList<NoteOne> list =userm.getnoteList();
				
			default: flag=false;
			}
		}
		
	}
}

