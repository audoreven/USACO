package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Stampede {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Pair> timetaken=new ArrayList<Pair>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()) *-1;
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			timetaken.add(new Pair((long) (a*c), b));
		}
		Collections.sort(timetaken);
		int cowssaw=0;
		for (int i=0; i<timetaken.size()-1; i++) {
			if (timetaken.get(0).time==timetaken.get(1).time) {
				timetaken.remove(0);
			} else if (timetaken.get(0).time==timetaken.get(1).time+1) {
				cowssaw++;
				if (timetaken.get(0).y<timetaken.get(1).y) {
					timetaken.remove(0);
					timetaken.remove(1);
				} else {
					timetaken.remove(0);
				}
			} else {
				cowssaw++;
			}
		}
		System.out.println(cowssaw);
	}
	static class Pair implements Comparable<Pair>{
		long time;
		int y;
		public Pair(long a, int b) {
			time=a;
			y=b;
		}
		public int compareTo(Pair p) {
			if (this.time>p.time) {
				return 1;
			} else if (this.time==p.time) {
				if (this.y<p.y) {
					return 1;
				} else {
					return -1;
				}
			}
			return -1;
		}
	}
}
