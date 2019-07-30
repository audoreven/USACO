package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RentalService {
	// greedy
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] gallons = new int[n];
		Sale[] store = new Sale[m];
		int[] rentals = new int[r];
		for (int i = 0; i < n; i++) {
			gallons[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(gallons);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			store[i] = new Sale(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		long[] profits = new long[n + 1];
		int p = m - 1;
		Arrays.sort(store);
		for (int i = 0; i < n; i++) {
			profits[i + 1] = profits[i];
			while (p >= 0 && gallons[n-i-1] > 0) {
				int use = Math.min(gallons[n-1-i], store[p].gal);
				profits[i + 1] = profits[i + 1] + (use * store[p].per);
				store[p].gal -= use;
				gallons[n-1-i] -= use;
				if (store[p].gal == 0) {
					p--;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			rentals[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rentals);
		int q=r-1;
		int a=n-1;
		long rents=0;
		while (a>=0 && q>=0) {
			rents+=rentals[q];
			profits[a]+=rents;
			a--; q--;
		}
		long ans=0;
		for (int i=0; i<n; i++) {
			ans=Math.max(profits[i+1], ans);
		}
		System.out.println(ans);
	}

	static class Sale implements Comparable<Sale> {
		int gal, per, prof;

		public Sale(int x, int y) {
			gal = x;
			per = y;
		}

		public int compareTo(Sale s) {
			if (this.per > s.per) {
				return 1;
			} else if (this.per == s.per) {
				return 0;
			}
			return -1;
		}

	}
}
