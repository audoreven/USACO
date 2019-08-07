package binarysearchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AngryCows {
	// REVIEW
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] hay=new int[n];
		for (int i=0; i<n; i++) {
			hay[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(hay);
		int min=0;
		int max=50000000;
		while (min<max) {
			int mid=(max+min)/2;
			int use=0;
			int last=0;
			while (last<n) {
				use++;
				int loci=last+1;
				while (loci<n && hay[loci]-hay[last]<=2*mid) {
					loci++;
				}
				last=loci;
			}
			if (use<=k) {
				max=mid;
			} else {
				min=mid+1;
			}
		}
		System.out.println(min);
	}
}
