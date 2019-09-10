
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// DELETE PACKAGE

public class FileReadersWritersETC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("REPLACE.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("REPLACE.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		List<Integer> name = new ArrayList<Integer>();
		
		pw.println();
		pw.close();
	}
	
	static class Pair {
		int x, y;
		public Pair(int a, int b) {
			x=a;
			y=b;
		}
	}
	static class Coord implements Comparable<Coord> {
		int x, y;
		public Coord(int a, int b) {
			x=a;
			y=b;
		}
		
		public int compareTo(Coord o) {
			if (this.x>o.x) {
				return 1;
			} else if (this.x==o.x) {
				if (this.y>o.y) {
					return 1;
				}
				return -1;
			}
			return -1;
		}
	}
}
