package bronze;

import java.util.Scanner;

public class EscapingTheFarmRedo {
	static int best=0;
	static int sumOfDigits(int n) {
		if (n!=0) {
			return n%10+sumOfDigits(n/10);
		}
		return n;
	}
	
	static void check(int[] arr) {
		int sum=0;
		int sumDigits=0;
		for (int i=0; i<arr.length; i++) {
			sum=arr[i]+sum;
			sumDigits=sumDigits+sumOfDigits(arr[i]);
		}
		if (sumOfDigits(sum)==sumDigits) {
			int count=0;
			for (int i=0; i<arr.length; i++) {
				if (arr[i]!=0) {
					count++;
				}
			}
			if (count>best) {
				best=count;
			}
		}
	}
	
	static int numberOfPossibilities(int n) {
		if (n==0) {
			return 1;
		}
		return 2*numberOfPossibilities(n-1);
	}
	
	static void checkPossibilities(int n, int length, int[] arr) {
		int[] possibilities=new int[length];
		int[] numbers=new int[length];
		for (int i=1; i<=n; i++) {
			possibilities=convertBinary(i, length);
			for (int j=0; j<length; j++) {
				if (possibilities[j]!=0) {
					numbers[j]=arr[j];
				}
				else {
					numbers[j]=0;
				}
			}
			check(numbers);
		}
	}
	
	static int[] convertBinary(int number, int length) {
		int[] arr=new int[length];
		int count=0;
		while (number!=0) {
			int remainder=number%2;
			number=number/2;
			arr[count]=remainder;
			count++;
		}
		return arr;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		int cows=reader.nextInt();
		int[] weights = new int[cows];
		for (int i=0; i<cows; i++) {
			int weight=reader.nextInt();
			weights[i]=weight;
		}
		int ToCheck=numberOfPossibilities(weights.length)-1;
		checkPossibilities(ToCheck, cows, weights);
		System.out.println(best);
		reader.close();
	}
}
