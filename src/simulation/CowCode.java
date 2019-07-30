package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowCode {
	static int reduce(int str, long l) {
		int stl=str;
		while (stl<l) {
			stl *=2;
		}
		while (l>str) {
			if (l==(stl/2)+1) {
				l--;
			} else {
				l -= ((stl)/2+1);
			} 
		}
		return (int) l-1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		long l = Integer.parseInt(st.nextToken());
		int stl=s.length();
		System.out.println(s.charAt(reduce(stl, l)));
		
	}
}
