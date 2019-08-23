package dfsorbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MooyoMooyo {
	// bfs
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] gravity(int[][] grid) {
		return grid;
	}
	static boolean done(int[][] grid) {
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] grid = new int[n][10];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 10; j++) {
				grid[i][j] = Integer.parseInt(temp.substring(i, i + 1));
			}
		}
		while (!done(grid)) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (grid[i][j]!=0) {
						Queue<Posi> q = new ArrayDeque<Posi>();
						boolean[][] vis=new boolean[n][10];
						q.add(new Posi(i,j));
					}
					
				}
			}
		}
	}
	static class Posi {
		int x,y;
		public Posi(int a, int b) {
			x=a;
			y=b;
		}
	}
}
