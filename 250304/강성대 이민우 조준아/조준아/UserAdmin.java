package sample;
import java.util.ArrayList;
import java.util.Scanner;
// 책임 : 회원을 관리
public class UserAdmin {
	private UserDAO userdao=new UserDAO();
	UserAdmin(){
		Scanner in=new Scanner(System.in);
		boolean f=true;
		while(f) {
			System.out.println("1. 등록	2. 전체보기	3. 수정	4. 삭제");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				add();
				break;
			case 2: 
				allList();
				break;
			case 3:
				up();
				break;
			case 4:
				del();
				break;
			default:
				break;
			}
		}
	}
	private void allList() {
		// TODO select * from user1;
		ArrayList<UserDTO> u=userdao.selectAll();
		for(UserDTO uu:u){
			uu.prt();
		}
	}
	private void add() {
		Scanner in=new Scanner(System.in);
		// 사용자 추가
		// 회원의 이름과 아이디를 입력받는다.
		String name=in.nextLine();
		String id=in.nextLine();
		// 회원 객체를 만든다.
		UserDTO user=new UserDTO();
		// 회원 객체에 입력받는 이름과 아이디를 매핑한다.
		user.setName(name);
		user.setId(id);
		// 회원객체를 데이터베이스에 저장한다.
		userdao.insert(user);
	}
	private void up() {
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		String name=in.nextLine();
		UserDTO user=new UserDTO();
		user.setName(name);
		user.setId(id);
		userdao.up(user);
	}
	private void del() {
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		UserDTO user=new UserDTO();
		user.setId(id);
		userdao.del(user);
	}
}
