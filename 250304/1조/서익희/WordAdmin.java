package main;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordAdmin {
	private WordDao worddao=new WordDao();
	WordAdmin(){
		Scanner in=new Scanner(System.in);
		boolean f=true;
		while(f) {
			System.out.println("1.단어등록 2.전체조회 3.단어검색");
			int a=in.nextInt();
			in.nextLine();
			
			switch (a) {
			case 1:
				add();
				break;
			case 2:
				viewall();
				break;
			case 3:
				view(null);
				break;
			default:
				f=false;break;
			}
		}
	}
	private void view(WordDto w) {
		// TODO Auto-generated method stub
		System.out.println("검색하려는 영단어를 입력하세요");
		Scanner in=new Scanner(System.in);
		String engword=in.nextLine();
		ArrayList<WordDto> u=worddao.select();
		for(WordDto ww:u) {
			ww.prt();
		}
	}
	private void viewall() {
		// TODO Auto-generated method stub
		System.out.println("전체조회");
		ArrayList<WordDto> w=worddao.selectAll();
		for(WordDto ww:w) {
			ww.prt();
		}
		
	}
	private void add() {
		// TODO Auto-generated method stub
		System.out.println("단어추가");
		Scanner in=new Scanner(System.in);
		System.out.println("영단어를 입력하세요");
		String engword=in.nextLine();
		System.out.println("한글뜻를 입력하세요");
		String krword=in.nextLine();
//		Date date=new Date(0);
		Date date=new Date(System.currentTimeMillis());
		WordDto word=new WordDto();
		word.setEngword(engword);
		word.setKrmean(krword);
		word.setInidate(date);
		worddao.insert(word);
	}
}
