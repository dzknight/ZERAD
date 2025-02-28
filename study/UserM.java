package study;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UserM extends NoteM {
	

	public UserM(String contents) {
		super(contents);
		// TODO Auto-generated constructor stub
	}
	Scanner in=new Scanner(System.in);
	HashMap <String,  String> user=new HashMap<String, String>();
	//HashMap <String, String> member=new HashMap<String, String>(user);
	String id;
	public void menu() {
		// TODO Auto-generated method stub
		boolean flag=true;
		while(true) {
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 회원 모두 보기");
			String select=in.nextLine();
			switch(select) {
				case "1": addUser();break;
				case "2": searchUser();break;
				case "3": delUser();break;
				case "4": viewUser();break;
				case "5": Main.main(null);break;
				default: flag=false;
			}
		}
	}
	private void addUser() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("가입할 아이디를 입력하세요");
		String id=in.nextLine();//id 밸류
		System.out.println("패스워드를 입력하세요");
		String pass=in.nextLine();//pass 키
		user.put(pass,id);
		System.out.println("가입되었습니다");
		System.out.println("가입되었습니다 : "+user.get(pass));
		viewUser();
	}
	private void viewUser() {
		// TODO Auto-generated method stub
		System.out.println("유저모두보기");
//		user.forEach((key,value) -> System.out.printf(key,value));
//		for(java.util.Map.Entry<String, String> entry:user.entrySet()) {
//			System.out.println("아이디"+entry.getKey()+"비번"+entry.getValue());
//		}
//		for(String i:user.keySet()) {
//			System.out.println(user.get(i));
//		}
		Collection<String> values=user.values();
		System.out.println(values);
		
	}
	private void delUser() {
		// TODO Auto-generated method stub
		System.out.println("아이디를 입력하세요");
		Scanner in=new Scanner(System.in);
		String pass=in.nextLine();
		if(user.containsValue(pass)) {
			user.remove(pass);
			System.out.println("아이디가 삭제되었습니다");
		}
		
		
	}
	private void searchUser() {
		// TODO Auto-generated method stub
		System.out.println("아이디를 입력하세요");
		Scanner in=new Scanner(System.in);
		String pass=in.nextLine();
		if(user.containsKey(pass)) {
			System.out.println(user.get(pass));
		}
	}
}
