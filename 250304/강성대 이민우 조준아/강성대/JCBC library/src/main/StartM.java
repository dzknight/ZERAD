package main;

import java.util.Scanner;

public class StartM {
	UserM um=new UserM();
	BookM bm=new BookM();
	StartM(){
		Scanner in= new Scanner(System.in);
		boolean f= true;
		while(f) {
			System.out.println("1. 회원 관리  2. 책 관리");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: 
				um.menu();
				break;
			case 2:
				bm.menu();
				break;
			default:
				f=false;
				break;	
			}
		}
	}

}
