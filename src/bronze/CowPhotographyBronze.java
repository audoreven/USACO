package bronze;

import java.util.Scanner;


public class CowPhotographyBronze {
	static int compare(int[][] arr, int length) {
		int count=0;
		int number=0;
		for (int i=1; i<5; i++) {
			if (arr[i][1]==arr[i-1][1]) {
				number=arr[i][1];
				count++;
			}
		}
		if (count>=(length/2)){
			return number;
		}
		else return -1;
	}
	static int printNextInt(int[][] arr, int length, int number) {
		int count=0;
		int next=0;
		for (int j=0; j<length-1; j++) {
			if (arr[0][j]==number) {
				next=arr[0][j+1];
				break;
			}
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<length-1; j++) {
				if (arr[i][j]==number && next==arr[i][j+1]) {
					count++;
				}
			}
		}
		if (count>=length/2) {
			return next;
		}
		else {
		for (int i=1; i<5; i++) {
			for (int j=1; j<length; j++)
				if (arr[i][j-1]==number && arr[i][j]!=next){
					next=arr[i][j];
					return next;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int cows=reader.nextInt();
		int[][] pics=new int[5][cows];
		for (int i=0; i<5; i++) {
			for (int j=0; j<cows; j++) {
				pics[i][j]=reader.nextInt();
			}
		}
		int first=compare(pics, cows);
		System.out.println(first);
		
		for (int i=0; i<cows-1; i++) {
			if (printNextInt(pics,cows, first)!=-1) {
				int next=printNextInt(pics, cows, first);
				first=next;
				System.out.println(next);
			}
		}
		reader.close();
	}
	
}

