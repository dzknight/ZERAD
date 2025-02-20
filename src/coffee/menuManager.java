package coffee;

import java.util.Scanner;

public class menuManager {
	Scanner sc=new Scanner(System.in);
	public Menu menu[]=new Menu[5];
	
	public void addMenu() {
		boolean nullCheck = false;//널값체크
		boolean nameDupl = false;//메뉴중복 체크
		String name;//이름
		String desc;//설명
		
		
		
		for(int i = 0; i < menu.length; i++) {
			if(menu[i]==null) {
				nullCheck=true;
			}		
		}

		if(nullCheck == false) {
			System.out.println("더 이상 추가할 공간이 없습니다");
			return;
		}
		
		System.out.println("메뉴 등록을 시작합니다");
		
		while(true) {
			System.out.println("메뉴 이름을 입력해주세요");
			name = sc.nextLine();
			
			for(int i = 0; i < menu.length; i++) {
				if(menu[i] != null) {
					if(menu[i].name.equals(name)) {
						nameDupl = true;//중복체크
						break;
					}
				}
			}
			
			if(nameDupl == true) {
				System.out.println("이미 등록된 메뉴입니다");
				nameDupl=false;}
			else
				break;
		}
		
		System.out.println("메뉴 가격을 입력해주세요");
		String price = sc.nextLine();
		String price2 = "";
		
		for(int i = 0; i < price.length(); i++) {
			if('0' <= price.charAt(i) && price.charAt(i) <= '9'){//금액
				price2 += price.charAt(i);
			}  else {
				break;//
			}
		}
		System.out.println("입력하신 금액은 "+price2+"원 입니다");
		
		System.out.println("메뉴설명을 입력하세요 ");
		desc=sc.nextLine();
		
		for(int i = 0; i < menu.length; i++) {
			if(menu[i] == null) {
				menu[i] = new Menu(name,Integer.parseInt(price2),desc);
			}
		}

		System.out.println("메뉴 등록이 완료되었습니다");
		
	}
	
	
}

