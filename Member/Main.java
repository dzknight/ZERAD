package Member;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("유저관리 프로젝트");
		UserManager userM=new UserManager();
		userM();
	}

	private static void userM() {
		// TODO Auto-generated method stub
		new UserManager().menu();
	}

}
