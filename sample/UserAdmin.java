package sample;

import java.util.ArrayList;
import java.util.Scanner;

//유저를 관리
public class UserAdmin {
	private UserDAO userdao=UserDAO.getInstance();
	UserAdmin(){
		Scanner in= new Scanner(System.in);
		boolean f=true;
		while(f) {
			System.out.println("1.등록 2.전체보기");
			int a=in.nextInt();
			in.nextLine();
			
				switch(a) {
				case 1:add(); break;
				case 2:allList(); break;
				case 3:delList(); break;
				default :f=false; break;
				}
		}
	}

	private void delList() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력하세요");
		String id=in.nextLine();
		UserDTO user=new UserDTO();
	}

	private void allList() {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> u=userdao.selectAll();//리턴해서 받으려고 //뒤에부터 검토
		for(UserDTO uu:u) {
			uu.prt();
		}
	}

	private void add() {
		// TODO Auto-generated method stub
		//유저 에드 회원의 아이디돠 이름을 입력받는다
		//회원 객체를 만든다
		//회원 객체에 입력받는 이름과 아이디를 매핑한다
		//회원 객체를 디비에 저장한다
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		String id=in.nextLine();
		
		UserDTO user=new UserDTO();
		user.setName(name);
		user.setId(id);
		userdao.insert(user);
		//call br re
	}
}
