package sample;

public class UserDTO {
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void prt() {
		// TODO Auto-generated method stub
		System.out.println("id : "+this.id);
		System.out.println("name : "+this.name);
	}
}
