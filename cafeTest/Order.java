package cafeTest;

import java.util.ArrayList;

public class Order {
	private ArrayList<MenuItem> orderItems; // 주문 항목 리스트

    // 생성자
    public Order() {
        orderItems = new ArrayList<>();
    }

    // 주문 추가 메서드
    public void addOrderItem(MenuItem item) {
        if (item != null) {
            orderItems.add(item);
            System.out.println(item.getName() + "이(가) 주문에 추가되었습니다.");
        } else {
            System.out.println("유효하지 않은 메뉴입니다.");
        }
    }

    // 주문 총액 계산 메서드
    public int calculateTotal() {
        int total = 0;
        for (MenuItem item : orderItems) {
            total += item.getPrice();
        }
        return total;
    }

    // 주문 내역 출력 메서드
    public void displayOrder() {
        System.out.println("\n[주문 내역]");
        for (MenuItem item : orderItems) {
            System.out.println("- " + item.getName() + ": " + item.getPrice() + "원");
        }
        System.out.println("총액: " + calculateTotal() + "원");
    }
}
