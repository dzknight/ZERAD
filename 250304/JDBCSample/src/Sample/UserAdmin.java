package Sample;
import java.util.*;
//å�� : ȸ���� �����ϴ� å���� ������ �ִ�. 
public class UserAdmin {
	private UserDAO userdao = new UserDAO();
	UserAdmin(){
		Scanner in = new Scanner(System.in);
		boolean f = true;
		while(f) {
			
			System.out.println("1.��� 2.��ü����");
			int a = in.nextInt();
			in.nextLine();
			switch (a) {
			
			
			case 1 : add();
			
			case 2 : alllist();
			
			default : f = false;
				
			
			}
			
		}
		
	}
	
	
	//ȸ�� �߰�
	private void add() {
		
		Scanner in = new Scanner(System.in);
		
		//����� �߰�
		//ȸ���� �̸��� ���̵� �Է� �޴´�.
		String name = in.nextLine();
		String id = in.nextLine();
		// ȸ�� ��ü�� �����..
		UserDTO user = new UserDTO();
		//ȸ�� ��ü�� �Է� �޴� �̸��� ���̵� �����Ѵ�.
		user.setName(name);
		user.setId(id);
		//ȸ�� ��ü�� �����ͺ��̽��� �����Ѵ�. 
		userdao.insert(user);
	}
	
	
	
	
	//ȸ�� ��ü���� ����Ʈ 
	private void alllist() {
		// ��ü���� select * from user1;
		ArrayList<UserDTO> u = userdao.selectAll();
		for(UserDTO uu : u) {
			
			uu.prt();
			
		}
		
	}

}
