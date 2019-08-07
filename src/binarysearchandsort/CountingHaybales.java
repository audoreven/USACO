package binarysearchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingHaybales {
	// REVIEW
	static int search(int n, int[] hay) {
		int h = hay.length - 1;
		int l = 0;
		if (hay[0] > n) {
			return 0;
		}
		while (h > l) {
			int mid = (h + l + 1) / 2;
			if (hay[mid] <= n) {
				l = mid;
			} else {
				h = mid - 1;
			}
		}
		return h + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] loci = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			loci[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(loci);
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = search(Integer.parseInt(st.nextToken()) - 1, loci);
			int b = search(Integer.parseInt(st.nextToken()), loci);
			System.out.println(b - a);
		}
	}
}
