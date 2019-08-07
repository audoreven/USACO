package binarysearchandsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CowDanceShow {
	// REVIEW
	static boolean possible(int[] shows, int k, int t) {
		int lastT=0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < shows.length; i++) {
			if (q.size()==k) {
				lastT=q.poll();
			}
			if (lastT+shows[i]>t) {
				return false;
			}
			q.add(shows[i]);
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] shows = new int[n];
		for (int i = 0; i < n; i++) {
			shows[i] = Integer.parseInt(br.readLine());
		}
		int min = 1;
		int max = n;
		while (min != max) {
			int mid = (max + min) / 2;
			if (possible(shows, mid, t)) {
				max=mid;
			} else {
				min=mid+1;
			}
		}
		System.out.println(min);
	}
}
