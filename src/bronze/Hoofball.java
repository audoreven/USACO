 package bronze;

import java.util.Scanner;

public class Hoofball {
	static void sort(int[] arr) {
		for (int j=0; j<arr.length; j++) {
			for (int i=0; i<arr.length-1; i++) {
				if (arr[i]>arr[i+1]) {
					int temp=arr[i+1];
					arr[i+1]=arr[i];
					arr[i]=temp;
				}
			}
		}
	}
	
	static int[] omit(int[] arr) {
		int[] omtd=new int[arr.length-1];
		int large=0;
		for (int i=0; i<arr.length-1; i++) {
			if (arr[i]<arr[i+1]) {
				large=arr[i+1];
			}
			else {
				large=arr[i];
			}
		}
		for (int k=0; k<arr.length; k++){
			int appear=0;
			if (arr[k]==large) {
				appear++;
			}
			if (appear>1) {
				return arr;
			}
		} 
		int count=0;
		for (int j=0; j<omtd.length; j++) {
			if (arr[j]!=large) {
				omtd[j]=arr[count];
				count++;
			}
			else {
				count++;
			}
		}
		return omtd;
	}
	
	static int count(int[] arr) {
		int count=1;
		int dist=arr[0]; boolean same=true;
		arr=omit(arr);
		for(int i=arr.length-1; i>0; i--) {
			if (dist!=arr[i]) {
				same=false;
			}
			if (arr[i]<arr[i-1]) {
				count++;
				for (int j=0; j<arr.length-1; j++) {
					if (arr[j]==arr[j+1]) {
						return count;
					}
					if (arr[j+1]>arr[j]) {
						return count;
					}
				}
			}
			if (arr[i]==arr[i-1]) {
				count++;
			}
		}
		if (same==true) {
			return 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		Scanner reader2=new Scanner(System.in);
		int cows=reader.nextInt();
		int[] distance=new int[cows];
		String temp=reader2.nextLine();
		if (cows>1) {
			String[] dist=temp.split(" ");
			for(int i=0; i<cows; i++) {
				distance[i]=Integer.parseInt(dist[i]);
			}
			sort(distance); 
			int[] between=new int[cows-1];
			for (int i=0; i<cows-1; i++) {
				between[i]=distance[i+1]-distance[i];
			}
			System.out.println(count(between));
		} 
		else {
			System.out.println(1);
		} 
		reader.close(); 
		reader2.close();

	}
}
