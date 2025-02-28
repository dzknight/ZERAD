package study;

import java.util.ArrayList;
import java.util.Scanner;

import study.*;
public class NoteM {
	 String note=null;
	public ArrayList<NoteOne> getNoteone() {
		return noteone;
	}
	public NoteM(String contents) {
		this.note=note;
	}

	
	ArrayList<NoteOne> noteone=new ArrayList<NoteOne>();//타입설정 노트객체만사용가능
//	NoteM note=new NoteM();
	
	public void M_menu() {
		System.out.println("메모관리메뉴입니다");
		boolean flag=true;
		while(flag) {
			Scanner in=new Scanner(System.in);
			System.out.println("1.메모등록");
			System.out.println("2.메모조회");
			System.out.println("3.메모수정");
			System.out.println("4.메모삭제");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
				case 1: addMemo(); break;
				case 2: viewMemo(); break;
				case 3: modMemo(); break;
				case 4: delMemo(); break;
			
			default: M_menu(); flag=false;
			}
		}
	}
	private void delMemo() {
		// TODO Auto-generated method stub
		System.out.println("메모삭제");
	}
	private void modMemo() {
		// TODO Auto-generated method stub
		System.out.println("메모수정");
		
	}
	private void viewMemo() {
		// TODO Auto-generated method stub
		
		System.out.println("메모모두보기");
	}
	private void addMemo() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("메모를 입력하세요");
		String memo=in.nextLine();
		
		
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

		
	
}
