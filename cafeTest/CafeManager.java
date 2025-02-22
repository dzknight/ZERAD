package cafeTest;

import java.util.Scanner;

public class CafeManager {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        Sales sales = new Sales();

        // 초기 메뉴 추가
        menu.addMenuItem("아메리카노", 3000);
        menu.addMenuItem("카페라떼", 3500);
        menu.addMenuItem("카라멜 마키아토", 4000);
        
        boolean running = true;

        while (running) {
            System.out.println("\n[카페 관리 프로그램]");
            System.out.println("1. 메뉴 보기");
            System.out.println("2. 주문하기");
            System.out.println("3. 매출 보기");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menu.displayMenu(); // 메뉴 출력
                    break;

                case 2:
                    Order order = new Order(); // 새로운 주문 생성
                    
                    while (true) {
                        menu.displayMenu();
                        System.out.print("\n주문할 메뉴 번호를 입력하세요 (완료: 0): ");
                        int menuChoice = scanner.nextInt();

                        if (menuChoice == 0) { // 주문 완료
                            break;
                        }

                        MenuItem selectedItem = menu.getMenuItem(menuChoice - 1);
                        order.addOrderItem(selectedItem);
                    }

                    order.displayOrder(); // 주문 내역 출력

                    int total = order.calculateTotal();
                    sales.addSales(total); // 매출에 추가

                    break;

                case 3:
                    sales.displayTotalSales(); // 총 매출 출력
                    break;

                case 4:
                    running = false; // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }

        scanner.close();
    }
}