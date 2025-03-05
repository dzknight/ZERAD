package library;


public class UserDTO {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private int num;
	
	public void prt() {
		System.out.println("name : "+this.name+"	num : "+this.num);
		
	}
}
