package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class IcyPerimeter {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		int n = Integer.parseInt(br.readLine());
		char[][] shape = new char[n][n];
		for (int i = 0; i < n; i++) {
			shape[i] = br.readLine().toCharArray();
		}
		Queue<Blob> q=new ArrayDeque<Blob>();
		boolean[][] vis=new boolean[n][n]; 
		int[][] dis=new int[n][n]; 
		Map<Integer, Blob> blobs=new TreeMap<Integer,Blob>();
		int blob=0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (shape[i][j]=='#') {
					q.add(new Blob(i,j));
					blob++;
					blobs.put(blob, new Blob(i,j));
					while (!q.isEmpty()) {
						Blob s=q.poll();
						for (int k=0; k<4; k++) {
							int mx=dx[k]+s.x;
							int my=dy[k]+s.y;
							if (mx>=0 && my>=0 && mx<n && my<n) {
								if (shape[mx][my]=='#' && dis[mx][my]==0) {
									q.add(new Blob(mx, my));
									Blob curr=blobs.get(blob);
									dis[mx][my]=blob;
									curr.area++;
									int count=0;
									for (int l=0; l<4; l++) {
										int nx=dx[l]+mx;
										int ny=dy[l]+my;
										if (nx>=0 && ny>=0 && nx<=n && ny<=n) {
											if (nx==n || ny==n) {
												count++;
											} else if (shape[nx][ny]=='.') {
												count++;
											}
										}
									}
									curr.peri=curr.peri+count;
								}
							}
						}
					}
				}
			}
		}
		
		int maxa=0; int maxp=0;
		for (int i=0; i<blobs.size(); i++) {
			maxa=Math.max(maxa, blobs.get(i+1).area);
			maxp=Math.max(maxp, blobs.get(i+1).peri);
		}
		pw.print((maxa-1)+" "+(maxp));
	}

	static class Blob implements Comparable<Blob> {
		int area, peri;
		int x, y;
		public Blob(int a, int b) {
			area = 1;
			peri = 0;
			x=a;
			y=b;
		}
		@Override
		public int compareTo(Blob o) {
			if (this.area>o.area) {
				return -1;
			}
			return 1;
		}
		
	}
}
