package main;

import java.util.ArrayList;
import java.util.Scanner;

public class UserM {
	private UserDAO userdao= new UserDAO();
	UserM(){
	}

	public void menu() {
		Scanner in= new Scanner(System.in);
		boolean f= true;
		while(f) {
			System.out.println("1. 회원등록  2. 전체보기  3. 회원수정  4.회원 삭제");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: 
				add();
				break;
			case 2:
				allist();
				break;
			case 3:
				mod();
				break;
			case 4:
				delete();
				break;
			default:
				f=false;
				break;	
			}
		}
		
	}


	private void delete() {
		Scanner in= new Scanner(System.in);
		System.out.println("삭제하고 싶은 이름을 입력하세요");
		String name=in.nextLine();
		userdao.delete(name);
	}

	private void mod() {
		Scanner in= new Scanner(System.in);
		ArrayList<UserDTO> u=userdao.selectall();
		for(UserDTO uu: u) {
			uu.prt(1);
		}
		System.out.println("수정하고 싶은 이름을 입력하세요");
		String name=in.nextLine();
		System.out.println("바꿀 이름을 입력하세요");
		String name2=in.nextLine();
		userdao.modify(name, name2);
	}

	private void allist() {
		ArrayList<UserDTO> u=userdao.selectall();
		for(UserDTO uu: u) {
			uu.prt(3);
			System.out.println();
		}
	}

	private void add() {
		Scanner in= new Scanner(System.in);
		System.out.println("이름과 회원번호 입력");
		String name=in.nextLine();
		String unum=in.nextLine();
		UserDTO user= new UserDTO();
		user.setName(name);
		user.setUnum(unum);
		userdao.insert(user);
	}

}
