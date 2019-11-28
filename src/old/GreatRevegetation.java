package old;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GreatRevegetation {
	static boolean possible=true;
	static int[] pasture = new int[10001];
	
	static void vis(int n, int g, ArrayList<Integer>[] s, ArrayList<Integer>[] d) {
		if (pasture[n]==0) {
			pasture[n]=g;
		}
		for (int x: s[n]) {
			if (pasture[x]!=g) {
				possible=false;
			}
			vis(x, g, s, d);
		}
		for (int x: d[n]) {
			if (pasture[x]==g) {
				possible=false;
			}
			vis(x, 3-g, s, d);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer=0;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] same = new ArrayList[n];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] dif = new ArrayList[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (s.equals("S")) {
				same[a] = new ArrayList<Integer>();
				same[a].add(b);
				same[b] = new ArrayList<Integer>();
				same[b].add(a);
			} else {
				dif[a] = new ArrayList<Integer>();
				dif[a].add(b);
				dif[b] = new ArrayList<Integer>();
				dif[b].add(a);
			}
		}
		for (int i=0; i<n; i++) {
			if (pasture[i]==0) {
				vis(i, 1, same, dif);
				answer++;
			}
		}
		if (!possible) {
			pw.println(0);
		}
		else {
			pw.print(1);
			for (int i=0; i<answer; i++) {
				pw.print(0);
			}
		}
		pw.close();
		br.close();
	}
}
