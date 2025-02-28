package study;

import java.util.*;


import study.NoteM;

public class NoteOne {
	private String memo;
	String id;
	
	ArrayList<String> list=new ArrayList<String>();
	
	NoteOne noteone=new NoteOne(memo);
	
	public NoteOne(String title2) {
		// TODO Auto-generated constructor stub
		this.memo=memo;
		
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
