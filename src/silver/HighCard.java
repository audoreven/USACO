package silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HighCard {
	static void sort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	static boolean isIn(int[] arr, int n) {
		for(int i=0; i<arr.length; i++) {
			if (arr[i]==n) {
				return true;
			}
		}
		return false;
	}
	
	static int count(int[] Els, ArrayList<Integer> Bes) {
		int count=0;
		for (int i=0; i<Els.length; i++) {
			for (int j=0; j<Bes.size(); j++) {
				if (Els[i]<Bes.get(j)) {
					Bes.remove(j);
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int cards=reader.nextInt();
		ArrayList<Integer> Bes=new ArrayList<Integer>(cards);
		int[] Elsie=new int[cards];
		for (int i=0; i<cards; i++) {
			Elsie[i]=reader.nextInt();
		}
		sort(Elsie);
		for (int i=1; i<=cards*2; i++) {
			if(isIn(Elsie, i)==false) {
				Bes.add(i);
			}
		}
		System.out.println(Arrays.toString(Elsie));
		System.out.println(Bes);
		System.out.println(count(Elsie, Bes));
		reader.close();
	}
}
