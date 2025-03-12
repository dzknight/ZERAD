package tryTest;
import java.sql.*;
public class Test {
	public void kkk()  {
		System.out.println("kkk");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void abc() throws InterruptedException {
		System.out.println("a");
		int [] aa=new int[3];
		try {
			System.out.println(aa[2]);
			//System.out.println(aa[4]);
			Test t= null;
			t.kkk();
			// TODO Auto-generated catch block
		} catch (Exception e) {
			System.out.println("예외");
		} finally {
			System.out.println("try구문종료");
		}
		System.out.println("b");
		System.out.println("c");
	}
		//예외 직접처리 방법
		
	}

