package mini0205;

public class no4_0211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {
						{1,1,0,2},
						{3,2,1,2},
						{0,0,3,2},
						{4,4,4,4},
						{2,4,3,1},
						{2,4,1,3}
					};
		int cnt=0;
		int temp=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<4;j++) {
				//System.out.print(arr[i][j]+" ");
			    
				if(4==arr[i][j]) {
					cnt++;
					temp=arr[i][j];
					System.out.println(arr[i][j]);
				}
				
			}
			System.out.println();
		}
		System.out.println("cnt"+cnt);
	}
}
