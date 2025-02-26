package carManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarManager  {
	private Car[] cList =new Car[5];
	
	public CarManager() throws NoSuchElementException {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("1.자동차관리 2.전체보기");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
				case 1:add();break;
				case 2:viewAll();break;
				default:break;
			}
		}
		
	}

	private void viewAll() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<cList.length;i++) {
			//System.out.println(cList[i].getCarNo()+" "+cList[i].getCarOwner());
			if(cList[i].toString().isEmpty()) {
				System.out.println("공란");
			} else {
				System.out.println("차번호는"+cList[i].getCarNo());
				System.out.println("차주명은"+cList[i].getCarOwner());
			}
		}
	}

	private void add()  {
		// TODO Auto-generated method stub
		//Car carT[]=new Car[5];
		System.out.println("등록할 차번호를 입력하세요");
		Scanner in=new Scanner(System.in);
		String carNo=in.nextLine();
		System.out.println("등록할 차주명을 입력하세요");
		String carOwner=in.nextLine();
		for(int i=0;i<cList.length;) {
			if(cList[i]==null) {
				cList[i]=new Car();//
				cList[i].setCarNo(carNo);
				cList[i].setCarOwner(carOwner);
				System.out.println("등록한 차주명은"+cList[i].getCarOwner());
				System.out.println("등록된 차번호는"+cList[i].getCarNo());
				break;
			} else {
				System.out.println("빈 공간이 없습니다");
				break;
			}
		}
		
	}
}
