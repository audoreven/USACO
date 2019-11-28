package binarysearchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Convention {
	static boolean work(int[] times, int t, int m, int c) {
		int bus = 1;
		int first = times[0];
		int onbus = 0;
		for (int i = 1; i < times.length; i++) {
			if (times[i] - first > t || i+1-onbus > c) {
				bus++;
				first = times[i];
				onbus=i;
			}
		}
		if (bus <= m) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] times = new int[n];
		for (int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);
		int min = 0;
		int max = times[n - 1];
		while (min < max) {
			int mid = (min + max) / 2;
			if (work(times, mid, m, c)) {
				max = mid;
			} else {
				min = mid+1;
			}
		}
		System.out.println(min);
		System.out.println(max);
	}
}
