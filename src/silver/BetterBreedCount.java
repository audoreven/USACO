package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// import java.util.StringTokenizer;

public class BetterBreedCount {
	public static void main(String[] args) {
		BufferedReader br;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("src/bcount.in"));

			pw = new PrintWriter(new BufferedWriter(new FileWriter("src/bcount.out")));
			// StringTokenizer st = new StringTokenizer(br.readLine());
			// int n = Integer.parseInt(st.nextToken());
			// int q = Integer.parseInt(st.nextToken());
			String[] tokens = br.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int q = Integer.parseInt(tokens[1]);
			int[][] prefix = new int[4][n + 1];
			for (int i = 1; i <= n; i++) {
				int curr = Integer.parseInt(br.readLine());
				// shift over the prefix sums for each value from 1 to 3
				for (int j = 1; j <= 3; j++) {
					prefix[j][i] = prefix[j][i - 1];
				}
				// increment the prefix sum for the number that we read in
				prefix[curr][i]++;
			}
			for (int i = 0; i < q; i++) {
				// st = new StringTokenizer(br.readLine());
				// int a = Integer.parseInt(st.nextToken());
				// int b = Integer.parseInt(st.nextToken());
				String[] temp = br.readLine().split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);
				pw.println((prefix[1][b] - prefix[1][a - 1]) + " " + (prefix[2][b] - prefix[2][a - 1]) + " "
						+ (prefix[3][b] - prefix[3][a - 1]));
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found...");
		} finally {
			System.out.println("I am closing....");
			pw.close();
		}
	}
}
