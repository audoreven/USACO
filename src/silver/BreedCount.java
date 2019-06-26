package silver;

import java.util.Scanner;

public class BreedCount {
	static int[] count(int[] breed, int[] interv) {
		int s=interv[0]-1;
		int e=interv[1];
		int[] cowsInInt=new int[3];
		for (int i=s; i<e; i++){
			if (breed[i]==1) {
				cowsInInt[0]++;
			}
			else if (breed[i]==2) {
				cowsInInt[1]++;
			}
			else if (breed[i]==3) {
				cowsInInt[2]++;
			}
		}
		return cowsInInt;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		Scanner reader2=new Scanner(System.in);
		String cowsANDinter=reader.nextLine();
		String[] num=cowsANDinter.split(" ");
		int cows=Integer.parseInt(num[0]);
		int interv=Integer.parseInt(num[1]);
		int[] breed=new int[cows];
		int[][] intervals=new int[interv][2];
		for (int i=0; i<cows; i++) {
			breed[i]=reader2.nextInt();
		}
		for (int j=0; j<interv; j++) {
			String[] temp=reader.nextLine().split(" ");
			for (int k=0; k<2; k++) {
				intervals[j][k]=Integer.parseInt(temp[k]);
			}
		}
		for (int i=0; i<interv; i++) {
			int[] temp=count(breed, intervals[i]);
			for (int j=0; j<3; j++) {
				System.out.print(temp[j]+" ");
			}
			System.out.println();
		}
		reader.close();
		reader2.close();
	}
}
