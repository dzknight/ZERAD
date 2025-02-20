package coffee;

import java.util.Scanner;

public class startMenu {
	public void startMenu(){
		menuManager menu =new menuManager();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("카페관리 프로젝트");
			System.out.println("1.메뉴등록");
			System.out.println("2.주문하기");
			System.out.println("3.주문조회하기");
			System.out.println("4.리뷰하기");
			System.out.println("0.종료");
			String select=sc.nextLine();
			if(select.equals("1")) {
				menu.addMenu();
				break;
		
			} else if(select.equals("2")) {
				System.out.println("주문하기");
				break;
		
			} else if(select.equals("3")) {
				System.out.println("주문조회하기");
				break;
				
			} else if(select.equals("4")) {
				System.out.println("리뷰하기");
				break;
				
			} else if(select.equals("0")) {
				System.out.println("메뉴종료");
				break;
				
			}else {
				System.out.println("다시 입력하세요 ");
				
			}
	}
	}
}
