package mini0205;

public class array02101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][5];
		//int num=10;
		int num=11;
		
		//배열순회 값 입력
		for(int j=0; j<a[0].length; j++) {
		for(int i=0; i<a.length; i++) {
			
				a[i][j]=num;
				num++;
			}
			//System.out.println();
		}
		//배열 순회 값 출력
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		int arr[][] = {
					  {29,25,21,17,13},	
					  {28,24,20,16,12},	
					  {27,23,19,15,11},	
					  {26,22,18,14,10},	
					};
		
		
		
		
		
	}
}
