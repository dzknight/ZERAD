package Tset;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAdmin {
	private UserDAO userdao = new UserDAO();
	UserAdmin(){
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("1.등록  2.전체보기 3.수정하기 4.삭제하기");
			int a = s.nextInt();
			s.nextLine();
			switch(a) {
			case 1:	add();	break;
			case 2: allList();	break;
			case 3: update(); break;
			case 4: delete(); break;
			default : flag=false; break;
			}
		}
	}
	private void add() { // 올리기용
		Scanner s = new Scanner(System.in);
		String english = s.nextLine();
		String korean = s.nextLine();
		UserDTO user = new UserDTO();
		user.setEnglish(english);
		user.setKorean(korean);
		userdao.insert(user);
	}
	private void update() { // 수정하기
		userdao.update();
	}
	private void delete() { // 삭제하기
		userdao.delete(); 
	}
	private void allList() { // 올린거 전체보기용
		ArrayList<UserDTO> u = userdao.selectAll();
		for (UserDTO uu : u) {
			uu.prt();
		}
	}
}
