package sample;
// 책임: 회원 한명의 정보를 저장
public class UserDTO {
	private String id=null;
	private String name=null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void prt() {
		System.out.println("id : "+this.id);
		System.out.println("name : "+this.name);
	}
}
