package mini0205;

public class to3040 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {
				{ 10, 11, 12, 13, 14 },
				{ 20, 21, 22, 23, 24 },
				{ 30, 31, 32, 33, 34 },
				{ 40, 41, 42, 43, 44 }
				};
		
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[0].length;j++) {
					if(a[i][j]<=30 || a[i][j]>=40  ) {
						a[i][j]=0;
					}
					System.out.print(a[i][j]+" ");
				}
				System.out.println(" ");
			}
	}

}
