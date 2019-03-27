package bronze;

import java.util.Scanner;

public class EscapingTheFarm {
	static String[] flipArray(String[] arr) {
		for (int i=0; i<(arr.length/2); i++) {
			String temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
		}
		return arr;
	}
	static String[] addZeros(String[] arr) {
		String[] newArr= new String[9];
		for (int i=0; i<arr.length; i++) {
			newArr[i]=arr[i];
		}
		for (int i=arr.length; i<9; i++) {
			newArr[i]="0";
		}
		return newArr;
	}
	static String[][] sortArray(String[][] arr, int index) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				int first=Integer.parseInt(arr[i][index]);
				int second=Integer.parseInt(arr[i+1][index]);
				if (first>second) {
					String[] temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		return arr;
	}
	static String[] splitArray(String str) {
		String[] array= new String[str.length()];
		for (int i=0; i<str.length(); i++) {
			Character ch = str.charAt(i);
			array[i]=ch.toString();
		}
		return array;
	}
	static String[][] removeArray(String[][] arr, int index) {
		int sum=0;
		int row=0;
		for(int i=0; i<arr.length; i++) {
			Integer temp=Integer.parseInt(arr[i][index]);
			sum=sum+temp;
			if (sum>9) {
				row=i;
				break;
			}
		}
		if (sum<10) {
			return arr;
		}
		String[][] newArr=new String[row][];
		for (int j=0; j<row; j++) {
			newArr[j]=arr[j];
		}
		return newArr;
	}
	static int sumOfIndex(String[][] arr, int index) {
		int sum=0;
		for (int i=0; i<arr.length; i++) {
			Integer temp=Integer.parseInt(arr[i][index]);
			sum=sum+temp;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		int cows=reader.nextInt();
		String[] weights = new String[cows];
		int[] weightInt=new int[cows];
		String[][] allFlip=new String[cows][];
		for (int i=0; i<cows; i++) {
			int weight=reader.nextInt();
			weightInt[i]=weight;
			Integer temp= weight;
			weights[i]=temp.toString();
			String[] tempArr= splitArray(weights[i]);
			allFlip[i]=flipArray(tempArr); 
		}
		
		for (int i=0; i<allFlip.length; i++) {
			allFlip[i]=addZeros(allFlip[i]);
			/*for (int j=0; j<allFlip[i].length; j++) {
				System.out.print(allFlip[i][j]);
			}*/
		}
		for (int i=allFlip[0].length-1; i>=0; i--) {
			allFlip=sortArray(allFlip, i);
			if (sumOfIndex(allFlip, i)>9) {
				allFlip=removeArray(allFlip,i); 
			}
		}
		
		System.out.println(allFlip.length);
		
		reader.close();
	}
}
