package main;

import java.util.Scanner;

public class BookM {
	private BookDAO bdao=new BookDAO();
	BookM() {

	}

	public void menu() {
		Scanner in= new Scanner(System.in);
		boolean f= true;
		while(f) {
			System.out.println("1. 대여  2. 반납 3. 대여리스트");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				barrow();
				break;
			case 2:
				handin();
				break;
			default:
				f=false;
				break;
			}
		}	
	}

	private void handin() {
		Scanner in= new Scanner(System.in);
		System.out.println("반납하는 책제목 입력");
		String bname=in.nextLine();
		bdao.delete(bname);
	}

	private void barrow() {
		Scanner in= new Scanner(System.in);
		System.out.println("빌려가는 사람 이름 입력");
		String name=in.nextLine();
		System.out.println("책제목 입력");
		String bname=in.nextLine();
		System.out.println("날짜 입력");
		String bdate=in.nextLine();
		BookDTO books=new BookDTO();
		books.setName(name);
		books.setBname(bname);
		books.setBdate(bdate);
		bdao.insert(books);
	}	
}
