package mini0205;
import java.util.Arrays;
public class toString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]array= {{10,11,12,13,14},
						{20,21,22,23,24},
						{30,31,32,33,34},
						{40,41,42,43,44},
		};
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				int arr= array[i][j];
				System.out.print(arr+" ");
			}
			System.out.println("");
		}
		//String in=Arrays.toString(array);
		//System.out.println(arr);
		
		int[][] a=new int[4][5];
		int num=10;
		/*System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);*/
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				a[i][j]=num;
				System.out.print(a[i][j]+"");
			}
			System.out.println();
		}
		
		
	}

}
