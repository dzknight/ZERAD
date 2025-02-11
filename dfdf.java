package mini0205;

public class dfdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[4][5];

		int num=1;
		
		//배열순회 값 입력
		for(int i=4; i<a.length; i--) {
			System.out.println();
			for(int j=3; j<a[0].length; j--) {
				a[i][j]=num;
				num=num+1;
			}
		}
			//System.out.println();
		//배열 순회 값 출력
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		}
	
	}


