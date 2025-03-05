package jdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class CarAdmin {
	CarDAO cardao=new CarDAO();
	
	CarAdmin(){
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.등록 2.전체보기 3.삭제 4.수정");
			String a=in.nextLine();
			
			switch(a) {
			case "1": 
				add();
				break;
			case "2":
				view();
				break;
			case "3":
				delete();
				break;
			case "4":
				update();
				break;
			default:
				flag=false;
				break;
			}
		}
		cardao.exit();

	}
	
	private void update() {
		System.out.println("수정할 id 입력");
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		
		System.out.println("차번호 입력");
		String num=in.nextLine();
		
		CarDTO c=new CarDTO();
		c.setId(id);
		c.setNum(num);
		cardao.update(c);
		
	}

	private void delete() {
		System.out.println("삭제할 차번호 입력");
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		
		cardao.delete(name);
		
	}

	private void view() {
		ArrayList<CarDTO> clist=cardao.load();
		
		for(CarDTO c:clist) {
			c.prt();
		}
		
	}

	private void add() {
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		String num=in.nextLine();
		
		CarDTO c=new CarDTO();

		c.setId(id);
		c.setNum(num);
		cardao.insert(c);
		
	}


}
