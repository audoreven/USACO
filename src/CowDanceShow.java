import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CowDanceShow {
	//simulate with priority queue
	static boolean work(int k, int[] c, int t) {
		int last=0;
		PriorityQueue<Integer> stage =  new PriorityQueue<Integer>();
		for (int i=0; i<c.length; i++) {
			if (stage.size()==k) {
				last=stage.poll();
			} 
			if (last+c[i]>t) {
				return false;
			}
			stage.add(c[i]+last);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		int[] cows=new int[n];
		for (int i=0; i<n; i++) {
			cows[i]=Integer.parseInt(br.readLine());
		}
		int min=1; int max=n;
		while (min!=max) {
			int mid=(max+min)/2;
			if (work(mid, cows, t)) {
				max=mid;
			} else {
				min=mid+1;
			}
		}
		pw.println(min);
		pw.close();
	}
}
