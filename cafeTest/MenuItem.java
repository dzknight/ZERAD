package cafeTest;
//카페의 메뉴항목 정의하는 클래스
public class MenuItem {
	   private String name; // 메뉴 이름
	    private int price;   // 메뉴 가격

	    // 생성자
	    public MenuItem(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }

	    // Getter 메서드
	    public String getName() {
	        return name;
	    }

	    public int getPrice() {
	        return price;
	    }
}
