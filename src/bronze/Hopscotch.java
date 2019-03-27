package bronze;

import java.util.Scanner;

public class Hopscotch {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String temp=reader.nextLine();
		String[] num=temp.split(" ");
		Integer row=Integer.parseInt(num[0]);
		Integer column=Integer.parseInt(num[num.length-1]);
		char[][] court=new char[row][column];
		for (int i=0; i<row; i++) {
			String next=reader.nextLine();
			for (int j=0; j<column; j++) {
				court[i][j]=next.charAt(j);
			}
			System.out.println();
		}
		reader.close();
	}
}
