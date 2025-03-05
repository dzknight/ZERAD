package jdbc;
// 책임: 유저 관리

import java.util.ArrayList;
import java.util.Scanner;

public class UserAdmin {
	UserDAO userdao=new UserDAO();
	
	UserAdmin(){
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
		userdao.exit();
	}

	private void update() {
		System.out.println("수정할 이름 입력");
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		
		System.out.println("변경할 id,주소,나이 입력");
		String id=in.nextLine();
		String addr=in.nextLine();
		int age=in.nextInt();
		
		UserDTO u=new UserDTO();
		u.setAddr(addr);
		u.setAge(age);
		u.setId(id);
		u.setName(name);
		userdao.update(u);
		
	}

	private void delete() {
		System.out.println("삭제할 이름 입력");
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		
		userdao.delete(name);
		
	}

	private void view() {
		ArrayList<UserDTO> ulist=userdao.load();
		
		for(UserDTO u:ulist) {
			u.prt();
		}
		
	}

	private void add() {
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		String id=in.nextLine();
		String addr=in.nextLine();
		int age=in.nextInt();
		
		UserDTO u=new UserDTO();
		u.setAddr(addr);
		u.setAge(age);
		u.setId(id);
		u.setName(name);
		userdao.insert(u);
		
	}


}
