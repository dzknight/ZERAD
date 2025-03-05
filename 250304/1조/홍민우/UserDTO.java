package Tset;

public class UserDTO {
	private String english;
	private String korean;
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	
	public void prt() {
		System.out.println(this.english);
		System.out.println(this.korean);
	}
	
}
