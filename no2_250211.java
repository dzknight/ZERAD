package mini0205;

import java.util.Random;
import java.util.Scanner;

public class no2_250211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random=new Random();
		String [] word= {"apple","book","java","oracle","computer","html","dbms","server"};
		
		Scanner scan = new Scanner(System.in); 
		int randomword=0;
		
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					String temp=word[randomword];
					randomword=random.nextInt(7)+1;
					System.out.print(temp+" ");
					String str=scan.next();
					//System.out.print(str+"|"+temp);
					if(str.equalsIgnoreCase(temp)) {
						//System.out.println("정답");
						temp="";
					}
				}
				System.out.println();
			}
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					String temp=word[randomword];
					System.out.print(temp+" ");
					String str=scan.next();
					if(str.equalsIgnoreCase(temp)) {
						System.out.println(" ");
					}
				}
				System.out.println();
			}
			scan.close();
		}
	}


