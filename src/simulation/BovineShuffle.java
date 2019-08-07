package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BovineShuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] moves = new int[n + 1];
		int[] posi = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			moves[i + 1] = a;
			posi[a]++;
		}
		int ans=n;
		Queue<Integer> q=new ArrayDeque<Integer>();
		for (int i=1; i<=n; i++) {
			if (posi[i]==0) {
				q.add(i);
				ans--;
			}
		}
		while (!q.isEmpty()) {
			int a=q.poll();
			posi[moves[a]]--;
			if (posi[moves[a]]==0) {
				ans--;
				q.add(moves[a]);
			}
		}
		System.out.println(ans);
	}
}
