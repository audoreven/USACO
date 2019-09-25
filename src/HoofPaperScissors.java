import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HoofPaperScissors {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int[] moves=new int[n];
		int[][] prefix=new int[3][n+1];
		int[][] suffix=new int[3][n+1];
		for (int i=1; i<=n; i++) {
			for (int j=0; j<3; j++) {
				prefix[j][i]=prefix[j][i-1];
			}
			if (br.readLine().equals("H")) {
				moves[i-1]=0;
			} else if (br.readLine().equals("P")) {
				moves[i-1]=1;
			} else {
				moves[i-1]=2;
			}
			prefix[moves[i-1]][i]++;
		}
		for (int i=1; i<=n; i++) {
			for (int j=0; j<3; j++) {
				suffix[j][i]=suffix[j][i-1];
			}
			suffix[moves[n-i]][i]++;
		}
		int max=0;
		for (int k=1; k<=n; k++) {
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					max=Math.max(suffix[j][n-k]+prefix[i][k], max);
				}
			}
		}
		pw.println(max);
		pw.close();
	}
}
