package bronze;

import java.util.Scanner;

public class CensoringBronze {
	static int findIndex(String s, String t) {
		for (int i=0; i<s.length()-t.length()+1; i++) {
			if (s.substring(i, i+t.length()).equals(t)) {
				return i;
			}
			else continue;
		}
		return 0;
	}
	static String deleteString(String s, String t) {
		if (s.contains(t)) {
			s=s.substring(0,findIndex(s,t))+s.substring(findIndex(s,t)+t.length());
			return deleteString(s,t);
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String S=reader.nextLine();
		String T=reader.nextLine();
		System.out.println(deleteString(S,T));

		reader.close();
	}
}
