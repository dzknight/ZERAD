package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAdmin {

	private UserDAO userdao = new UserDAO(); // userado라는 새로운객체 생성
	

	UserAdmin() {
		Scanner in = new Scanner(System.in); // 사용자에게 키보드로 입력받는스캐너 객체
		boolean t = true; // 트루는 t 참일때 실행

		while (t) {
			System.out.println("1.등록 2.전체보기");
			int a = in.nextInt(); // 정수를 입력받는다

			switch (a) {
			case 1: //1번 입력시 add 메서드실행
				add();
				break;
			case 2:
				allList(); // 2번입력시 allList 메서드 실행
				break;
			default: // 그 외 번호 누를시 default 실행 
				break;
				

			}
		}

	}

	private void allList() {
		//전체보기 select * from user2
		ArrayList<UserDTO> u = userdao.selectAll();
		//userdao 객체의 selectAll 메서드를 호출해 모든 사용자 데이터를 가져옴
		for (UserDTO uu : u) { 
			uu.prt();
			//ArrayList<UserDTO>
			//u 안에 있는 각 UserDTO 객체를 순차적으로 가져와서 변수 uu에 할당합니다.
			//prt는 UserDTO클래스에있는 사용자 정보를출력
		}

	}

	private void add() {
		Scanner in = new Scanner(System.in);
		//사용자를 추가하는 기능
		//회원은 자신의 이름,아이디, 주소, 나이를 입력해야한다
		String name = in.nextLine();
		String id = in.nextLine();
		String addr = in.nextLine();
		int age = in.nextInt();
		//회원 객체를 생성한다
		UserDTO user = new UserDTO();
		// 회원 객체에서 입력받는 이름과 아이디를 매핑한다
		user.setName(name);
		user.setId(id);
		user.setAddr(addr);
		user.setAge(age);
		//회원 객체를 데이터 베이스에 저장한다
		userdao.insert(user);


	}

}
