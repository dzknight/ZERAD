package library;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManage {
	private UserDAO userdao = new UserDAO();
	UserManage(){
		Scanner in = new Scanner(System.in);
		boolean f = true;
		while(f) {
			System.out.println("1.등록	 2.회원 삭제	 3.회원번호 수정 	 9.전체보기");
			int a= in.nextInt();
			in.nextLine();
			
			switch (a) {
			case 1:
				add();
				break;
			case 2:
				deleteUser();
				break;
			case 3:
				updateUserNum();
			case 9:
				allList();
				break;
			default: f = false;
				break;
			}
		}
		
	}
	private void deleteUser() {
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 회원의 아이디 입력");
		String id = in.nextLine();
		
		
		
		userdao.delete(id);
	}
	private void updateUserNum() {
		Scanner in = new Scanner(System.in);
		System.out.println("회원 변호를 변경할 회원의 아이디 입력");
		String id = in.nextLine();
		System.out.println("변경할 번호 입력 : ");
		int num = in.nextInt();
		in.nextLine();
		
		
		
		userdao.update(id, num);
	}

	private void allList() {
		//전체보기 : select * from user2
		ArrayList<UserDTO> u = userdao.selectAll();
		for(UserDTO uu : u) {
			uu.prt();
		}
		
	}

	private void add() {
		Scanner in = new Scanner(System.in);
		//사용자 추가
		//회원의 이름과 아이디를 입력 받는다
		String name = in.nextLine();
		int num = in.nextInt();
				in.nextLine();
		//회원 객체를 만든다
		UserDTO user = new UserDTO();
		//회원 객체에 입력 받는 이름과 아이디를 매핑한다
		user.setName(name);
		user.setNum(num);
		//회원 객체를 데이터베이스에 저장한다
		userdao.insert(user);
		
	}
}
