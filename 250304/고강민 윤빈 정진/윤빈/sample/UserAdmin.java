package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAdmin {
	private UserDAO userdao = new UserDAO();

	UserAdmin() {
		Scanner in = new Scanner(System.in);
		boolean f = true;
		while (f) {
			System.out.println("1.등록 2.전체보기 3.수정 4.삭제");
			int a = in.nextInt();
			switch (a) {
			case 1:
				add();
				break;
			case 2:
				allList();
				break;
			case 3:
				update();
				break;
			default:
				f = false;
				break;
			}
		}
	}

	private void add() {
		Scanner in = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		String name = in.nextLine();
		System.out.println("아이디를 입력해주세요.");
		String id = in.nextLine();
		System.out.println("주소를 입력해주세요.");
		String addr = in.nextLine();
		System.out.println("나이를 입력해주세요.");
		int age = in.nextInt();
		UserDTO user = new UserDTO();
		user.setName(name);
		user.setId(id);
		user.setAddr(addr);
		user.setAge(age);
		userdao.insert(user);
	}

	private void update() {
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 사용자의 ID를 입력하세요:");
		String id = in.nextLine();

		UserDTO user = userdao.selectOne(id);

		if (user == null) {
			System.out.println("해당 ID의 사용자가 존재하지 않습니다.");
			return;
		}

		System.out.println("수정할 내용을 선택하세요:");
		System.out.println("1. 이름");
		System.out.println("2. 주소");
		System.out.println("3. 나이");
		System.out.println("4. 아이디");
		int k = in.nextInt();
		in.nextLine();

		switch (k) {
		case 1:
			System.out.println("새로운 이름을 입력하세요:");
			String newName = in.nextLine();
			user.setName(newName);
			break;
		case 2:
			System.out.println("새로운 주소를 입력하세요:");
			String newAddr = in.nextLine();
			user.setAddr(newAddr);
			break;
		case 3:
			System.out.println("새로운 나이를 입력하세요:");
			int newAge = in.nextInt();
			user.setAge(newAge);
			break;
		case 4:
			System.out.println("새로운 아이디를 입력하세요:");
			String newId = in.nextLine();
			user.setId(newId);
			break;
		default:
			System.out.println("잘못된 선택입니다.");
		}

		userdao.update(user);
		System.out.println("수정이 완료되었습니다.");
	}

	private void allList() {
		ArrayList<UserDTO> u = userdao.selectAll();
		for (UserDTO uu : u) {
			uu.prt();
		}
	}
}
