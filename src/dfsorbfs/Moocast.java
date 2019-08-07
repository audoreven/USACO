package dfsorbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Moocast {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Cow[] cows = new Cow[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new ArrayDeque<Integer>();
			boolean[] vis = new boolean[n];
			int temp = 1;
			vis[i] = true;
			q.add(i);
			while (!q.isEmpty()) {
				int a = q.poll();
				for (int j = 0; j < n; j++) {
					if (j != i && !vis[j]) {
						int x = Math.abs(cows[j].x - cows[a].x);
						int y = Math.abs(cows[j].y - cows[a].y);
						if (x * x + y * y < cows[a].rad * cows[a].rad) {
							q.add(j);
							temp++;
							vis[j] = true;
						}
					}
				}
			}
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}

	static class Cow {
		int x, y, rad;

		public Cow(int a, int b, int c) {
			x = a;
			y = b;
			rad = c;
		}
	}
}
