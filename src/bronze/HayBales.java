package bronze;

import java.util.Scanner;

public class HayBales {
	static int average(int[] arr) {
		int sum=0;
		for (int i=0; i<arr.length; i++) {
			sum=sum+arr[i];
		}
		return sum/arr.length;
	}
	static int move(int average, int[] arr) {
		int sum=0; 
		for (int i=0; i<arr.length; i++) {
			sum=sum+Math.abs(arr[i]-average);
		}
		return sum/2;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int length=reader.nextInt();
		if (length>=1 && length<=10000) {
		int[] piles=new int[length];
		for (int i=0; i<piles.length; i++) {
			int stacks=reader.nextInt();
			piles[i]=stacks;
		}
		System.out.println(move(average(piles),piles));
		}
		else {System.out.println("Out of Bounds");};
		reader.close();
	}
}
