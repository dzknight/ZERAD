package menu;

public class MenuDTO {
	private int num = 0;
	private String menu = null;
	private int price = 0;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String name) {
		this.menu = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void prt() {
		System.out.println("메뉴번호 : "+num);
		System.out.println("메뉴명 : "+menu);
		System.out.println("가격 : "+price);
		
		System.out.println("\n");
	}
	
}
