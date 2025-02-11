package mini0205;

import java.util.Random;

public class random0210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		
		int num=random.nextInt(5)+1;
	
		
		int[][] a = new int[4][5];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				a[i][j]=random.nextInt(5)+1;
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
		}
	}

}
