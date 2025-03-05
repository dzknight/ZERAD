package sample;

//책임 : 회원 한 명의 정보를 저장
public class UserDTO {
	private String name;
	private String id;
	private String addr;
	private int age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void prt() {
		System.out.println("id: " + this.id);
		System.out.println("name: " + this.name);
		System.out.println("addr: " + this.addr);
		System.out.println("age: " + this.age);
	}
}