import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Pair[] cows = new Pair[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			Queue<Pair> q = new ArrayDeque<Pair>();
			boolean[] vis = new boolean[n];
			q.add(cows[i]);
			vis[i] = true;
			int tempans = 1;
			while (!q.isEmpty()) {
				Pair a = q.poll();
				for (int j = 0; j < n; j++) {
					if (!vis[j]) {
						int start=cows[j].x-a.x;
						int end=cows[j].y-a.y;
						if ((a.radius * a.radius) >= (start*start) + (end*end)) {
							vis[j]=true;
							q.add(cows[j]);
							tempans++;
						}
					}
				}
			}
			ans = Math.max(ans, tempans);
		}
		System.out.println(ans);
	}

	static class Pair {
		int x, y, radius;

		public Pair(int a, int b, int r) {
			x = a;
			y = b;
			radius = r;
		}
	}
}
