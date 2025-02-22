package cafeTest;
//매출정보 관리 클래스
public class Sales {
	private int totalSales; // 총 매출

    // 매출 추가 메서드
    public void addSales(int amount) {
        totalSales += amount;
        System.out.println(amount + "원이 매출에 추가되었습니다.");
    }

    // 총 매출 출력 메서드
    public void displayTotalSales() {
        System.out.println("\n[총 매출]");
        System.out.println("현재까지의 총 매출: " + totalSales + "원");
    }
}

