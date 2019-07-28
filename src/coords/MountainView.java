package coords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MountainView {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Peak> peaks = new ArrayList<Peak>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			peaks.add(new Peak(a, b));
		}
		Collections.sort(peaks);
		int currx=-1;
		for (int i=0; i<n; i++) {
			int temp=peaks.get(i).x;
			if (temp!= currx){
				currx=temp;
			} else {
				peaks.remove(i);
			}
		}
		for (int i=0; i<peaks.size()-1; i++){
			int x=peaks.get(i).x;
			int y=peaks.get(i).y;
			if (Math.abs(peaks.get(i+1).y-y)>=Math.abs(peaks.get(i+1).x-x)) {
				if (peaks.get(i+1).y>y) {
					peaks.remove(i);
				} else {
					peaks.remove(i+1);
				}
				i--;
			}
		}
		System.out.println(peaks.size());
	}

	static class Peak implements Comparable<Peak> {
		int x, y;

		public Peak(int a, int b) {
			x = a;
			y = b;
		}

		public int compareTo(Peak p) {
			if (this.x > p.x) {
				return 1;
			} else if (this.x == p.x) {
				if (this.y < p.x) {
					return 1;
				}
				return -1;
			}
			return -1;
		}
	}
}
