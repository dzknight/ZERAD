package jdbc;

public class CarDTO {
	private String id;
	private String num;
	private String indate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public void prt() {
		System.out.println(id+" "+num+" "+indate);
		
	}
	
	
}
