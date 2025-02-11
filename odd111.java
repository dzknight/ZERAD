package mini0205;

public class odd111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {
				{ 10, 11, 12, 13, 14 },
				{ 20, 21, 22, 23, 24 },
				{ 30, 31, 32, 33, 34 },
				{ 40, 41, 42, 43, 44 }
				};
		int cnt=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(a[i][j]);
				if(a[i][j]%2==0)
					cnt++;
				}
			System.out.println();
		}
		System.out.println(cnt);
	}
}

