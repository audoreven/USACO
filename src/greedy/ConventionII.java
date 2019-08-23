package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ConventionII {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -i, 0);
		}
		int time = cows[0].time;
		Arrays.sort(cows);
		PriorityQueue<Cow> line = new PriorityQueue<Cow>();
		line.add(cows[0]);
		int eat = 1;
		int max = 0;
		// actually do stuff
	}

	static class Cow implements Comparable<Cow>, Comparator<Cow> {
		int time, eat, seniority, wait;

		public Cow(int a, int b, int c, int d) {
			time = a;
			eat = b;
			seniority = c;
			wait = d;
		}

		public int compareTo(Cow c) {
			if (this.time > c.time) {
				return 1;
			} else if (this.time == c.time) {
				return 0;
			}
			return -1;
		}

		public int compare(Cow o1, Cow o2) {
			if (o1.seniority > o2.seniority) {
				return 1;
			}
			return -1;
		}
	}
}
