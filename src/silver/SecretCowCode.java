package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SecretCowCode {
	static char right(String s, long n) {
		if (n<s.length()) {
			return s.charAt((int) n);
		}
		long length=s.length();
		while(length*2<=n) {
			length=length*2;
		}
		if (length==n) {
			return right(s, length-1);
		}
		return right(s, n-length-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		String[] data=br.readLine().split(" ");
	//	Scanner reader=new Scanner(System.in);
	//	String[] data=reader.nextLine().split(" ");
		long character=Long.parseLong(data[1])-1;
		String word=data[0];
		// print out for whatever is at the place u wanted
		pw.print(right(word, character));
		pw.close();
	}
}
