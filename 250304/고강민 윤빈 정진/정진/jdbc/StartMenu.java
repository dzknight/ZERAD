package jdbc;

import java.util.Scanner;

public class StartMenu {
	StartMenu(){
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		
		while(flag) {
			System.out.println("1.유저관리 2.차관리");
			String a=in.nextLine();
			
			switch(a) {
			case "1": 
				new UserAdmin();
				break;
			case "2":
				new CarAdmin();
				break;
			default:
				flag=false;
				break;
			}
		}
	}
}
