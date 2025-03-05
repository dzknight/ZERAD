package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
	private MenuDAO menudao = new MenuDAO();
	
	public void mainMenu() {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.메뉴등록 2.전체보기 3.메뉴삭제 4.메뉴수정 5.종료");
			input = in.nextInt();
			in.nextLine();
			
			switch(input) {
			case 1: add(); break;
			case 2: showAll(); break;
			case 3: delete(); break;
			case 4: mod(); break;
			case 5: flag = false ; break;
			default: System.out.println("다시 입력하세요");
			}
		}
	}

	private void mod() {
		Scanner in = new Scanner(System.in);
		int num = 0;
		String menu = null;
		int price = 0;
		
		System.out.println("수정하려는 메뉴의 번호를 입력하세요");
		num = in.nextInt();
		in.nextLine();
		
		menudao.mod(num);
	}

	private void delete() {
		Scanner in = new Scanner(System.in);
		int num = 0;
		
		System.out.println("삭제하려는 메뉴의 번호를 입력하세요");
		num = in.nextInt();
		in.nextLine();
		
		menudao.delete(num);
	}

	private void showAll() {
		ArrayList<MenuDTO> m = menudao.selectAll();

		if(m.get(0) == null) {
			System.out.println("연결 실패로 수행할 수 없습니다");
			return;
		}
		
		for(MenuDTO mm : m) {
			mm.prt();
		}
	}

	private void add() {
		Scanner in = new Scanner(System.in);
		String menuName = null;
		int price = 0;
		int num = 0;
		
		System.out.println("메뉴 번호를 입력하세요");
		num = in.nextInt();
		in.nextLine();
		System.out.println("메뉴 이름을 입력하세요");
		menuName = in.nextLine();
		System.out.println("메뉴 가격을 입력하세요");
		price = in.nextInt();
		in.nextLine();
		
		MenuDTO menu = new MenuDTO();
		
		menu.setNum(num);
		menu.setMenu(menuName);
		menu.setPrice(price);
		
		menudao.insert(menu);
	}
}
