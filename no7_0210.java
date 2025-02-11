package mini0205;

public class no7_0210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {
				  {11,12,13,14,15},	
				  {20,19,18,17,16},	
				  {21,22,23,24,25},	
				  {30,29,28,27,26},	
				};
		int a[][]=new int[4][5];
		int no=11;
		
		//System.out.println(arr[0][4]);
		//System.out.println(arr[1][4]);
		//System.out.println(arr[2][4]);
		//System.out.println(arr[3][4]);
		//행이 짝수일때 0 2 순열 
		//행이 홀수일때 1 3 끝에서부터 
		
		for(int i=0;i<4;i++) {
			if(i%2==0) {
				for(int j=0;j<a[0].length;j++) {
					
					a[i][j]=no;
					no++;
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			
			if(i%2!=0) {
				for(int j=a.length-1;j>=0;j--) {
					
					a[i][j]=no;//(1,4)
					no++;
					System.out.print(a[i][j]+"");
				}
				
				System.out.println();
				break;
			}
			
		}
	}
}