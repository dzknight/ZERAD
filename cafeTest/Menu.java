package cafeTest;


import java.util.ArrayList;
	//여러 메뉴아이템 객체를 관리함
	public class Menu {
	    private ArrayList<MenuItem> items; // 메뉴 항목 리스트

	    // 생성자
	    public Menu() {
	        items = new ArrayList<>();
	    }

	    // 메뉴 추가 메서드
	    public void addMenuItem(String name, int price) {
	        items.add(new MenuItem(name, price));
	    }

	    // 메뉴 출력 메서드
	    public void displayMenu() {
	        System.out.println("\n[카페 메뉴]");
	        for (int i = 0; i < items.size(); i++) {
	            MenuItem item = items.get(i);
	            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice() + "원");
	        }
	    }

	    // 특정 메뉴 반환 메서드
	    public MenuItem getMenuItem(int index) {
	        if (index >= 0 && index < items.size()) {
	            return items.get(index);
	        }
	        return null;
	    }
}
