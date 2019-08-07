package dfsorbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BuildGate {
	// TBC
	static int[] mx = { -1, 0, 1, 0 };
	static int[] my = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String tem = br.readLine();
		int[] moves = new int[n];
		int[][] field = new int[2005][2005];
		int start = 1002;
		int end = 1002;
		field[start][end] = -1;
		for (int i = 0; i < n; i++) {
			if (tem.charAt(i) == 'N') {
				moves[i] = 0;
			} else if (tem.charAt(i) == 'E') {
				moves[i] = 1;
			} else if (tem.charAt(i) == 'S') {
				moves[i] = 2;
			} else {
				moves[i] = 3;
			}
			// why?
			for (int j=0; j<2; j++) { 
				start += mx[moves[i]];
				end += my[moves[i]];
				field[start][end] = -1;
			}
		}
		Queue<Position> q = new ArrayDeque<Position>();
		int regions = 0;
		for (int i = 0; i < 2005; i++) {
			for (int j = 0; j < 2005; j++) {
				if (field[i][j] == 0) {
					q.add(new Position(i, j));
					regions++;
					field[i][j] = regions;
					while (!q.isEmpty()) {
						Position curr = q.poll();
						for (int k = 0; k < 4; k++) {
							int dx = mx[k] + curr.x;
							int dy = my[k] + curr.y;
							if (dx >= 0 && dy >= 0 && dx < 2005 && dy < 2005) {
								if (field[dx][dy] == 0) {
									q.add(new Position(dx, dy));
									field[dx][dy] = regions;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(regions-1);
	}

	static class Position {
		int x, y;

		public Position(int a, int b) {
			x = a;
			y = b;
		}
	}
}
