import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowCode {
	static char find(long n, String c) {
		if (n<c.length()) {
			return c.charAt((int) (n-1));
		}
		long l = c.length();
		while (2*l <= n) {
			l *= 2;
		}
		if (l==n) {
			return find(n-1,c);
		}
		return find(n-l-1,c);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String code = st.nextToken();
		long n = Long.parseLong(st.nextToken());
		pw.println(find(n, code));
		pw.close();
	}
}
