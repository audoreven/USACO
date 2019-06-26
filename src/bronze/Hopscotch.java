package bronze;

import java.util.Scanner;

public class Hopscotch {
	static int count=0;
	static void possibilities(char first, char[][] court, int startrow, int row, int startcolumn, int column) {
		if(row==1 && column==1) {
			count++;
		}
		else if (row>1 && column>1) {
			for (int i=1; i<row; i++) {
				for (int j=1; j<column; j++) {
					if (court[i+startrow][j+startcolumn]!=first) {
						possibilities(court[i][j], court, i+startrow, row-i, j+startcolumn, column-j);
					}
				}
			}
		}
	}
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
		}
		char firstone=court[0][0];
		possibilities(firstone, court, 0, row, 0, column);
		System.out.println(count);
		reader.close();
	}
}
