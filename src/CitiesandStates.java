import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CitiesandStates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		Map<String, Long> citystate=new HashMap<String, Long>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String a=st.nextToken().substring(0, 2);
			String b=st.nextToken();
			if (!a.equals(b)) {
				String cs=a+b;
				if (!citystate.containsKey(cs)) {
					citystate.put(cs, 0L);
				}
				citystate.put(cs, citystate.get(cs)+1);
			}
		}
		long ans=0;
		for (String key: citystate.keySet()) {
			String reverse=key.substring(2)+key.substring(0,2);
			if (citystate.containsKey(reverse)) {
				ans += citystate.get(reverse)*citystate.get(key);
			}
		}
		pw.println(ans/2);
		pw.close();
	}
}
