package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class LightsOn {
	static boolean[][] on;
	static boolean[][] visited;
	static int[] dx = new int[]{-1,1,0,0};
	static int[] dy = new int[]{0,0,-1,1};
	static ArrayList<Pair>[][] switches;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		String[] temp=br.readLine().split(" ");
		int a=Integer.parseInt(temp[0]);
		int b=Integer.parseInt(temp[1]);
		switches = new ArrayList[a][a];
		on = new boolean[a][a];
		visited = new boolean[a][a];
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a; j++) {
				switches[i][j] = new ArrayList<Pair>();
			}
		}
		for(int i = 0; i < b; i++) {
			String[] temp2=br.readLine().split(" ");
			int x1 = Integer.parseInt(temp2[0])-1;
			int y1 = Integer.parseInt(temp2[1])-1;
			int x2 = Integer.parseInt(temp2[2])-1;
			int y2 = Integer.parseInt(temp2[3])-1;
			switches[x1][y1].add(new Pair(x2, y2));
		}
		LinkedList<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));
		on[0][0] = true;
		// start by searching the top-left corner
		search(0, 0);
		int ret = 0;
		for(boolean[] row: on) {
			for(boolean col: row) {
				if(col) {
					ret++;
				}
			}
		}
		pw.println(ret);
		pw.close();
	}
	public static void search(int x, int y) {
		// if we've already searched this square, don't do it again to save time
		if(isVisited(x, y)) return;
		visited[x][y] = true;
		for(Pair next: switches[x][y]) {
			// step 1 - turn on all squares that Bessie can
			if(!on[next.x][next.y]) {
				on[next.x][next.y] = true;
				if(hasVisitedNeighbor(next.x, next.y)) {
					// this square is next to one Bessie can visit, so go search it
					search(next.x, next.y);
				}
			}
		}
		for(int k = 0; k < dx.length; k++) {
			// check which neighbors of (x, y) are on
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(isOn(nx, ny)) {
				// this is a neighboring square that was already on, so it can be visited
				search(nx, ny);
			}
		}
	}
	/*
	 * Returns true if and only if there is a visited neighbor of (x, y)
	 */
	public static boolean hasVisitedNeighbor(int x, int y) {
		for(int k = 0; k < dx.length; k++) {
			if(isOn(x + dx[k], y + dy[k]) && isVisited(x + dx[k], y + dy[k])) {
				return true;
			}
		}
		return false;
	}
	/*
	 * Returns true if and only if square (x, y) is on.
	 */
	public static boolean isOn(int x, int y) {
		return x >= 0 && x < on.length && y >= 0 && y < on[x].length && on[x][y];
	}
	/*
	 * Returns true if and only if square (x, y) has been visited
	 */
	public static boolean isVisited(int x, int y) {
		return x >= 0 && x < visited.length && y >= 0 && y < visited[x].length && visited[x][y];
	}
	static class Pair{
		int x,y;
		public Pair(int a, int b){
			x=a;
			y=b;
		}
	}
}
