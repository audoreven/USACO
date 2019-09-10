package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CowHerd {
	static int solvemin(int[] cows, int n) {
		if (cows[n - 2] - cows[0] == n - 2 && cows[n - 1] - cows[n - 2] > 2)
			return 2;
		if (cows[n - 1] - cows[1] == n - 2 && cows[1] - cows[0] > 2)
			return 2;
		int i, j = 0, best = 0;
		for (i = 0; i < n; i++) {
			while (j < n - 1 && cows[j + 1] - cows[i] <= n - 1)
				j++;
			best = Math.max(best, j - i + 1);
		}
		return n - best;
	}

	static boolean inorder(int n, int[] cows) {
		return (cows[n - 1] - cows[0]) == n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cows = new int[n];
		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cows);
		System.out.println(solvemin(cows, n));
		System.out.println(Math.max(cows[n - 2] - cows[0], cows[n - 1] - cows[1]) - (n - 2));
	}
}
