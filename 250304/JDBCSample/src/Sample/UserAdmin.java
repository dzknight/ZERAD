package Sample;
import java.util.*;
//책임 : 회원을 관리하는 책임을 가지고 있다. 
public class UserAdmin {
	private UserDAO userdao = new UserDAO();
	UserAdmin(){
		Scanner in = new Scanner(System.in);
		boolean f = true;
		while(f) {
			
			System.out.println("1.등록 2.전체보기");
			int a = in.nextInt();
			in.nextLine();
			switch (a) {
			
			
			case 1 : add();
			
			case 2 : alllist();
			
			default : f = false;
				
			
			}
			
		}
		
	}
	
	
	//회원 추가
	private void add() {
		
		Scanner in = new Scanner(System.in);
		
		//사용자 추가
		//회원의 이름과 아이디를 입력 받는다.
		String name = in.nextLine();
		String id = in.nextLine();
		// 회원 객체를 만든다..
		UserDTO user = new UserDTO();
		//회원 객체에 입력 받는 이름과 아이디를 매핑한다.
		user.setName(name);
		user.setId(id);
		//회원 객체를 데이터베이스에 저장한다. 
		userdao.insert(user);
	}
	
	
	
	
	//회원 전체보기 리스트 
	private void alllist() {
		// 전체보기 select * from user1;
		ArrayList<UserDTO> u = userdao.selectAll();
		for(UserDTO uu : u) {
			
			uu.prt();
			
		}
		
	}

}
