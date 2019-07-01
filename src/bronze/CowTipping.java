package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CowTipping {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		int rows=Integer.parseInt(br.readLine());
		int[][] cows=new int[rows][rows];
		for (int i=0; i<rows; i++) {
			String[] temp=br.readLine().split(" ");
			int[] temp2=new int[rows];
			for (int j=0; j<rows; j++) {
				temp2[j]=Integer.parseInt(temp[j]);
			}
			cows[i]=temp2;
		}
		int count=0;
		for (int i=rows-1; i>=0; i++) {
			for (int j=rows-1; j>=0; j++) {
				if (cows[i][j]==1) {
					count++;
					for (int a=0; a<=i; i++) {
						for (int b=0; b<=j; b++) {
							if (cows[a][b]==1) {
								cows[a][b]=0;
							}
							else {
								cows[a][b]=1;
							}
						}
					}
				}
			}
		}
		pw.println(count);
		pw.close();
	}
}
