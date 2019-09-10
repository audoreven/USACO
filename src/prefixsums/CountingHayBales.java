package prefixsums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingHayBales {
	static int search(int[] b, int q) {
		if (q<b[0]) {
			return 0;
		}
		int low=0;
		int high=b.length;
		while (low < high) {
			int mid = (low + high + 1) / 2;
			if (b[mid] <= q) {
				low = mid;
			} else if (b[mid] > q) {
				high = mid - 1;
			} 
		}
		return high+1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] bales = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			bales[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(bales);
		for (int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
	//		int b=Integer.parseInt(st.nextToken());
			int b=search(bales, Integer.parseInt(st.nextToken())-1);
	//		int a=Integer.parseInt(st.nextToken());
			int a=search(bales, Integer.parseInt(st.nextToken()));
			System.out.println(a-b);
		}

	//	pw.close();
	}
}
