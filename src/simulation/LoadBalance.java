package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LoadBalance {
	// REVIEW
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("REPLACE.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("REPLACE.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Coord[] cows = new Coord[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);
		int ret = cows.length;
		for (int i = 0; i < n; i++) {
			ArrayList<Coord> below = new ArrayList<Coord>();
			ArrayList<Coord> above = new ArrayList<Coord>();
			for (int j = 0; j < n; j++) {
				if (cows[j].y <= cows[i].y) {
					below.add(cows[j]);
				} else {
					above.add(cows[j]);
				}
			}
			int belowIndex = 0;
			int aboveIndex = 0;
			while (belowIndex < below.size() || aboveIndex < above.size()) {
				int xBorder = Integer.MAX_VALUE;
				if (belowIndex < below.size()) {
					xBorder = Math.min(xBorder, below.get(belowIndex).x);
				}
				if (aboveIndex < above.size()) {
					xBorder = Math.min(xBorder, above.get(aboveIndex).x);
				}
				while (belowIndex < below.size() && below.get(belowIndex).x == xBorder) {
					belowIndex++;
				}
				while (aboveIndex < above.size() && above.get(aboveIndex).x == xBorder) {
					aboveIndex++;
				}
				ret = Math.min(ret, Math.max(Math.max(belowIndex, below.size() - belowIndex),
						Math.max(aboveIndex, above.size() - aboveIndex)));
			}
		}
		pw.println(ret);
		pw.close();

	}

	static class Coord implements Comparable<Coord> {
		int x, y;

		public Coord(int a, int b) {
			x = a;
			y = b;
		}

		public int compareTo(Coord o) {
			if (this.x > o.x) {
				return 1;
			} else if (this.x == o.x) {
				if (this.y > o.y) {
					return 1;
				}
				return -1;
			}
			return -1;
		}
	}
}
