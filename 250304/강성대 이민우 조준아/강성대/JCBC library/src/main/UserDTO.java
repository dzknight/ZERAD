package main;

public class UserDTO {
	private String name;
	private String unum;
	private int book;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public int getBook() {
		return book;
	}
	public void setBook(int book) {
		this.book = book;
	}
	
	public void prt(int i) {
		if(i==3) {
			System.out.println("name: "+this.name);
			System.out.println("unum: "+this.unum);
			System.out.println("book: "+this.book);
		}else if(i==1) {
			System.out.println("name: "+this.name);
		}
		
	}


}
