package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BarnPaint {
	static int maxx = 0;
	static int maxy = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] barn = new int[1001][1001];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			maxx = Math.max(x2, maxx);
			maxy = Math.max(y2, maxy);
			for (int j = x1; j < x2; j++) {
				for (int l = y1; l < y2; l++) {
					barn[j][l]++;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= maxx; i++) {
			for (int j = 0; j <= maxy; j++) {
				if (barn[i][j] == k) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
