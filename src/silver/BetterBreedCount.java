package silver;

import java.util.Scanner;

// using prefix sum

public class BetterBreedCount {
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		Scanner reader2=new Scanner(System.in);
		String cowsANDinterval=reader.nextLine();
		String[] num=cowsANDinterval.split(" ");
		int cows=Integer.parseInt(num[0]);
		int interv=Integer.parseInt(num[1]);
		int[][] prefix=new int[4][cows+1];
		for (int i=1; i<cows+1; i++) {
			int cur=reader.nextInt();
			for (int j=1; j<4; j++) {
				prefix[j][i]=prefix[j][i-1];
			}
			prefix[cur][i]++;
		}
		for (int i=0; i<interv; i++) {
			String temp=reader.nextLine();
			String[] intervals=temp.split(" ");
			int a=Integer.parseInt(intervals[0]);
			int b=Integer.parseInt(intervals[1]);
			System.out.println((prefix[1][b]-prefix[1][a])+" "+(prefix[2][b]-prefix[2][a])+" "+(prefix[3][b]-prefix[3][a]));
		}
		reader.close();
		reader2.close();
	}
}
